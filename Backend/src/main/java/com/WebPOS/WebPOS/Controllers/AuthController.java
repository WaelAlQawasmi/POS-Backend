package com.WebPOS.WebPOS.Controllers;

import com.WebPOS.WebPOS.Entities.User;
import com.WebPOS.WebPOS.Requests.ErrorRes;
import com.WebPOS.WebPOS.Requests.loginReq;
import com.WebPOS.WebPOS.Requests.loginRes;
import com.WebPOS.WebPOS.Security.JwtUtil;
import com.WebPOS.WebPOS.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;

@RestController
//@CrossOrigin(origins = "http://127.0.0.1:5173"  , maxAge = 3600, allowedHeaders = "*")

@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    userService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;

    }
   // @CrossOrigin(origins = "http://127.0.0.1:5173" , allowedHeaders = "*")


    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public SSLEngineResult.Status test() {
        return SSLEngineResult.Status.OK;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody loginReq loginReq) {


        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            String email = authentication.getName();
            User user = userService.findUserByEmail(email);
            String token = jwtUtil.createToken(user);
            loginRes loginRes = new loginRes(email, token);

            return ResponseEntity.ok(loginRes);

        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity signupPost(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

        if (userService.findUserByEmail(email) == null) {
            String passwordEncoded = passwordEncoder.encode(password);
            User user = new User(name, email, passwordEncoded);
            userService.save(user);

            String token = jwtUtil.createToken(user);
            loginRes loginRes = new loginRes(email, token);

            return ResponseEntity.ok(loginRes);
        } else {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "This email exist");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

}
