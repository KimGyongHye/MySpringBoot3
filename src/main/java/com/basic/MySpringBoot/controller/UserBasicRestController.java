package com.basic.MySpringBoot.controller;

import com.basic.MySpringBoot.entity.User;
import com.basic.MySpringBoot.exception.BusinessException;
import com.basic.MySpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // @Controller + @ResponseBody
                // @ResponseBody : 변환된 데이터를 응답(response) body에 담아 주는 역할
                // @RequestBody : 변환된 데이터를 요청(request)에 담아서 컨트롤러의 메서드의 아규먼트로 매핑 해주는 역할
//Java => Json : Serialization (직렬화)
//Json => Java : DeSerialization (역직렬화)
@RequestMapping("/users")
public class UserBasicRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }

    @RequestMapping(produces = {"application/json"})
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}")
    public User getUser(@PathVariable Long id) {
//        return userRepository.findById(id)
//                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
        Optional<User> optionalUser = userRepository.findById(id);
        // orElseThrow(Suplier) Suplier의 추상메서드
        User user = optionalUser.orElseThrow(()->new BusinessException("User Not Found",HttpStatus.NOT_FOUND));
        return user;
    }

    @RequestMapping(value = "/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userRepository.findByEmail(email).orElseThrow(()->new BusinessException("User Not Found",HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
        userRepository.delete(user);
//return ResponseEntity.ok(user);
        return ResponseEntity.ok("delete user success");
    }


}
