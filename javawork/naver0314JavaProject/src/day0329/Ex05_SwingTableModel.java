package day0329;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex05_SwingTableModel extends JFrame {
	JTable table;
	JLabel lblTitle;
	DefaultTableModel tableModel;
	JButton btnDel;
	
	public Ex05_SwingTableModel(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 350);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}
	
	public void initDesign()
	{
		//상단에는 제목 넣기
		lblTitle = new JLabel("강남고 학생 정보",JLabel.CENTER);
		lblTitle.setFont(new Font("",Font.BOLD,30));
		this.add("North",lblTitle);
		
		//테이블을 행개수 0, 제못만 넣어서 생성후 center에 추가
		String []title = {"이름","나이","Java","Spring","HTML","총점","평균"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		this.addStudentFile();
		this.process();
		
		//삭제버튼 생성 및 이벤트
		btnDel = new JButton("학생 정보 삭제하기");
		this.add("South",btnDel);
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				System.out.println(row);//선택을 안하면 -1 발생
				
				if(row==-1)
					JOptionPane.showMessageDialog(Ex05_SwingTableModel.this, "먼저 삭제할 행을 선택해주세요");
				else
					tableModel.removeRow(row);
			}
		});
	}
	//총점,평균 계산해주는 메소드
	public void process()
	{
		for(int i=0;i<tableModel.getRowCount();i++)
		{
			//각행마다 3과목의 점수를 읽어서 int로 변환
			int java=Integer.parseInt(table.getValueAt(i, 2).toString());
			int spring=Integer.parseInt(table.getValueAt(i, 3).toString());
			int html=Integer.parseInt(table.getValueAt(i, 4).toString());
			
			//총점 구하기
			int tot= java+spring+html;
			//5번열에 출력(무조건 String으로 변환후 출력)자동으로 object로 변환됨
			table.setValueAt(tot, i, 5);
			//평균 구하기
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			double avg = tot/3.0;
			
			table.setValueAt(nf.format(avg), i, 6);
			
		}
	}
	public void addStudentFile()
	{
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader("C:/naver03/student.txt");
			br=new BufferedReader(fr);
			
			while(true)
			{
				String s =br.readLine();
				if(s==null)
					break;
				String [] data=s.split(",");
				//테이블모델에 추가
				tableModel.addRow(data);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 못찾았어요"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_SwingTableModel a = new Ex05_SwingTableModel("student파일 읽기");
				
	}

}
