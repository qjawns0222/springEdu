package tommy.spring.web.common;

public class AfterReturningAdvice {
	public void afterLog() {
		System.out.println("[사후처리]:비지니스 로직 수행전 동작");
	}

}
