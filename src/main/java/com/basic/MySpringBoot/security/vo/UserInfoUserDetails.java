package com.basic.MySpringBoot.security.vo;

import com.basic.MySpringBoot.security.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {

    // UserDetails라는 것이 security에서 쓰는 객체 >>

    private String email;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(UserInfo userInfo) { // 여기는 내 엔티티
        email=userInfo.getEmail();
        password=userInfo.getPassword();    // 암호화 되어있는 패스워드
        authorities= Arrays.stream(userInfo.getRoles().split(","))
                .map(roleName -> new SimpleGrantedAuthority(roleName))
                // .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
                //.collect(Collectors.toList());
        // 롤이 여러가지 있을 수 있어서 권한은 List로 설정
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}