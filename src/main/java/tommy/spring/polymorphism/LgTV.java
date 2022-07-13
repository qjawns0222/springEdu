package tommy.spring.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;
	public LgTV() {
		System.out.println("LGTV 객체 생성");
	}
	public void powerOn() {
		System.out.println("LgTV 전원을 켠다");
	}
	public void powerOff() {
		System.out.println("LgTV 전원을 끈다");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	public void start() {
		System.out.println("객체 초기화 작업 처리");
	}
	public void stop() {
		System.out.println("종료전 삭제 로직 처리");
	}
}
