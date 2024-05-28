package day0329;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex03_ComboboxCanvas extends JFrame {
	JComboBox<String> combo;
	int selectCombo=5;//이미지 기본값
	static final String PATH="C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\연예인사진\\";
	Random rand = new Random();

	String []comboLabel = {"선","원","사각형","문자열","이미지"};
	Draw draw = new Draw();



	public Ex03_ComboboxCanvas(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}

	public void initDesign()
	{
		JPanel p = new JPanel();
		combo = new JComboBox<String>(comboLabel);
		p.add(new JLabel("메뉴를 선택하세요"));
		p.add(combo);

		combo.setSelectedIndex(selectCombo-1);

		//이벤트
		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				selectCombo = combo.getSelectedIndex()+1;
				draw.repaint();
			}
		});

		this.add("North",p);

		this.add("Center",draw);





	}
	//랜덤한 색상을 반환하는 메소드
	public Color getRandomColor()
	{
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		return new Color(red,green,blue);
	}
	class Draw extends Canvas
	{

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(3));

			if(selectCombo==1)
			{
				//랜덤한 위치에 랜덤한 색상의 선을 50개 그려보자
				for(int i=0;i<50;i++)
				{
					int x=rand.nextInt(500);
					int y=rand.nextInt(500);
					int x2=rand.nextInt(500);
					int y2=rand.nextInt(500);

					g.setColor(getRandomColor());
					g.drawLine(x,y,x2,y2);
				}
			}
			else if(selectCombo==2)
			{
				for(int i=0;i<50;i++)
				{
					int x=rand.nextInt(500);
					int y=rand.nextInt(500);
					int x2=rand.nextInt(10,90);
					int y2=rand.nextInt(10,90);

					g.setColor(getRandomColor());
					g.fillOval(x, y, x2, x2);;
				}
			}
			else if(selectCombo==3)
			{
				for(int i=0;i<50;i++)
				{
					int x=rand.nextInt(500);
					int y=rand.nextInt(500);
					int x2=rand.nextInt(30,120);
					int y2=rand.nextInt(30,120);

					g.setColor(getRandomColor());
					g.fillRect(x, y, x2, y2);;
				}
			}
			else if(selectCombo==4)
			{
				//나타낼 문자열
				String msg = "Weekend Soon";
				
				
				
				for(int i=0;i<30;i++)
				{
				//글꼴 변경
				g.setFont(new Font("Comic Sans MS",Font.BOLD, rand.nextInt(10,60)));
				g.setColor(getRandomColor());
				int x = rand.nextInt(300);
				int y = rand.nextInt(450);
				g.drawString(msg, x, y);
				}
						
			}
			else if(selectCombo==5)
			{
				int n =rand.nextInt(19)+1;
				String path = PATH+n+".jpg";
				Image image = new ImageIcon(path).getImage();
				g.drawImage(image, 90, 10, 320, 400, this);
			}

		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex03_ComboboxCanvas a = new Ex03_ComboboxCanvas("ComboBox메뉴");

	}

}
