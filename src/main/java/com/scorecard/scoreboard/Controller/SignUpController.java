package com.scorecard.scoreboard.Controller;

import com.scorecard.scoreboard.Api.SignUpCompleteEvent;
import com.scorecard.scoreboard.Api.SignUpRequest;
import com.scorecard.scoreboard.Model.User;
import com.scorecard.scoreboard.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequiredArgsConstructor
    @RequestMapping("/signup")
    public class SignUpController {

        private final UserService userService;

        private final ApplicationEventPublisher publisher;

        @GetMapping("/signUp-form")
        public String showSignUpForm(Model model){
            model.addAttribute("user", new SignUpRequest());

            return "signup";
        }

        @PostMapping("/signup")
        public String signUpUser(@ModelAttribute("user") SignUpRequest signup){
            User user = userService.signUp(signup);

            //publish the verification email event here
            publisher.publishEvent(new SignUpCompleteEvent(user,""));


            return "redirect:/signup/signUp-form?success";
        }

    }