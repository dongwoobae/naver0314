package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex06_SwingCanvasRadio extends JFrame {

	final static String SOOJEE = "C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\연예인사진\\19.jpg";//수지
	final static String SEKYOUNG = "C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\연예인사진\\15.jpg";//신세경
	final static String SULHEYON = "C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\연예인사진\\18.jpg";//설현
	final static String WOOBIN = "C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\연예인사진\\2.jpg";//김우빈

	Color boxColor = new Color(67,196,207);//초기 박스 색상
	JRadioButton rbBox1,rbBox2,rbBox3,rbBox4;
	JRadioButton [] rbphoto=new JRadioButton[4];
	
	int photoIndex=1;//처음엔 수지사진
	MyDraw draw = new MyDraw();

	public Ex06_SwingCanvasRadio(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(400, 500);//창크기
		//this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}
	//캔버스 내부 클래스
	class MyDraw extends Canvas
	{

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);

			//채워진 박스 그리기
			g.setColor(boxColor);
			g.fillRect(30, 70, 320, 320);

			Image image = null;
			switch(photoIndex)
			{
			case 1:
				image= new ImageIcon(SOOJEE).getImage();
				break;
			case 2:
				image= new ImageIcon(SULHEYON).getImage();
				break;
			case 3:
				image= new ImageIcon(SEKYOUNG).getImage();
				break;
			case 4:
				image= new ImageIcon(WOOBIN).getImage();
				break;
			}
			g.drawImage(image, 80, 100, 220, 260, this);
		}

	}
	public void initDesign()
	{
		this.add("Center",draw);
		// 상단에 색상 라디오 버튼 추가
		JPanel pTop = new JPanel();
		ButtonGroup bg1=new ButtonGroup();
		rbBox1 = new JRadioButton("초록색");
		bg1.add(rbBox1);
		pTop.add(rbBox1);

		//new Color(67,196,207)
		rbBox2 = new JRadioButton("하늘색",true);
		bg1.add(rbBox2);
		pTop.add(rbBox2);

		rbBox3 = new JRadioButton("분홍색");
		bg1.add(rbBox3);
		pTop.add(rbBox3);

		rbBox4 = new JRadioButton("오렌지색",true);
		bg1.add(rbBox4);
		pTop.add(rbBox4);

		//rbBox1 에 대한 이벤트
		rbBox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor= new Color(203,240,172);
				//캔버스의 paint 메소드 강제호출
				draw.repaint();
			}
		});

		rbBox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor= new Color(67,196,207);
				draw.repaint();
			}
		});

		rbBox3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor= Color.pink;
				draw.repaint();
			}
		});

		rbBox4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor= new Color(240,171,89);
				draw.repaint();
			}
		});
		
		//프레임 상단에 Panel 추가
		this.add("North",pTop);

		//프레임의 하단에는 사진 선택하는 라디오버튼 추가
		JPanel pBottom = new JPanel();
		ButtonGroup bg2 = new ButtonGroup();
		
		String []s= {"수지","신세경","설현","김우빈"};
		for(int i=0;i<rbphoto.length;i++)
		{
			final int n=i+1;
			
			rbphoto[i]=new JRadioButton(s[i], i==(photoIndex-1)?true:false);
			//그룹 변수에 추가
			bg2.add(rbphoto[i]);
			//패널에도 추가
			pBottom.add(rbphoto[i]);
			
			//이벤트
			rbphoto[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				//photoIndex = i+1;//여기서 i를 사용하지 못함
					photoIndex = n;
					draw.repaint();
				}
			});
		}
		this.add("South",pBottom);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex06_SwingCanvasRadio a = new Ex06_SwingCanvasRadio("캔버스2");

	}

}
