package data.dto;

public class FrameDto {
private int num;
private String color;
private String name;
private String price;
private String company;
private String photo;


public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public FrameDto() {
	super();
}

public FrameDto(String color, String name, String price, String company, String photo) {
	super();
	this.color = color;
	this.name = name;
	this.price = price;
	this.company = company;
	this.photo = photo;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}


}
