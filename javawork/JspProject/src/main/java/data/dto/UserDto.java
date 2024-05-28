package data.dto;

public class UserDto {
private int num;
private String infoname;
private String actname;
private String userclass;
private String userphoto;
private String useraddr;
private int useryear;
private int userdistance;
private int age;


public String getUserclass() {
	return userclass;
}
public void setUserclass(String userclass) {
	this.userclass = userclass;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getUseraddr() {
	return useraddr;
}
public void setUseraddr(String useraddr) {
	this.useraddr = useraddr;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getInfoname() {
	return infoname;
}
public void setInfoname(String infoname) {
	this.infoname = infoname;
}
public String getActname() {
	return actname;
}
public void setActname(String actname) {
	this.actname = actname;
}
public String getUserphoto() {
	return userphoto;
}
public void setUserphoto(String userphoto) {
	this.userphoto = userphoto;
}
public int getUseryear() {
	return useryear;
}
public void setUseryear(int useryear) {
	this.useryear = useryear;
}
public int getUserdistance() {
	return userdistance;
}
public void setUserdistance(int userdistance) {
	this.userdistance = userdistance;
}


}
