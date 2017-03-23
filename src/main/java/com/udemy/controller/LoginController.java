package com.udemy.controller;

import com.udemy.model.UserCredencial;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Julio on 03/03/2017.
 */

@Controller
public class LoginController {

    @GetMapping("/")
    public String redirectToLogin(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name="error", required = false) String error,
                                @RequestParam(name="logout", required = false) String logout){
        model.addAttribute("error",error);
        model.addAttribute("logout",logout);
        model.addAttribute("userCredencial",new UserCredencial());
        return "login";
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name="userCredencial")UserCredencial userCredencial){

        if( userCredencial.getUsername().equals("user") && userCredencial.getPassword().equals("user")){
            return "redirect:/contacto/showcontacts";
        }

        return "redirect:/login?error";

    }

}
