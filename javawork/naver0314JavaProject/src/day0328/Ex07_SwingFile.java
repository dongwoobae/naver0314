package day0328;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex07_SwingFile extends JFrame {

	JButton btnOpen,btnSave;
	JTextArea memoArea;	


	public Ex07_SwingFile(String title) {
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
		btnOpen = new JButton("파일 열기");
		btnSave = new JButton("파일 저장");
		p.add(btnOpen);
		p.add(btnSave);

		//프레임에 추가
		this.add("North",p);
		//메모장은 가운데다
		memoArea =new JTextArea();
		//this.add("Center",memoArea);//스크롤이 안됨
		this.add("Center",new JScrollPane(memoArea));//메모장 크기보다 큰 내용을 불러올 경우 스크롤이 생긴다

		//파일 열기 이벤트
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//파일 다이얼로그(열기모드)
				FileDialog dlg = new FileDialog(Ex07_SwingFile.this, "파일 열기", FileDialog.LOAD);
				dlg.setVisible(true);
				
				
				if(dlg.getDirectory()==null)
				return;//취소 클릭시 이벤트 종료
				String path =dlg.getDirectory()+dlg.getFile();//불어올 파일은 디렉토리명 + 파일명
				
				FileReader fr=null;
				BufferedReader br = null;
				
				try {
					fr=new FileReader(path);
					br=new BufferedReader(fr);
					//기존의 메모장 내용 모두 지우기
					memoArea.setText("");
					
					while(true)
					{
						String line = br.readLine();
						if(line==null)
							break;
						//메모장에 추가
						memoArea.append(line+"\n");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						br.close();
						fr.close();
					} catch (IOException|NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		//파일 저장 이벤트
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg = new FileDialog(Ex07_SwingFile.this, "파일 저장", FileDialog.SAVE);
				dlg.setVisible(true);
				
				
				if(dlg.getDirectory()==null)
				return;
				String path =dlg.getDirectory()+dlg.getFile();
				
				FileWriter fw= null;
				try {
					fw=new FileWriter(path);
					//메모장의 내용을 파일에 저장하기
					fw.write(memoArea.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex07_SwingFile a = new Ex07_SwingFile("간단 메모장");

	}

}
