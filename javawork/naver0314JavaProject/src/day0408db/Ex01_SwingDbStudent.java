package day0408db;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
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
import javax.swing.table.TableModel;

import db.common.DbConnect;

public class Ex01_SwingDbStudent extends JFrame {
	DbConnect db = new DbConnect();
	JTable table;
	DefaultTableModel tableModel;
	JTextField tfName,tfJava,tfHtml,tfSpring;
	JButton btnAdd,btnDel;
	JComboBox<String> cbResult;
	int order =1;


	public Ex01_SwingDbStudent(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 400);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}


	public void initDesign()
	{
		JPanel p1 = new JPanel();
		p1.add(new JLabel("이름"));
		tfName = new JTextField(5);
		p1.add(tfName);

		p1.add(new JLabel("Java"));
		tfJava = new JTextField(5);
		p1.add(tfJava);

		p1.add(new JLabel("Html"));
		tfHtml = new JTextField(5);
		p1.add(tfHtml);

		p1.add(new JLabel("Spring"));
		tfSpring = new JTextField(5);
		p1.add(tfSpring);

		this.add("North",p1);
		////////////////////////////////////
		String [] title = {"시퀀스","이름","자바","HTML","Spring","총점","평균"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		////////////////////////////////////
		JPanel p2 = new JPanel();
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		p2.add(btnAdd);
		p2.add(btnDel);

		String []cb = {"추가순","이름순","총점높은순","총점낮은순"};
		cbResult = new JComboBox<String>(cb);
		p2.add(new JLabel("출력순서"));
		p2.add(cbResult);
		this.add("South",p2);
		
		//콤보박스 이벤트
		cbResult.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				order=cbResult.getSelectedIndex()+1;
				writeStudent();
			}
		});
		//추가버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfName.getText().length()==0)
					return;
				if(tfJava.getText().length()==0)
					return;
				if(tfHtml.getText().length()==0)
					return;
				if(tfSpring.getText().length()==0)
					return;
				
				//입력값을 db에 insert
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;
				String sql = "insert into student values (null,?,?,?,?,now())";
				
				try {
					pstmt = conn.prepareStatement(sql);
					//?개수만큼 바인딩
					pstmt.setString(1, tfName.getText());
					pstmt.setInt(2, Integer.parseInt(tfJava.getText()));
					pstmt.setInt(3, Integer.parseInt(tfHtml.getText()));
					pstmt.setInt(4, Integer.parseInt(tfSpring.getText()));
					//실행
					int n = pstmt.executeUpdate();
					
					if(n==0) {
						JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, "추가실패");
					}
					else
					{
						JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, "추가완료");
					}
						
					//입력값 초기화
					tfName.setText("");
					tfJava.setText("");
					tfHtml.setText("");
					tfSpring.setText("");
					//다시 출력
					writeStudent();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					db.dbclose(pstmt, conn);
				}
				
			}
		});
		//삭제버튼 이벤트
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = table.getSelectedRow();
				
				if(n==-1) {
					JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, "행선택 필요");
					return;
				}
				
					String sql = "delete from student where num ="+table.getValueAt(n, 0);
					//delete from student where num = ? 으로 ?을 밑에서 받아서 할수도 있다.
					Connection conn=db.getConnection();
					PreparedStatement pstmt = null;
					
					try {
						pstmt = conn.prepareStatement(sql);
						int a =pstmt.executeUpdate();
						if(a==0)
						{
							JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, "삭제 실패");
						}
						else
						{
							JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, a+"개 삭제 성공");
						}
						writeStudent();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						db.dbclose(pstmt, conn);
					}
			}
		});
		
		//출력메소드 호출
		writeStudent();
	}

	//출력 메소드
	public void writeStudent() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="";
		if (order==1)
			sql="select *,java+html+spring tot from student order by num asc";
		else if (order==2)
			sql="select *,java+html+spring tot from student order by name asc";
		else if (order==3)
			sql="select *,java+html+spring tot from student order by tot desc";
		else if (order==4)
			sql="select *,java+html+spring tot from student order by tot asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//기존 테이블 데이터 초기화 후 추가하기
			tableModel.setRowCount(0);
			
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("java"));
				data.add(rs.getString("html"));
				data.add(rs.getString("spring"));
				data.add(rs.getString("tot"));
				
				//평균은 여기서 구하기
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(2);

				double avg = rs.getInt("tot")/3.0;
				
				data.add(String.valueOf(nf.format(avg)));
				
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbclose(pstmt, conn, rs);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01_SwingDbStudent a = new Ex01_SwingDbStudent("학생관리DB");
	}

}
