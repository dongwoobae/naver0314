package day0329;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex06_SwingTableShop extends JFrame {
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd,btnDel;
	JTextField tfSang,tfSu,tfDan;
	static final String FILENAME="C:/naver03/Sangpoom.txt";

	public Ex06_SwingTableShop(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(400, 400);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		//윈도우 종료시 테이블의 내용을 파일에 저장 후 종료하자
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(FILENAME);
					
					for(int i=0;i<table.getRowCount();i++)
					{
						String sang = table.getValueAt(i, 0).toString();
						String su = table.getValueAt(i, 1).toString();
						String dan = table.getValueAt(i, 2).toString();
						String tot = table.getValueAt(i, 3).toString();
						
						String s=sang+","+su+","+dan+","+tot+"\n";
						fw.write(s);
					}
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
				
				System.exit(0);
			}
		});
		
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		//파일의 내용을 불러오려면 테이블이 생성 된 후여야 한다.
		this.shopFileRead();
		this.setVisible(true);//창이 보일지 말지 여부
	}

	//파일 불러와서 테이블에 출력하는 메소드
	public void shopFileRead()
	{
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			
			while(true)
			{
				String s = br.readLine();
				if(s==null)
					break;
				String data [] = s.split(",");
				//테이블에 추가
				tableModel.addRow(data);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 없음"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e2) {
				// TODO: handle exception
			}
		}
		
	}
	public void initDesign()
	{
		//상단에는 버튼
		JPanel pTop = new JPanel();
		btnAdd=new JButton("상품정보추가");
		btnDel= new JButton("상품정보삭제");
		pTop.add(btnAdd);
		pTop.add(btnDel);
		this.add("North",pTop);

		//중단에는 테이블
		String []title = {"상품명","수량","단가","총금액"};
		tableModel = new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		//하단에는 입력 컴포넌트들
		tfSang = new JTextField(7);
		tfSu = new JTextField(4);
		tfDan = new JTextField(7);

		JPanel pBottom = new JPanel();

		pBottom.add(new JLabel("상품명"));
		pBottom.add(tfSang);
		pBottom.add(new JLabel("수량"));
		pBottom.add(tfSu);
		pBottom.add(new JLabel("단가"));
		pBottom.add(tfDan);

		this.add("South",pBottom);

		//추가버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sang=tfSang.getText();
				int su=0,dan=0;
				//입력 안했을경우 종료
				if(tfSang.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "상품명을 입력해주세요");
					return;
				}
				if(tfSu.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "수량을 입력해주세요");
					return;
				}
				if(tfDan.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "단가를 입력해주세요");
					return;
				}

				try{
					su = Integer.parseInt(tfSu.getText());
					dan = Integer.parseInt(tfDan.getText());}
				catch (NumberFormatException e1){
					System.out.println("수량,단가 문자입력오류");
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "수량,단가는 숫자로만 입력해주세요");
					return;//추가 메소드만 종료
				}
				int total = su*dan;

				//vector로 데이터를 담는다(data)
				Vector<String> data = new Vector<String>();
				data.add(sang);
				data.add(String.valueOf(su));
				data.add(String.valueOf(dan));
				data.add(String.valueOf(total));
				//tableModel로 추가한다
				tableModel.addRow(data);
				//입력박스의 데이터는 지운다(setText)
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
			}
		});
		//삭제이벤트 : 행을 선택시 행의 데이터 삭제(선택안했을 경우 경고메세지)
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row==1)
				{
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "삭제할 행을 선택해주세요");
				} else
					tableModel.removeRow(row);
			}
		});
		
		

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex06_SwingTableShop a = new Ex06_SwingTableShop("상품등록및삭제");

	}

}
