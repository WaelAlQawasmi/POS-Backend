package com.WebPOS.WebPOS.Services;

import com.WebPOS.WebPOS.Entities.User;
import com.WebPOS.WebPOS.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


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
    public void save(User user){
        userRepository.save(user);
    }
}
