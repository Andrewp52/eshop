package com.pashenko.ehop.services;

import com.pashenko.ehop.entities.dto.UserRegDto;
import com.pashenko.ehop.entities.userdata.User;
import com.pashenko.ehop.entities.userdata.UserAddress;
import com.pashenko.ehop.entities.userdata.UserPhone;
import com.pashenko.ehop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUserName(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format("Username: %s not found", username))
                );
    }

    @Override
    public User registerNewUser(UserRegDto dto) throws EntityExistsException {
        if(userRepository.getUserByUserName(dto.getUserName()).isPresent()){
            throw new EntityExistsException("User is already exist");
        }
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAddresses(Set.of(new UserAddress(dto.getAddress(), "")));
        user.setPhones(Set.of(new UserPhone(dto.getPhone(), "")));
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userRepository.save(user);
    }


}
