package com.scorecard.scoreboard.Service;

import com.scorecard.scoreboard.Api.SignUpRequest;
import com.scorecard.scoreboard.Model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User signUp(SignUpRequest signUpRequest);

    User findByEmail(String email);

    UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException;
}
