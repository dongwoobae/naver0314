package day0401;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex03_ThreadSwingCanvas extends JFrame implements Runnable {
	JButton btnStart,btnStop;
	MyDraw draw = new MyDraw();
	
	
	public Ex03_ThreadSwingCanvas(String title) {
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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("원그리기");
		if(draw==null)
			return;
		while(true) 
		{
			draw.repaint();
		}
	}

	
	class MyDraw extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//랜덤하게 색상을 구하기
			int red = (int)(Math.random()*256);
			int green = (int)(Math.random()*256);
			int blue = (int)(Math.random()*256);
			
			g.setColor(new Color(red,green,blue));
			
			int xpos=(int)(Math.random()*400)+50;
			int ypos=(int)(Math.random()*400)+50;
			
			g.fillOval(xpos, ypos, 70, 70);
		}
	}
	public void initDesign()
	{
		//캔버스를 center에 배치
		this.add("Center",draw);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex03_ThreadSwingCanvas a = new Ex03_ThreadSwingCanvas("쓰레드 예제");
		Thread th = new Thread(a);
		th.start();
	}

}
