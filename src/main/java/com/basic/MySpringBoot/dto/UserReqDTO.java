package com.basic.MySpringBoot.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserReqDTO {
    @NotEmpty(message = "name은 필수 입력 항목입니다")   // 공백 허용
    private String name;
    @Email(message = "email 형식이 아닙니다")
    @NotBlank(message = "email은 필수 입력 항목입니다")   // 공백 안 됨
    private String email;
}
