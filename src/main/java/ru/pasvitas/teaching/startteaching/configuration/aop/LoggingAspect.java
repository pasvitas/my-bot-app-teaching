package ru.pasvitas.teaching.startteaching.configuration.aop;

import java.util.Arrays;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.pasvitas.teaching.startteaching.model.Student;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

	@Pointcut("execution(public * ru.pasvitas.teaching.startteaching.service.StudentsServiceImpl.*(..))")
	public void callServiceMethod() {}

	@Before("callServiceMethod()")
	public void beforeCall(JoinPoint joinPoint) {
		log.info("Before call: {}, args = {}", joinPoint.toString(), Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining()));
	}

	@Around("callServiceMethod()")
	public Object aroundCall(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		log.info("Around call: {}, time: {}, result: {}", joinPoint.toString(), end - start, result);
		return result;
	}

	@After("callServiceMethod()")
	public void afterCall(JoinPoint joinPoint) {
		log.info("After call: {}", joinPoint.toString());
	}

	@AfterReturning(value = "execution(public * ru.pasvitas.teaching.startteaching.service.StudentsServiceImpl.addStudent(..)) && args(args, ..)", returning = "result", argNames = "joinPoint,args,result")
	public void afterAddStudent(JoinPoint joinPoint, Student args, Student result) {
		log.info("After add student: {}, args = {}, result: {}", joinPoint.toString(), args, result);
	}
}
