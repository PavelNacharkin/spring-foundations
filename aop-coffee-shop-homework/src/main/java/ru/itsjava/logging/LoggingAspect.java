package ru.itsjava.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* ru.itsjava.services.CoffeeService.*(..))")
    public void LogBefore(JoinPoint joinPoint) {
        System.out.println("Log Before " + joinPoint.getTarget().getClass().getName());
    }

    @After("execution(* ru.itsjava.services..*(..))")
    public void LogAfter(JoinPoint joinPoint) {
        System.out.println("Log After " + joinPoint.getTarget().getClass().getName());
    }

    @Around("execution(* ru.itsjava.services.*.*(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Log Around Before " + proceedingJoinPoint.getTarget().getClass().getSimpleName());

        Object result = proceedingJoinPoint.proceed();

        System.out.println("Log Around After " + proceedingJoinPoint.getTarget().getClass().getSimpleName());

        return result;
    }

}
