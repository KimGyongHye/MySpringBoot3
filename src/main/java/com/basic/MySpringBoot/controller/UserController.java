package com.basic.MySpringBoot.controller;

import com.basic.MySpringBoot.dto.UserReqDTO;
import com.basic.MySpringBoot.dto.UserReqFomrDTO;
import com.basic.MySpringBoot.dto.UserResDTO;
import com.basic.MySpringBoot.entity.User;
import com.basic.MySpringBoot.repository.UserRepository;
import com.basic.MySpringBoot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/userspage")
public class UserController {

    private final UserService userService;


    @GetMapping("/first")
    public String leaf(Model model) {
        model.addAttribute("name", "스프링부트");
        return "leaf";
    }

    @GetMapping("/index")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ModelAndView getUserList(Model model){
        List<UserResDTO> userResDTOList = userService.getUsers();
        return new ModelAndView("index","users",userResDTOList);
    }

    
    // 등록 페이지 이동
    @GetMapping("/signup")  // 역할을 나눴으니까 Req
    public String showSignUpForm(UserReqDTO userReqDTO) {
        return "add-user";
    }
    @PostMapping("/adduser")
    public String addUser(@Valid UserReqDTO user, BindingResult result, Model model) {
        // 입력 항목 검증 오류가 발생했니?
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.saveUser(user);
        return "redirect:/userspage/index";
    }

    // 수정 페이지 이동
    @GetMapping("/edit/{id}")  // 역할을 나눴으니까 Req
    public String showUpdateForm(@PathVariable Long id, Model model) {
        UserResDTO userResDTO = userService.getUserById(id);
        model.addAttribute("user",userResDTO);
        return "update-user";
    }
    @PostMapping("/edit/{id}")
    public String updateUser(@Valid UserReqFomrDTO user, @PathVariable Long id, BindingResult result, Model model) {
        // 입력 항목 검증 오류가 발생했니?
        if (result.hasErrors()) {
            System.out.println(user);
            model.addAttribute("user",user);
            return "update-user";
           // return "redirect:/userspage/edit/{id}";
        }
        userService.updateUserById(id,user);
        return "redirect:/userspage/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        UserResDTO user= userService.getUserById(id);
        userService.deleteUser(id);
        return "redirect:/userspage/index";
    }

}
