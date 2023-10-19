package com.basic.MySpringBoot.controller;

import com.basic.MySpringBoot.dto.UserReqDTO;
import com.basic.MySpringBoot.dto.UserResDTO;
import com.basic.MySpringBoot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor    //final 들을 다 생성자에 엮어줌
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;


    //    @GetMapping
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public List<User> getUsers() {
//    }
//    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public User getUser(@PathVariable Long id) {
//    }
    // 인증 없어도 볼 수 있음
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping //@RequestBody를 적지 않으면 모름!!
    public UserResDTO saveUser(@RequestBody UserReqDTO userReqDTO){

        return userService.saveUser(userReqDTO);
    }

    @GetMapping("/{id}")    // PathVariable를 써줘야 함!!
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserResDTO getUserResDTO(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserResDTO> getUserResDTOList(){
        return userService.getUsers();
    }

    @PatchMapping({"/{email}"})
    public UserResDTO updateUserResDTO(@PathVariable String email, @RequestBody UserReqDTO userReqDTO){

        return userService.updateUser(email, userReqDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(id+" 삭제 완료");
    }


}
