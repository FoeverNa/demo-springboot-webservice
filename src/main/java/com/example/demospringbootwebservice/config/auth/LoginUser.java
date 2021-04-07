package com.example.demospringbootwebservice.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 메소드의 파라미터로 선언된 객체에서만 사용될 수 있음
@Retention(RetentionPolicy.RUNTIME) // RUNTIME으로 하면 컴파일 이후에도 JVM에 의해서 참조가 가능
public @interface LoginUser {
}
