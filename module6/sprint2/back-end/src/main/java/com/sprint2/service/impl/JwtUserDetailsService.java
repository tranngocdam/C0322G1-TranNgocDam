package com.sprint2.service.impl;

import com.sprint2.model.AppUsers;
import com.sprint2.model.UserRole;
import com.sprint2.repository.IAppUsersRepository;
import com.sprint2.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IAppUsersRepository userRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    /**
     * It overrides the loadUserByUsername for fetching user details from the database using the username
     * @param username
     * @return User
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUsers appUser = userRepository.findAppUserByName(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        List<UserRole> userRoles = userRoleRepository.findAllByAppUsers(appUser);

        List<GrantedAuthority> grantList = new ArrayList<>();

        if (userRoles != null) {
            for (UserRole item: userRoles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(item.getAppRole().getRoleName());
                grantList.add(authority);
            }
        }
        return new User(appUser.getUsername(), appUser.getPassword(), grantList);
    }
}
