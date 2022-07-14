package tommy.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("[Before]:�����Ͻ� �޼��� ������ ����");
		Object returnObj=joinpoint.proceed();
		System.out.println("[After]:�����Ͻ� �޼��� ������ ����");
		return returnObj;
	}

}
