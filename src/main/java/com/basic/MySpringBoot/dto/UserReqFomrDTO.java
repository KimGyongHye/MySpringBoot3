package com.basic.MySpringBoot.dto;

import com.basic.MySpringBoot.post.entity.AnnouncementEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class UserReqFomrDTO {
    private Long id;
    @NotEmpty(message = "name은 필수 입력 항목입니다")   // 공백 허용
    private String name;
    @Email(message = "email 형식이 아닙니다")
    @NotBlank(message = "email은 필수 입력 항목입니다")   // 공백 안 됨
    private String email;

}
