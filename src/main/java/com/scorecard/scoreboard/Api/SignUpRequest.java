package com.scorecard.scoreboard.Api;

import com.scorecard.scoreboard.Enum.Role;
import lombok.Data;

import java.util.List;

@Data

public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String squad;
    private String stack;
    private Character pod;
    private Role roles;

}
