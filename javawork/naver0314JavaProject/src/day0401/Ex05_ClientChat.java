package day0401;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ex05_ClientChat extends JFrame implements ActionListener,Runnable {
	JButton btnConnet;
	JLabel lblMessage;	
	JTextArea area;
	JTextField tfMessage;
	JButton btnSend;
	BufferedReader br;
	PrintWriter pw;
	String nickName;
	Socket socket;
	
	
	//서버가 보내오는 메세지를 받아서 출력하기 위한 쓰레드 메소드
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("클라이언트 run");
		//서버가 보내는 메세지를 항상 대기하다가 바로바로 받아서 채팅창에 출력해야한다
		while(true)
		{
			//서버가 보내는 메세지 읽기
			try {
				String msg=br.readLine();
				//채팅창에 출력
				area.append(msg+"\n");
				this.autoScroll();//아까 만들어둔 마지막 열로 가기 메소드
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	//메세지 전송 텍스트필드와 전송 버튼을 처리하기 위한 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();//이벤트가 발생한 소스
		//이벤트가 발생한 소스가 메세지 입력창이거나 전송버튼일 경우 서버로 메세지 보내기
		if(ob==tfMessage||ob==btnConnet)
		{
			pw.write("2|"+tfMessage.getText()+"\n");
			pw.flush();
			//입력창의 메세지 지우고 커서 보내기
			tfMessage.setText("");
			tfMessage.requestFocus();
		}
	}

	public Ex05_ClientChat(String title) {
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
	//채팅창에서 마지막줄로 자동 이동 
	public void autoScroll()
	{
		int n=area.getDocument().getLength();//채팅 총 라인수
		area.setCaretPosition(n);//마지막 줄로 위치변경
	}
	
	public void initDesign()
	{
		this.setLayout(null);//기본 레이아웃을 없애야 직접 주기 가능
		btnConnet = new JButton("서버 접속하기");
		btnConnet.setBounds(160,10,150,30);	
		this.add(btnConnet);
		
		lblMessage = new JLabel("접속 여부: 접속안함");
		lblMessage.setBounds(330, 10, 150, 30);
		this.add(lblMessage);
		
		area = new JTextArea();
		//area.setBounds(10,140,400,400);
		JScrollPane pane = new JScrollPane(area);
		pane.setBounds(13, 50, 460, 350);
		this.add(pane);
		
		tfMessage = new JTextField(30);
		tfMessage.setBounds(13, 410, 350, 30);
		this.add(tfMessage);
		
		btnSend = new JButton("전송");
		btnSend.setBounds(370, 410, 100, 30);
		this.add(btnSend);
		
		//현재 클래스 내에 구현한 메소드 호출
		tfMessage.addActionListener(this);
		btnSend.addActionListener(this);
		

		//서버접속 이벤트
		btnConnet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String serverIP=JOptionPane.showInputDialog("접속할 서버 아이피를 입력하세요","192.168.0.27");
				nickName=JOptionPane.showInputDialog("접속할 닉네임을 입력하세요","배동우");
				
				//서버 접속하기
				try {
					socket = new Socket(serverIP, 6000);
					System.out.println("서버 접속 성공");
					//io 클래스 생성
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pw = new PrintWriter(socket.getOutputStream());
					
					//창제목 닉네임으로 변경
					Ex05_ClientChat.this.setTitle(nickName+"님의 채팅창");
					//메세지도 변경
					lblMessage.setText("서버접속중..."+nickName);
					//스레드 시작
					Thread th = new Thread(Ex05_ClientChat.this);
					th.start();//run 메소드 호출
					
					//서버로 "1|닉네임" 이 형태로 보내기
					pw.write("1|"+nickName+"\n");//끝에 \n 반드시
					pw.flush();//flush 를 해야 비로소 서버로 전송이 된다
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("서버접속오류:"+e1.getMessage());
				}
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_ClientChat a = new Ex05_ClientChat("클라이언트:");
				
	}

}
