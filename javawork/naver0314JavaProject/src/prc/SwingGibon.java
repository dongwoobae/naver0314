package prc;

import java.awt.Color;

import javax.swing.JFrame;

public class SwingGibon extends JFrame {
	public SwingGibon(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(300, 300);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}
	
	public void initDesign()
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingGibon a = new SwingGibon("기본창");
				
	}

}
