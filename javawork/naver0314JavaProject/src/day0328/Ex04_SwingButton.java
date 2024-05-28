package day0328;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex04_SwingButton extends JFrame {
	JButton btn1,btn2;
	JButton [] btnArray = new JButton [6];//각 배열의 값은 초기값 null
	String []btnLabel = {"초록색","빨강색","분홍색","오렌지색","노랑색","랜덤색"};

	public Ex04_SwingButton(String title) {
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
		this.setLayout(null);//기본 레이아웃 없애기
		//버튼1 생성
		btn1 = new JButton("Hello!");
		//프레임에 추가
		btn1.setBounds(10, 10, 100, 30);//x,y,w,h
		this.add(btn1);
		//btn1에 이벤트 추가-익명 내부클래스 형태로 이벤트 구현
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex04_SwingButton.this, "버튼1");
			}
		});

		//버튼2 생성 후 프레임에 추가
		btn2 = new JButton("buy");
		btn2.setBounds(120, 10, 100, 30);
		this.add(btn2);


		btn2.addActionListener(new Button2Event());

		//btnArraay 배열 변수를 생성 후 프레임에 추가
		int yPos = 50;
		for(int i=0;i<btnArray.length;i++)
		{
			btnArray[i] = new JButton(btnLabel[i]);
			btnArray[i].setBounds(10, yPos, 100, 30);
			this.add(btnArray[i]);
			yPos +=35;

			//익명 내부 클래스 형태로 이벤트 구현
			btnArray[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton ob =(JButton)e.getSource();
					System.out.println(ob.getText());
					//System.out.println(ob.getLabel());//deprecate 됨

					switch(ob.getText())
					{
					case "빨강색":
						//부모 컴포넌트의 인스턴스 변수인 this를 통해서 배경색 변경
						Ex04_SwingButton.this.getContentPane().setBackground(new Color(250,11,48));
						break;
					case "초록색":
						Ex04_SwingButton.this.getContentPane().setBackground(new Color(153, 250, 177));
						break;
					case "분홍색":
						Ex04_SwingButton.this.getContentPane().setBackground(Color.pink);
						break;
					case "오렌지색":
						Ex04_SwingButton.this.getContentPane().setBackground(Color.orange);
						break;
					case "노랑색":
						Ex04_SwingButton.this.getContentPane().setBackground(Color.yellow);
						break;
					case "랜덤색":
					{
						int x=(int)(Math.random()*255);
						int y=(int)(Math.random()*255);
						int z=(int)(Math.random()*255);
						Ex04_SwingButton.this.getContentPane().setBackground(new Color(x,y,z));
					}
					break;
					}
				}
			});
		}

	}

	class Button2Event implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(Ex04_SwingButton.this, "맛점여");
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_SwingButton a = new Ex04_SwingButton("스윙버튼");

	}

}
