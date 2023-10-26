package com.loan.den.service;


import com.loan.den.model.PasswordResetToken;
import com.loan.den.model.User;

public interface TokenService {
    PasswordResetToken createPasswordResetToken(User user, String token);
    PasswordResetToken getPasswordResetToken(String token);
    void invalidateToken(PasswordResetToken token);
}