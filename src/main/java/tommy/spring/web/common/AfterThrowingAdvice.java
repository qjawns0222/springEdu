package tommy.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AfterThrowingAdvice {
	public void expectionLog() {
		System.out.println("[����ó��]:�����Ͻ� ���� ������ ���� �߻�");
	}

}
