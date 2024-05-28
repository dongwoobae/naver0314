package day0322;

public class Sawon {
	private String name;
	private int gibon;
	private int sudang;
	
	//getter
		//setter
	
	public void setSawon(String name, int gibon, int sudang)
	{
		setName(name);
		setGibon(gibon);
		setSudang(sudang);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGibon() {
		return gibon;
	}

	public void setGibon(int gibon) {
		this.gibon = gibon;
	}

	public int getSudang() {
		return sudang;
	}

	public void setSudang(int sudang) {
		this.sudang = sudang;
	}

	//실수령액 반환하는 메소드
	public int getNetPay()
	{
		int pay=0;
		pay = gibon-(gibon*3/100)+sudang;
		return pay;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
