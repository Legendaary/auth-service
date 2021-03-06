package com.insomniacoder.authservice;

import com.insomniacoder.authservice.user.entity.User;
import com.insomniacoder.authservice.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class AuthenticationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeUserData(UserRepository userRepository) {
        return (args) ->
                userRepository.save(User.builder().email("tanatloke@gmail.com").name("tanat").password("password").role("ADMIN").build());
    }
}
