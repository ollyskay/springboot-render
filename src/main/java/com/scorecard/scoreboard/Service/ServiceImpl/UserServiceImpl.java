package com.scorecard.scoreboard.Service.ServiceImpl;

import com.scorecard.scoreboard.Api.SignUpRequest;
import com.scorecard.scoreboard.Enum.Role;
import com.scorecard.scoreboard.Model.User;
import com.scorecard.scoreboard.Repository.UserRepository;
import com.scorecard.scoreboard.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User signUp(SignUpRequest signUp) {
        var user = new User(signUp);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }




    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");


        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        user.setRole(Role.DECADEV);

        return "it works";

    }

        public User signUpUser(SignUpRequest signUp) {

            User user = new User(signUp);

            user.setFirstName(signUp.getFirstName());
            user.setLastName(signUp.getLastName());
            user.setEmail(signUp.getEmail());
            user.setPassword(signUp.getPassword());

            user.setRole(Role.DECADEV);


            return userRepository.save(user); // Save the user to the database
        }
    }



