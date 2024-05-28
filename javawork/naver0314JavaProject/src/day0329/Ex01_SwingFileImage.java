package day0329;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex01_SwingFileImage extends JFrame {
	static String photo = "C:\\Users\\배동우\\Desktop\\naver0314\\참고자료들\\연습용 사진들\\연예인사진\\19.jpg";
	JButton btnImageOpen;
	MyPhoto myPhoto = new MyPhoto();
	
	
	
	
	public Ex01_SwingFileImage(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(390, 520);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}
	
	//캔버스를 상속받는 내부클래스
	class MyPhoto extends Canvas
	{

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			Image image = new ImageIcon(photo).getImage();
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
			
		}
		
	}
	public void initDesign()
	{
		JPanel p = new JPanel();
		btnImageOpen = new JButton("이미지 불러오기");
		p.add(btnImageOpen);
		this.add("North",p);
		
		this.add("Center",myPhoto);
		
		//버튼 이벤트
		btnImageOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg = new FileDialog(Ex01_SwingFileImage.this, "이미지 불러오기", FileDialog.LOAD);
				dlg.setVisible(true);
				if(dlg.getFile()==null)
					return;
				//불러올 경로와 파일명
				photo=dlg.getDirectory()+dlg.getFile();
				myPhoto.repaint();
				}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01_SwingFileImage a = new Ex01_SwingFileImage("사진 불러오기");
		
	}

}
