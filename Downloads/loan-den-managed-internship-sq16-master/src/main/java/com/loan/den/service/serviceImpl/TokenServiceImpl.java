package com.loan.den.service.serviceImpl;


import com.loan.den.model.PasswordResetToken;
import com.loan.den.model.User;
import com.loan.den.repository.PasswordResetTokenRepository;
import com.loan.den.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenServiceImpl implements TokenService {


    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    public TokenServiceImpl(PasswordResetTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public PasswordResetToken createPasswordResetToken(User user, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(token);
        passwordResetToken.setUser(user);

        passwordResetToken.setExpiryDate(LocalDateTime.now().plusHours(1));
        return tokenRepository.save(passwordResetToken);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(String token) {
        return tokenRepository.findByToken(token);
    }


    @Override
    public void invalidateToken(PasswordResetToken token) {
        tokenRepository.delete(token);
    }
}

