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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex07_MunjeCorrect extends JFrame {
	JButton btnSawonAdd,btnSawondel;
	JTable table;
	DefaultTableModel tableModel;
	JTextField txtName;
	JComboBox<String> cbBlood,cbCity,cbGrade;
	
	final static String FILENAME = "c:/naver03/sawon1.txt";
	
	
	public Ex07_MunjeCorrect(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(430, 300);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		
		//종료시 발생하는 이벤트
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				//자동저장해주는 메소드 호출
				sawonDataWrite();
				//시스템 종료
				System.exit(0);
			}
		});
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.sawonDataRead();
		this.setVisible(true);//창이 보일지 말지 여부
	}
	
	//처음 생성시 파일 불러오기
	public void sawonDataRead()
	{
		FileReader fr=null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while(true)
			{
				String s = br.readLine();
				if (s==null)
					break;
				//한줄 읽어온 자료는 배열로 변환
				String []data=s.split(",");
				//테이블에 추가
				tableModel.addRow(data);
			}
			
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "읽어올 사원정보가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException |NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//종료시 파일 저장
	public void sawonDataWrite()
	{
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			//행개수만큼 반복해서 데이터를 읽어서 파일에 저장(컴마로 연결)
			for(int i=0;i<table.getRowCount();i++)
			{
				String s= table.getValueAt(i, 0)+","+table.getValueAt(i, 1)+","+table.getValueAt(i, 2)+","
						+table.getValueAt(i, 3)+"\n";
				fw.write(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void initDesign()
	{
		//상단
		JPanel pTop = new JPanel();
		btnSawonAdd = new JButton("사원정보 추가");
		btnSawondel = new JButton("사원정보 삭제");
		pTop.add(btnSawonAdd);
		pTop.add(btnSawondel);
		this.add("North",pTop);
		
		//중간
		String []title = {"이름","혈액형","지역","직급"};
		tableModel = new DefaultTableModel(title, 0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		
		//하단
		JPanel pBottom = new JPanel();
		pBottom.add(new JLabel("이름"));
		txtName=new JTextField(5);
		pBottom.add(txtName);
		
		pBottom.add(new JLabel("혈액형"));
		String []b = {"A형","B형","O형","AB형"};
		cbBlood = new JComboBox<String>(b);
		pBottom.add(cbBlood);
		
		pBottom.add(new JLabel("지역"));
		String []c = {"서울","전라도","충청도","강원도","경상도","제주도"};
		cbCity = new JComboBox<String>(c);
		pBottom.add(cbCity);
		
		pBottom.add(new JLabel("직급"));
		String []j = {"사원","대리","차장","과장","부장"};
		cbGrade = new JComboBox<String>(j);
		pBottom.add(cbGrade);
		
		
		this.add("South",pBottom);
		
		//정보추가 버튼 이벤트
		btnSawonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(txtName.getText().equals(""))
			{
				JOptionPane.showMessageDialog(Ex07_MunjeCorrect.this, "이름을 입력해주세요");
				return;
			}
			Vector<String> data = new Vector<String>();
			data.add(txtName.getText());
			data.add(cbBlood.getSelectedItem().toString());
			data.add(cbCity.getSelectedItem().toString());
			data.add(cbGrade.getSelectedItem().toString());
			
			//테이블 모델에 추가
			tableModel.addRow(data);
			
			//초기화
			txtName.setText("");
			cbBlood.setSelectedIndex(0);
			cbCity.setSelectedIndex(0);
			cbGrade.setSelectedIndex(0);
			}
		});
		
		
		//정보삭제 버튼 이벤트
		btnSawondel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//선택한 행번호 얻기
				int row = table.getSelectedRow();
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex07_MunjeCorrect.this, "삭제할 행을 선택해주세요");
					return;
				}
				
				//선택한 행 삭제
				tableModel.removeRow(row);				
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex07_MunjeCorrect a = new Ex07_MunjeCorrect("기본창");
				
	}

}
