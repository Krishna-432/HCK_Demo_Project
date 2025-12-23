package com.example.hckdemo.controller;

import com.example.hckdemo.model.User;
import com.example.hckdemo.repository.UserRepository;
import com.example.hckdemo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.nio.file.*;
import java.util.*;

@Controller
public class AuthController {

    @Autowired private AuthService authService;
    @Autowired private UserRepository userRepo;
    @Autowired private BCryptPasswordEncoder encoder;

    // --- Page Mappings ---
    @GetMapping("/login") public String login() { return "login"; }
    @GetMapping("/signup") public String signup() { return "signup"; }
    @GetMapping("/dashboard") public String dashboard() { return "dashboard"; }
    @GetMapping("/forgot") public String forgot() { return "forgot"; }

    @GetMapping("/reset-password")
    public String showResetPage(@RequestParam String token, Model model) {
        model.addAttribute("token", token);
        return "reset-password";
    }

    // --- Authentication Logic ---
    @PostMapping("/signup")
    public String register(@RequestParam String email, @RequestParam String password) {
        if (!authService.isPasswordStrong(password)) return "redirect:/signup?error=weak";
        User user = new User();
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        userRepo.save(user);
        return "redirect:/login";
    }

    @PostMapping("/forgot-password")
    public String handleForgot(@RequestParam String email) {
        authService.sendResetEmail(email);
        return "redirect:/login?sent=true";
    }

    @PostMapping("/reset-password")
    public String handleReset(@RequestParam String token, @RequestParam String password) {
        userRepo.findByResetToken(token).ifPresent(user -> {
            user.setPassword(encoder.encode(password));
            user.setResetToken(null);
            userRepo.save(user);
        });
        return "redirect:/login?resetSuccess=true";
    }
}