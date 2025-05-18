package ru.pasvitas.teaching.startteaching.configuration.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.pasvitas.teaching.startteaching.exceptions.TeachingApplicationException;

@Aspect
@Component
public class ErrorAspect {

	@Pointcut("execution(public * ru.pasvitas.teaching.startteaching.service.StudentsServiceImpl.*(..))")
	public void callServiceMethod() {}

	@AfterThrowing(value = "callServiceMethod()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		throw new TeachingApplicationException("service", exception.getMessage(), joinPoint.getSignature().getName(), exception);
	}
}
