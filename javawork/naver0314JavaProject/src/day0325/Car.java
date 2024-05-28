package day0325;

class CarInfo {
private String company = "현대자동차";
private String name = "제네시스 G70";
private String color = "검정";
private int maxSpeed = 250;
private int speed;

CarInfo()
{
	super();
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public int getMaxSpeed() {
	return maxSpeed;
}
public void setMaxSpeed(int maxSpeed) {
	this.maxSpeed = maxSpeed;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}




}
public class Car
{
	public static void main(String[] args) {
		CarInfo car = new CarInfo();
		writeInfo(car);
		
		
		CarInfo car1 = new CarInfo();
		car1.setColor("은색");
		car1.setSpeed(120);
		writeInfo(car1);
	}

	private static void writeInfo(CarInfo c) {
		// TODO Auto-generated method stub
		System.out.println("제작회사: "+c.getCompany());
		System.out.println("모델명: "+c.getName());
		System.out.println("색깔: "+c.getColor());
		System.out.println("최고속도: "+c.getMaxSpeed());
		System.out.println("현재속도: "+c.getSpeed());
		System.out.println("=".repeat(20));
	}
}