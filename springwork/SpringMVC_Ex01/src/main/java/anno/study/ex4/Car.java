package anno.study.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//public class Car {
//	private String carName;
//	private Tire tire;
//	
//	public Car(Tire tire) {
//		this.tire=tire;
//	}
//	
//	public void setCarName(String carName) {
//		this.carName = carName;
//	}
//	
//	public void carInfo() {
//		System.out.println("�ڵ�����: "+carName);
//		System.out.println("Ÿ�̾�: "+tire.getTireName());
//	}
//}
//annotation���� ����
//@Component //xml�� car�� ���
//public class Car {
//	@Value("Audi A7")
//	private String carName;
////	@Autowired //�ڵ����� ã�Ƽ� ���Խ�����. 
//	//�ٵ� �̹����� interface�� ��ӹ޴� �ְ� �θ��̾ ������ ��.
////	private Tire tire;
//	@Autowired
//	private KoreaTire tire; //��Ȯ�ϰ� class������ �����ؾ� ���� X.
////	public Car(Tire tire) {
////		this.tire=tire;
////	} KoreaTire�� ���������Ƿ� ���̻� �Ÿ�̾����� ������ �޼ҵ�� �ʿ����
//	
//	public void setCarName(String carName) {
//		this.carName = carName;
//	}
//	
//	public void carInfo() {
//		System.out.println("�ڵ�����: "+carName);
//		System.out.println("Ÿ�̾�: "+tire.getTireName());
//	}
//}
@Component
@RequiredArgsConstructor
public class Car {
	@Value("BMW 530i")
	private String carName;
	@NonNull
	private CanadaTire tire;
	
	public void carInfo() {
		System.out.println("�ڵ�����: "+carName);
		System.out.println("Ÿ�̾�: "+tire.getTireName());
	}
}