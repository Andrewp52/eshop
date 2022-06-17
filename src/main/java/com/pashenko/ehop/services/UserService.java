package com.pashenko.ehop.services;

import com.pashenko.ehop.entities.dto.UserRegDto;
import com.pashenko.ehop.entities.userdata.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    User registerNewUser(UserRegDto dto);
}
