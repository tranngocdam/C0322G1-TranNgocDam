package com.sprint2.controller;

import com.sprint2.config.JwtTokenUtil;
import com.sprint2.model.JwtRequest;
import com.sprint2.model.JwtResponse;
import com.sprint2.model.MessageResponse;
import com.sprint2.service.IAppUserService;
import com.sprint2.service.impl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IAppUserService appUserService;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Function: Expose a POST API /authenticate
     * @param  authenticationRequest
     * @return HTTP status code 401 (UNAUTHORIZED)
     * HTTP status code 200 (OK): return JwtResponse
     */
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        System.out.println(authenticationRequest.getUsername());
        if (authenticationRequest.getUsername() == null || authenticationRequest.getPassword() == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        if (userDetails == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token, roles, userDetails.getUsername()));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> reset(@RequestBody JwtRequest authenticationRequest) throws MessagingException, UnsupportedEncodingException, MessagingException {
        if (appUserService.existsByUserName(authenticationRequest.getUsername()) != null) {
            return ResponseEntity.ok(new MessageResponse("Sent email "));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không đúng"));
    }

    @PostMapping("/do-reset-password/{name}")
    public ResponseEntity<?> doResetPassword(@RequestBody JwtRequest authenticationRequest,
                                             @PathVariable String name) {
        if (!Objects.equals(authenticationRequest.getPassword(), "")) {
            appUserService.saveNewPassword(passwordEncoder().encode(authenticationRequest.getPassword()), name);
            return ResponseEntity.ok(new MessageResponse("success"));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Mật khẩu mới không được để trống!"));
    }
}
