package com.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

}
// package com.example.myapp;

// import com.example.myapp.model.Client;
// import com.example.myapp.model.Driver;
// import com.example.myapp.repository.UserRepository;

// import java.util.List;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// @SpringBootApplication
// public class MyappApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(MyappApplication.class, args);
//     }

//     @Bean
//     public CommandLineRunner testBackend(UserRepository userRepository) {
//         return args -> {
//         // Create and save a Client
//         Client client = new Client();
//         client.setEmail("client@example.com");
//         client.setUsername("testClient");
//         client.setPassword("password123");
//         userRepository.save(client);
//         System.out.println("Client saved: " + client);

//         // Create and save a Driver
//         Driver driver = new Driver();
//         driver.setEmail("driver@example.com");
//         driver.setUsername("testDriver");
//         driver.setPassword("password123");
//         driver.setPhoneNumber("1234567890");
//         userRepository.save(driver);
//         System.out.println("Driver saved: " + driver);

//         // Create and save another Client
//         Client client2 = new Client();
//         client2.setEmail("client2@example.com");
//         client2.setUsername("testClient2");
//         client2.setPassword("password123");
//         userRepository.save(client2);
//         System.out.println("Client saved: " + client2);

//         // Create and save another Driver
//         Driver driver2 = new Driver();
//         driver2.setEmail("driver2@example.com");
//         driver2.setUsername("testDriver2");
//         driver2.setPassword("password123");
//         driver2.setPhoneNumber("9876543210");
//         userRepository.save(driver2);
//         System.out.println("Driver saved: " + driver2);

//         // Fetch and print all email addresses
//         List<String> emails = userRepository.findAllEmails();
//         System.out.println("Emails in the database: " + emails);
//     };
// }
// }