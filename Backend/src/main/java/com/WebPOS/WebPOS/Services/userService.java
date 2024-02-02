package com.WebPOS.WebPOS.Services;

import com.WebPOS.WebPOS.DTO.userDTO;
import com.WebPOS.WebPOS.Entities.User;
import com.WebPOS.WebPOS.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service // to create service

public class userService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return user;
    }
    public User findUserByEmail(String email){
        return  userRepository.findByEmail(email);
    }
    public Object getUserProfile(String email){
       Optional<userDTO> userData=userRepository.findNameAndIdByEmail(email);

          return  userData;

    }
    public void save(User user){
        userRepository.save(user);
    }
}
