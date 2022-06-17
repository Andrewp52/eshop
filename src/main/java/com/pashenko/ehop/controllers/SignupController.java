package com.pashenko.ehop.controllers;

import com.pashenko.ehop.entities.dto.UserRegDto;
import com.pashenko.ehop.entities.userdata.User;
import com.pashenko.ehop.services.UserService;
import com.pashenko.ehop.util.OperStatusModelFiller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {
    private final UserService userService;

    @GetMapping
    public String getNewUserForm(Model model){
        model.addAttribute("userRegDto", new UserRegDto());
        return "signup-form";
    }

    @PostMapping
    public String registerNewUser(Model model, @Valid @ModelAttribute UserRegDto dto, BindingResult bindingResult){
        if(!dto.isPasswordMatch()){
            bindingResult.addError(new FieldError("userRegDto", "repPassword", "Password doesn't match"));
            dto.setRepPassword("");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("userRegDto", dto);
            return "signup-form";
        }
        User user = null;
        try {
            user = userService.registerNewUser(dto);
            OperStatusModelFiller.fillForUserSignup(user, model);
        } catch (EntityExistsException e){
            bindingResult.addError(new FieldError("userRegDto", "userName", e.getMessage()));
            model.addAttribute("userRegDto", dto);
            return "signup-form";
        }
        return "operation-result";
    }

    @GetMapping("/activate/{token}")
    String activateAccount(@PathVariable(name = "token") String token, Model model){
        return "operation-result";
    }
}
