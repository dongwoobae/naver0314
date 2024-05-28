package day0325;

public class Phone {

	private String model;
	private String color;
	
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

	public void bell()
	{
		System.out.println("벨이 울립니다");
	}
	
	public void sendVoice(String message)
	{
		System.out.println("자기: "+message);
	}
	public void receiveVoice(String message)
	{
		System.out.println("상대방: "+message);
	}
	public void hangUp()
	{
		System.out.println("전화를 끊습니다");
	}
}
