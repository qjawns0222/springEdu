package tommy.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AfterThrowingAdvice {
	public void expectionLog() {
		System.out.println("[예외처리]:비지니스 로직 수행중 예외 발생");
	}

}
