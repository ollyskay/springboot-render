package com.scorecard.scoreboard.Api;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.scorecard.scoreboard.Api.EmailValidator;

    @Configuration
    public class ValidatorConfig {
        @Bean
        public EmailValidator emailValidator() {
            return new EmailValidator();
        }
    }


