package com.scorecard.scoreboard.Service.ServiceImpl;

import com.scorecard.scoreboard.Api.EmailValidator;
import com.scorecard.scoreboard.Api.SignUpRequest;
import com.scorecard.scoreboard.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignUpServiceImpl {

    private final UserServiceImpl userServiceImpl;

    private final EmailValidator emailValidator;

    public String register(SignUpRequest request) {
       boolean isValidEmail = emailValidator.
               test(request.getEmail());

       if (!isValidEmail) {
           throw new IllegalStateException("email not valid");
       }

        return userServiceImpl.signUpUser(
                new User(request)
        );

    }
}
