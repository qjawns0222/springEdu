package tommy.spring.polymorphism;

import org.springframework.stereotype.Component;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("AppleSpeaker ��ü ����");
		
	}

	@Override
	public void volumeUp() {
	
		System.out.println("AplleSpeaker �Ҹ� �ø���");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("AplleSpeaker �Ҹ� ������");
		
	}

}
