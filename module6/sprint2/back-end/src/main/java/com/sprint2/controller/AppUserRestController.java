package com.sprint2.controller;

import com.sprint2.model.AppRole;
import com.sprint2.model.AppUsers;
import com.sprint2.model.Customer;
import com.sprint2.model.UserRole;
import com.sprint2.service.IAppRoleService;
import com.sprint2.service.IAppUserService;
import com.sprint2.service.ICustomerService;
import com.sprint2.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/public/app-user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppUserRestController {
    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IAppRoleService iAppRoleService;

    @Autowired
    private ICustomerService iCustomerService;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAppUser(@RequestBody @Valid AppUsers appUser) {
        appUser.setPassword(passwordEncoder().encode(appUser.getPassword()));
        appUser.setCreateDate(LocalDate.now());
        appUser.setStatus(false);
        iAppUserService.save(appUser);
        UserRole userRole = new UserRole();
        List<AppRole> appRoles = iAppRoleService.findAllAppRole();
        userRole.setAppRole(appRoles.get(1));
        userRole.setAppUsers(appUser);
        iUserRoleService.save(userRole);
        List<AppUsers> appUsers = iAppUserService.findAll();
        Customer customer = new Customer();
        customer.setAppUsers(appUsers.get(appUsers.toArray().length - 1));
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{username}")
    public ResponseEntity<AppUsers> getUser(@PathVariable String username) {
        AppUsers appUser = iAppUserService.findByName(username);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
}
