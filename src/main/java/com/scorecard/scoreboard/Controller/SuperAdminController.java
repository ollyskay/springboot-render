package com.scorecard.scoreboard.Controller;

import com.scorecard.scoreboard.Model.User;
import com.scorecard.scoreboard.Service.ServiceImpl.UserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/super-admin")
//@PreAuthorize("hasRole('SUPERADMIN')") // Restrict access to Super Admin
public class SuperAdminController {

    private UserServiceImpl userServiceImpl;

//    @GetMapping("/signup")
//    public String showSignUpForm(Model model) {
//        model.addAttribute("user", new User(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(), Role.DECADEV));
//        return "superadmin/signup";

//    }

    //Handle user sign-up
    @PostMapping("/signup")
    @PreAuthorize("hasRole('SUPERADMIN') || hasRole('ADMIN')")
    public String signUp(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:super-admin/signup"; // Show the form again with validation errors
        }

        // Register the user (you should have a userService for this)
        userServiceImpl.signUpUser(user);

        return "redirect:/superadmin/dashboard"; // Redirect to the dashboard after sign-up
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "superadmin/dashboard";
    }

    @GetMapping("/createSquad")
    public String createSquad(Model model) {
        // Logic to create a squad goes here
        return "superadmin/squad-created";
    }

    @GetMapping("/createStack")
    public String createStack(Model model) {
        // Logic to create a stack goes here
        return "superadmin/stack-created";
    }

    @GetMapping("/createPod")
    public String createPod(Model model) {
        // Logic to create a pod goes here
        return "superadmin/pod-created";
    }

    @GetMapping("/manageAdmins")
    public String manageAdmins(Model model) {
        // Logic to fetch and display admins for management goes here
        return "superadmin/manage-admins";
    }

    @PostMapping("/createAdmin")
    public String createAdmin(@ModelAttribute("admin") User admin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "superadmin/manage-admins"; // Show the form again with validation errors
        }

        // Implement logic to create the admin user

        return "redirect:/superadmin/manageAdmins"; // Redirect to the admin management page
    }

    @GetMapping("/viewPodHealth")
    public String viewPodHealth(Model model) {
        // Logic to fetch and display pod health and scores goes here
        return "superadmin/view-pod-health";
    }

//    @GetMapping("/viewCumulativeScores")
//    public String viewCumulativeScores(Model model) {
//        // Implement logic to fetch cumulative scores from your database or service
//        List<CumulativeScore> cumulativeScores = cumulativeScoreService.getAllCumulativeScores(); // Replace with your service method
//
//        // Add the fetched data to the model
//        model.addAttribute("cumulativeScores", cumulativeScores);
//
//        return "superadmin/view-cumulative-scores";
//    }

}




