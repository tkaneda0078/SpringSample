package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	@Before("execution(* com.example.demo.login.controller.LoginController.getLogin(..))")
	public void startLogAspect(JoinPoint jp) {
		System.out.println("method start: " + jp.getSignature());
	}

	@After("execution(* com.example.demo.login.controller.LoginController.getLogin(..))")
	public void endLogAspect(JoinPoint jp) {
		System.out.println("method end: " + jp.getSignature());
	}
}
