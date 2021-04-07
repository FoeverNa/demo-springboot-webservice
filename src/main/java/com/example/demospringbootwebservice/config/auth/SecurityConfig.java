package com.example.demospringbootwebservice.config.auth;

import com.example.demospringbootwebservice.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // SpringSecurity 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOauth2UserService customOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()//h2-console 화면 사용하기 위해 disable
                .and()
                    .authorizeRequests()//URL별 권한 관리 설정하는 옵션의 시작점
                    .antMatchers("/", "/css/**", "/images/**",
                            "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER 권한만 열람하도록함
                    .anyRequest().authenticated()// 설정된 값들 이외 나머지 URL들은 인증된 사용자에게만 제공
                .and()
                    .logout()// logout 설정의 진입점
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()// OAuth2 로그인 기능에 대한 설정 진입점
                        .userInfoEndpoint()//Oauth2 로그인 성공 이후 사용자 정보를 가져올대의 설정담당
                            .userService(customOauth2UserService);//
    }
}
