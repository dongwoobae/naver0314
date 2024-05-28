package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex05_SwingCanvas extends JFrame {
	//캔버스 변수 선언
	MyDraw draw = new MyDraw();
	//사진 경로
	String foodImage = "C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\음식사진\\1.jpg";
	String foodImage2 = "C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\음식사진\\11.jpg";
	public Ex05_SwingCanvas(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		//this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}
	//캔버스를 상속받는 내부클래스
	class MyDraw extends Canvas
	{
		//처음시작시, 그리고 프레임 크기 변경시에는 자동호출
		//그 외에는 강제호출(repaint)
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//색상변경
			g.setColor(Color.magenta);
			//타원 그리고
			g.drawOval(30, 30, 190, 150);
			//채워진 타원 그리기
			g.setColor(Color.pink);
			g.fillOval(150, 30, 100, 70);
			
			//테두리 사각형 
			g.setColor(Color.gray);
			g.drawRect(300, 50, 100, 60);
			
			//채워진 사각형
			g.setColor(new Color(160,220,160));
			g.fillRect(300, 150, 100, 150);
			
			//글꼴 출력
			g.setFont(new Font("Comic Sans Ms",Font.BOLD,30));
			g.drawString("Good Day!!", 50, 350);
			
			g.setFont(new Font("궁서체",Font.BOLD,30));
			g.drawString("안녕하세요", 250, 350);
			
			//이미지 그리기
			Image image1 = new ImageIcon(foodImage).getImage();
			g.drawImage(image1, 30, 150, 100, 100, this);
			
			Image image2 = Toolkit.getDefaultToolkit().getImage(foodImage2);
			g.drawImage(image2, 150, 170, 130, 130, this);
			
		}
	}
	public void initDesign()
	{
		//기본 레이아웃의 Center 에 캔버스 추가
		this.add("Center",draw);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_SwingCanvas a = new Ex05_SwingCanvas("캔버스");
		
	}

}
