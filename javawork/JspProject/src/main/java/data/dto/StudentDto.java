package data.dto;

import java.sql.Timestamp;

public class StudentDto {
	private int num;
	private int java;
	private int spring;
	private int html;
	private String name;
	private String blood;
	private char license;
	private Timestamp writeday;
	
	
	public StudentDto() {
		super();
	}
	
	public StudentDto(int java, int spring, int html, String name, String blood, char license, Timestamp writeday) {
		super();
		this.java = java;
		this.spring = spring;
		this.html = html;
		this.name = name;
		this.blood = blood;
		this.license = license;
		this.writeday = writeday;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public char getLicense() {
		return license;
	}
	public void setLicense(char license) {
		this.license = license;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}	
	
}
