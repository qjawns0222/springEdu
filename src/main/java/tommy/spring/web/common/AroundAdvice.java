package tommy.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("[Before]:비지니스 메서드 수행전 동작");
		Object returnObj=joinpoint.proceed();
		System.out.println("[After]:비지니스 메서드 수행후 동작");
		return returnObj;
	}

}
