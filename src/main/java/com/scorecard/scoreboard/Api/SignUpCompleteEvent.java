package com.scorecard.scoreboard.Api;

import com.scorecard.scoreboard.Model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class SignUpCompleteEvent extends ApplicationEvent {
    private User user;
    private String confirmationUrl;

    public SignUpCompleteEvent(User user, String confirmationUrl) {
        super(user);
        this.user = user;
        this.confirmationUrl = confirmationUrl;
    }
}
