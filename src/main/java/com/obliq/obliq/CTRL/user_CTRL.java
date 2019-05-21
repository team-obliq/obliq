package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Career;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.ENTITYS.UserWithRoles;
import com.obliq.obliq.REPOS.CareersRepository;
import com.obliq.obliq.REPOS.UserRespository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.obliq.obliq.SERVICE.tribe_assigment_SRV;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class user_CTRL {
    private UserRespository users;
    private CareersRepository careerRepo;
    private PasswordEncoder passwordEncoder;
    private tribe_assigment_SRV assigment_tool;

    public user_CTRL(UserRespository users, PasswordEncoder passwordEncoder, tribe_assigment_SRV assigment_tool,
                     CareersRepository careerRepo){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.assigment_tool = assigment_tool;
        this.careerRepo = careerRepo;
    }

    @GetMapping("/signup")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());

        List<Career> careerList =  new ArrayList<>();
        for(Career x: careerRepo.findAll()) {
            careerList.add(x);
        }

        List<Career> careerListAdd =  new ArrayList<>();


        model.addAttribute("careerList", careerList);
        model.addAttribute("user", new User());
        model.addAttribute("careerListAdd", careerListAdd);




        return "signup";
    }

    /* ------------------------------------------------------------------------------------------- */
    @PostMapping("/signup")
    public String savUser(@ModelAttribute User user) {

        assigment_tool.tribe_assigment_master_tool(user);
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        assigment_tool.UPDATE_tribe_member_count();
        return "redirect:/login";
    }



//    mapping to edit user info
    @GetMapping("/users/edit/{id}")
    public String showProfileEditForm(@PathVariable long id, Model model) {
        model.addAttribute("user", users.findOne(id));
        return "users/edit";
    }
    @PostMapping("/users/edit/{id}")
    public String editUser(@ModelAttribute User userEdited) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userEdited.setId(sessionUser.getId());
        users.save(userEdited);
        return "redirect:/profile";
    }
}
