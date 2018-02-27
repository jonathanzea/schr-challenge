package com.weathermiddle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

    @Before("execution(public * com.weathermiddle.controller.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
        System.out.println(":::::API Rest Called:::::" + pjp);
    }
}
