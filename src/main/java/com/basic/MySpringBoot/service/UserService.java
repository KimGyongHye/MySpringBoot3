package com.basic.MySpringBoot.service;

import com.basic.MySpringBoot.dto.UserReqDTO;
import com.basic.MySpringBoot.dto.UserReqFomrDTO;
import com.basic.MySpringBoot.dto.UserResDTO;
import com.basic.MySpringBoot.entity.User;
import com.basic.MySpringBoot.exception.BusinessException;
import com.basic.MySpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor // final로 선언된 변수들을 생성자안에 주입해주는 코드를 만들어줌
                         // 아래 생성자와 동일함
@Transactional         // 스프링꺼! readOnly = true를 설정하면 성능에 도움이 된다
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    
//    이렇게 하면 위의 객체들이 늘어날 수록 생성자를 수정해야함
//    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
//        this.userRepository = userRepository;
//        this.modelMapper = modelMapper;
//    }

    // 비지니스 로직을 여기서 작성해라!!
    public UserResDTO saveUser(UserReqDTO userReqDto) {
        //reqDto => entity
        User user = modelMapper.map(userReqDto, User.class);
        User savedUser = userRepository.save(user);
        //entity => resDto
        return modelMapper.map(savedUser, UserResDTO.class);
    }

    @Transactional(readOnly = true)
    public UserResDTO getUserById(long id){
        User userEntity = userRepository.findById(id)
                .orElseThrow(()->new BusinessException("아이디에 해당되는 유저가 없음",HttpStatus.NOT_FOUND));
        return modelMapper.map(userEntity,UserResDTO.class);
    }
    @Transactional(readOnly = true)
    public List<UserResDTO> getUsers(){
            List<User> userList = userRepository.findAll();
            List<UserResDTO> userResDTOList = userList.stream()
                    .map(user -> modelMapper.map(user,UserResDTO.class))
                    .collect(toList()); // static import
                    //.collect(Collectors.toList); //
            return userResDTOList;
    }

    public UserResDTO updateUser(String email, UserReqDTO userReqDto) {
        User existUser = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new BusinessException(email + " User Not Found", HttpStatus.NOT_FOUND));
        //setter method 호출
        // 변경감지를 하므로 세터만 해도 저장이 됨
        existUser.setName(userReqDto.getName());
        //Hibernate: update users set email=?, name=? where id=?
        return modelMapper.map(existUser, UserResDTO.class);
    }

    public UserResDTO updateUserById(Long id, UserReqFomrDTO userReqDto) {
        User existUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new BusinessException(id + " User Not Found", HttpStatus.NOT_FOUND));
        //setter method 호출
        // 변경감지를 하므로 세터만 해도 저장이 됨
        existUser.setName(userReqDto.getName());
        //Hibernate: update users set email=?, name=? where id=?
        return modelMapper.map(existUser, UserResDTO.class);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id) //Optional<User>
                .orElseThrow(() ->
                        new BusinessException(id + " User Not Found", HttpStatus.NOT_FOUND));
        userRepository.delete(user);
    }

}
