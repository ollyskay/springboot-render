package com.loan.den.contoller;

import com.loan.den.model.PasswordResetToken;
import com.loan.den.model.User;
import com.loan.den.service.TokenService;
import com.loan.den.service.UserService;
import com.loan.den.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class PasswordResetController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/api/forgot-password")
    public ResponseEntity<String> requestPasswordReset(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");

        User user = userService.getUserByUsername(email);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        String resetToken = TokenGenerator.generateToken();

        PasswordResetToken passwordResetToken = tokenService.createPasswordResetToken(user, resetToken);


        return ResponseEntity.ok("Password reset email sent.");
    }

    @PostMapping("/api/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> requestData) {
        String resetToken = requestData.get("token");
        String newPassword = requestData.get("newPassword");

        PasswordResetToken passwordResetToken = tokenService.getPasswordResetToken(resetToken);

        if (passwordResetToken == null || passwordResetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired reset token");
        }

        User user = passwordResetToken.getUser();
        user.setPassword(newPassword);
        userService.updateUser(user);

        tokenService.invalidateToken(passwordResetToken);

        return ResponseEntity.ok("Password reset successful");
    }
}

