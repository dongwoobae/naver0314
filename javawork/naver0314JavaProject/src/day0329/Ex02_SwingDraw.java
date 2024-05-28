package day0329;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Ex02_SwingDraw extends JFrame implements MouseMotionListener,MouseListener {

	//안쓸 override라도 만들어야 작동됨
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub


	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//클릭시 x,y 변경
		x=e.getX();
		y=e.getY();
		//mousePressed 발생시 선색을 랜덤하게
		int red=(int)(Math.random()*256);
		int green=(int)(Math.random()*256);
		int blue=(int)(Math.random()*256);
		
		color=new Color(red,green,blue);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public Ex02_SwingDraw(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		//this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		//마우스 이벤트 추가
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}
	//초기 선 색상 선언
	Color color = Color.pink;
	int x,y,prex,prey;//곡선을 그릴 현재좌표 x,y와 직전좌표 prex,prey 두점을 곡선으로 연결
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//현재 좌표를 직전 좌표로 저장
		prex=x;
		prey=y;

		//현재 좌표는 다시 마우스 위치로 지정
		x=e.getX();
		y=e.getY();

		//paint 다시 호출
		repaint();//현재 클래스가 갖고있는거라 this로 가능 this 생략가능
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(g);
		//선색상
		g.setColor(color);

		//선 굵기 설정
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));

		//선그리기
		g.drawLine(10, 100, 400, 100);;

		//곡선 그리기
		g.drawLine(prex, prey, x, y);


	}
	public void initDesign()
	{

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_SwingDraw a = new Ex02_SwingDraw("곡선 그리기");

	}

}
