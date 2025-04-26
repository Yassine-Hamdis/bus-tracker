package com.example.myapp.controller;


import com.example.myapp.model.Client;
import com.example.myapp.model.Driver;
import com.example.myapp.service.UserService;
import com.example.myapp.service.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup/client")
    public ResponseEntity<?> registerClient(@RequestBody Client client) {
        return userService.registerClient(client);
    }

    @PostMapping("/signup/driver")
    public ResponseEntity<?> registerDriver(@RequestBody Driver driver) {
        // Logic to register driver
        return ResponseEntity.ok("Driver Registered Successfully");
    }


    // @PostMapping("/signup/driver")
    // public ResponseEntity<?> registerDriver(@RequestBody Driver driver) {
    //     return userService.registerDriver(driver);
    // }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}