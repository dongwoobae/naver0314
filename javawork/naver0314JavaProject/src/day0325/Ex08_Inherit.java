package day0325;

class Phone2
{
	private String model;
	private String color;
	
	public Phone2(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}

class SmartPhone2 extends Phone2
{
	private String wifi;

	public SmartPhone2(String model, String color, String wifi) {
		super(model, color);
		this.wifi = wifi;
	}
	
	public void info()
	{
		System.out.println("모델명: "+this.getModel());
		System.out.println("색상: "+this.getColor());
		System.out.println("와이파이: "+this.wifi);
		System.out.println();
	}
	
	
}
public class Ex08_Inherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SmartPhone2 s1 = new SmartPhone2("갤럭시", "은색", "KT");//default가 없어서 무조건 써서 출력해야함
		s1.info();
		
		SmartPhone2 s2 = new SmartPhone2("아이폰14","핑크색","SKT");
		s2.info();
	}

}
