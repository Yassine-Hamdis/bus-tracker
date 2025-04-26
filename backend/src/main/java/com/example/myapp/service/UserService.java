package com.example.myapp.service;

import com.example.myapp.model.Client;
import com.example.myapp.model.Driver;
import com.example.myapp.model.User;
import com.example.myapp.repository.ClientRepository;
import com.example.myapp.repository.DriverRepository;
import com.example.myapp.repository.UserRepository;
import com.example.myapp.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final DriverRepository driverRepository;
    private final JwtUtils jwtUtils;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<?> registerClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
        return ResponseEntity.ok("Client registered successfully");
    }

    public ResponseEntity<?> registerDriver(Driver driver) {
        driver.setPassword(passwordEncoder.encode(driver.getPassword()));
        driverRepository.save(driver);
        return ResponseEntity.ok("Driver registered successfully");
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByEmail(loginRequest.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                String token = jwtUtils.generateJwtToken(user.getEmail());
                return ResponseEntity.ok(new LoginResponse(token));
            }
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }
}