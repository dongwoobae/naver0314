package day0325;

public class Employee {

	private String name; 
	private String position;
	private int age;
	private int gibon;
	private int sudang;
	
	//setter와 getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	//추가 메소드들
	public int getNetPay()
	{
		return gibon+sudang;
	}
	public void setPay(int gibon,int sudang)
	{
		this.gibon=gibon;
		this.sudang=sudang;
	}
	public void setSawon(String name,String position,int age)
	{
		 this.name= name;
		 this.position=position;
		 this.age=age;
	}
	
	//생성자
	public Employee()
	{
		this("이름미정","직급미정",0,0,0,0);
	}
	public Employee(String name,int age)
	{
		this(name,"사원",age,250,38,288);
	}
	public Employee(String name,String position,int age)
	{
		this(name, position, age, 100, 50, 150);
	}
	public Employee(String name,String position,int age,int gibon,int sudang,int pay)
	{
		this.name=name;
		this.position=position;
		this.age=age;
		this.gibon=gibon;
		this.sudang=sudang;
		this.getNetPay();
		
	}
}
