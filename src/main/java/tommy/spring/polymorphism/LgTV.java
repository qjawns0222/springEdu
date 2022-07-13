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
		System.out.println("LGTV ��ü ����");
	}
	public void powerOn() {
		System.out.println("LgTV ������ �Ҵ�");
	}
	public void powerOff() {
		System.out.println("LgTV ������ ����");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	public void start() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��");
	}
	public void stop() {
		System.out.println("������ ���� ���� ó��");
	}
}
