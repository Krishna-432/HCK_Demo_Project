package com.example.hckdemo.service;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public boolean updatePassword(String token, String newPassword) {
	    // 1. Find the user by the reset token
	    return userRepository.findByResetToken(token).map(user -> {
	        // 2. Encrypt the new password
	        user.setPassword(passwordEncoder.encode(newPassword));
	        // 3. Clear the token so it can't be used again
	        user.setResetToken(null); 
	        userRepository.save(user);
	        return true;
	    }).orElse(false);
	}
}
