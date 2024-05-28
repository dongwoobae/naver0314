package day0328;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Canvas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ex08_PictureMunje extends JFrame {
	final static String SOOJEE = "C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\연예인사진\\19.jpg";//수지
	static String Pa = null;
	MyDraw draw = new MyDraw();

	public Ex08_PictureMunje(String title) {
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
		JButton btnOpen = new JButton();
		JPanel panel= new JPanel();
		
		btnOpen = new JButton("사진 불러오기");
		panel.add(btnOpen);				
		
		this.add("North",panel);
		this.add("Center",draw);
		
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg = new FileDialog(Ex08_PictureMunje.this,"파일 불러오기",FileDialog.LOAD);
				dlg.setVisible(true);
				if(dlg.getDirectory() == null) {
					return;
				}
				Pa=dlg.getDirectory()+dlg.getFile();//dlg.getDirectory가 파일의 주소, dlg.getFile이 파일 명으로
				//둘이 합쳐야 정확한 파일의 주소가 나옴. 처음에 getDirectory만 했다가 아무것도 안뜨는거보고 그냥 폴더만 연거구나 생각함
				draw.repaint();
				
			}
		});
	}
	
	class MyDraw extends Canvas
	{

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Image image =  null;
			if(Pa==null)
			image = new ImageIcon(SOOJEE).getImage();
			else
			image = new ImageIcon(Pa).getImage();
			
			g.drawImage(image, 100, 15, 300, 390, this);
			
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex08_PictureMunje a = new Ex08_PictureMunje("사진");
		
	}

}
