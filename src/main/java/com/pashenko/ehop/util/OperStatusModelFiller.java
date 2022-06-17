package com.pashenko.ehop.util;

import com.pashenko.ehop.entities.userdata.User;
import org.springframework.ui.Model;

//TODO: REFACTOR TO USING BUNDLES
public class OperStatusModelFiller {
    public static void fillForUserSignup(User user, Model model){
        if(user != null){
            model.addAttribute("status", "Success");
            model.addAttribute("message", "Registration complete");
        } else {
            model.addAttribute("status", "Error");
            model.addAttribute("message", "Registration failed");
        }
        model.addAttribute("link", "/");
        model.addAttribute("linkText", "Back to home page");
    }

    public static void fillForAccessDenied(Model model, String referer){
        model.addAttribute("status", "Error");
        model.addAttribute("message", "Access denied");
        model.addAttribute("link", referer);
        model.addAttribute("linkText", "Go back");
    }
}
