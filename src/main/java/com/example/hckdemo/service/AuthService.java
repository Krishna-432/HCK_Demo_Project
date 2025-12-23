package com.example.hckdemo.service;

import com.example.hckdemo.model.User;
import com.example.hckdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private JavaMailSender mailSender;

    public boolean isPasswordStrong(String password) {
        // Regex: 8+ chars, 1 Uppercase, 1 Special Character
        return password.matches("^(?=.*[A-Z])(?=.*[!@#$&*]).{8,}$");
    }

    public void sendResetEmail(String email) {
        userRepository.findByEmail(email).ifPresent(user -> {
            String token = UUID.randomUUID().toString();
            user.setResetToken(token);
            userRepository.save(user);

            String link = "http://localhost:9090/reset-password?token=" + token;
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(email);
            msg.setSubject("Reset Your Password");
            msg.setText("Click the link to reset your password: " + link);
            mailSender.send(msg);
        });
    }
}