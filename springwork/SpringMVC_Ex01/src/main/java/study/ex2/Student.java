package study.ex2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor// final이나 nonnull 붙은 애들만
@Setter
public class Student {
	private String schoolName;
	//모든 변수 다 받는 생성자가 아니라 내가 필요한 변수만 받는 생성자를 생성하려면
	//final을 붙이거나 NonNull을 붙이고 RequiredArgsConstructor를 생성하면 된다.
	@NonNull
	MyInfo myInfo;
	
//	public Student(MyInfo info) {
//		myInfo=info;
//	}
//	
//	public void setSchoolName(String schoolName) {
//		this.schoolName = schoolName;
//	}
//	
	public void show() {
		System.out.println(myInfo);//toString 호출
		System.out.println("학교명: "+schoolName);
	}
}
