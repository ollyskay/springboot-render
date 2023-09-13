package com.scorecard.scoreboard.Controller;

import com.scorecard.scoreboard.Service.ServiceImpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")

public class AdminController {

    private UserServiceImpl userServiceImpl;
}
