package day0401;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex05_ServerChat extends JFrame implements Runnable{
	JTextArea area;
	Vector<ClientMember> list = new Vector<Ex05_ServerChat.ClientMember>();
	ServerSocket serverSocket;
	
	public Ex05_ServerChat(String title) {
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
	//접속하는 클라이언트들을 허용하고 벡터에 저장하는 기능
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("서버소켓 생성후 접속하는 클라이언트들 허용하는 run");
		
		//서버소켓 생성
		try {
			serverSocket = new ServerSocket(6000);
			area.append("서버소켓생성성공\n");
			
			while(true)
			{
				//접속한 클라이언트를 허용하고 소켓으로 생성한다.
				Socket socket = serverSocket.accept();;
				area.append("접속한 IP:"+socket.getInetAddress().getHostAddress()+"\n");
				this.autoScroll();
				
				//클라이언트 내부클래스 생성
				ClientMember cm =new ClientMember(socket);
				
				//벡터에 클라이언트들 저장
				list.add(cm);
				
				//각 클라이언트가 가진 run 메소드 호출
				cm.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			area.append("서버소켓생성오류:"+e.getMessage()+"\n");
		}
	}
	//클라이언트 내부 클래스
	class ClientMember extends Thread
	{
		Socket mySocket;
		String nickName;
		BufferedReader br;
		PrintWriter pw;
		//생성자
		public ClientMember (Socket socket) {
			//외부의 run 메소드에서 생성시 소켓을 받아서 생성할것임
			mySocket = socket;
			
			//네트워크를 통해서 메세지를 읽고 쓸수 있도록 io 클래스 생성
			try {
			br=new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			pw=new PrintWriter(mySocket.getOutputStream());
			} catch(IOException e) {
				
			}
		}
		//각 클라이언트로 부터 들어오는 메세지를 읽어서 모든 클라이언트들한테 보내주는 기능
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//super.run();
			
			//클라이언트가 보내는 메세지를 언제든 읽어서 보내줄 수 있도록 한다
			while(true)
			{
				try {
					String msg=br.readLine();
					//클라이언트에서 보낸 메세지를 서버창에도 출력
					area.append(msg+"\n");
					//|로 분리
					//처음 접속 시 1|닉네임
					//메세지 전송 시 2|메세지
					String [] m = msg.split("\\|");
					switch(m[0])
					{
					case "1":
					{
						String sendMessage = m[1]+"님이 입장하였습니다\n";
						nickName=m[1];//닉네임을 멤버 변수에 저장
						//이 메세지를 서버에 연결된 모든 클라이언트들한테 보내야함
						for(ClientMember cm:list)
						{
							cm.pw.write(sendMessage+"\n");
							cm.pw.flush();
						}
						break;
					}
					case "2":
					{
						String sendMessage = nickName + ">>"+m[1]+"\n";
						for(ClientMember cm:list)
						{
							cm.pw.write(sendMessage+"\n");
							cm.pw.flush();
						}
						break;
					}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//채팅창에서 마지막 줄로 이동
	public void autoScroll()
	{
		int n=area.getDocument().getLength();//채팅 총 라인수
		area.setCaretPosition(n);//마지막 줄로 위치변경
	}
	
	public void initDesign()
	{
		area = new JTextArea();
		JScrollPane pane = new JScrollPane(area);
		this.add(pane);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_ServerChat a = new Ex05_ServerChat("채팅서버");
		Thread th = new Thread(a);
		th.start();
		
	}

}
