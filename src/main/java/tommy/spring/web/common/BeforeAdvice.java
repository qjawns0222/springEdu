package tommy.spring.web.common;

public class BeforeAdvice {
	public void beforeLog() {
		System.out.println("[사전처리]:비지니스 로직 수행전 동작");
	}

}
