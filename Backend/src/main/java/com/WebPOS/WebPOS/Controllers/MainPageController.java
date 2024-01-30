package com.WebPOS.WebPOS.Controllers;

import com.WebPOS.WebPOS.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:808", allowCredentials = "true", allowedHeaders = "true", allowPrivateNetwork = "true")
@RestController
@RequestMapping("/api/main-page")

public class MainPageController {
    @Autowired
    private userService userService;


    @GetMapping(value = "/userProfile")
    public Object userProfile(Authentication authenticatio)  {
      return  userService.loadUserByUsername(authenticatio.getName()) ;

    }
}
