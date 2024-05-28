package day0408db;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.common.DbConnect;

public class Ex02_DBSawon extends JFrame {
	DbConnect db = new DbConnect();
	JButton btnAdd,btnDel;
	JTextField tfName,tfScore;
	JComboBox <String> cbGender,cbBuseo,cbSel;
	DefaultTableModel tableModel;
	JTable table;
	JRadioButton rdBtn1,rdBtn2,rdBtn3;
	ButtonGroup btnGr;
	int order=1;
	
	int buseoIndex =1;//부서 전체
	int genderIndex =1;//성별 전체


	public Ex02_DBSawon(String title) {
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
		//상부
		JPanel p1 = new JPanel();
		p1.add(new JLabel("이름"));
		tfName = new JTextField(5);
		p1.add(tfName);

		p1.add(new JLabel("점수"));
		tfScore = new JTextField(5);
		p1.add(tfScore);

		String [] cb1= {"남자","여자"};
		cbGender = new JComboBox<String>(cb1);
		p1.add(new JLabel("성별"));
		p1.add(cbGender);

		String [] cb2 = {"홍보부","교육부","인사부","영업부"};
		cbBuseo = new JComboBox<String>(cb2);
		p1.add(new JLabel("부서"));
		p1.add(cbBuseo);

		this.add("North",p1);
		//중앙
		String [] title = {"시퀀스","이름","점수","성별","부서"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add(new JScrollPane(table));

		JPanel p2 = new JPanel();
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		p2.add(btnAdd);
		p2.add(btnDel);

		String [] selBu = {"전체","홍보부","교육부","인사부","영업부"};
		cbSel = new JComboBox<String>(selBu);
		cbSel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				order = cbSel.getSelectedIndex()+1;
				rdBtn1.setSelected(true);
				writeSawon();
			}
		});
		p2.add(cbSel);

		rdBtn1 = new JRadioButton("전체");
		rdBtn2 = new JRadioButton("남");
		rdBtn3 = new JRadioButton("여");
		btnGr = new ButtonGroup();
		btnGr.add(rdBtn1);
		btnGr.add(rdBtn2);
		btnGr.add(rdBtn3);
		p2.add(rdBtn1);
		p2.add(rdBtn2);
		p2.add(rdBtn3);

		this.add("South",p2);
		//btnAdd 이벤트
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfName.getText().length()==0)
					return;
				if(tfScore.getText().length()==0)
					return;

				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;

				String sql = "insert into sawon values (null,?,?,?,?)";
				try {
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, tfName.getText());
					pstmt.setString(2, tfScore.getText());
					pstmt.setString(3, cbGender.getSelectedItem().toString());
					pstmt.setString(4, cbBuseo.getSelectedItem().toString());

					int n =pstmt.executeUpdate();
					if(n==0)
						JOptionPane.showMessageDialog(Ex02_DBSawon.this, "정보 추가 실패");
					else
						JOptionPane.showMessageDialog(Ex02_DBSawon.this, "정보 추가 성공");

					tfName.setText("");
					tfScore.setText("");
					cbGender.setSelectedIndex(0);
					cbBuseo.setSelectedIndex(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					db.dbclose(pstmt, conn);
				}
				writeSawon();
			}
		});

		//btnDel 이벤트
		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n =table.getSelectedRow();
				if(n==-1)
				{
					JOptionPane.showMessageDialog(Ex02_DBSawon.this, "행 선택 요망");
					return;
				}
				String sql = "delete from sawon where num ="+table.getValueAt(n, 0);

				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;

				try {
					pstmt = conn.prepareStatement(sql);
					int nn =pstmt.executeUpdate();
					if(nn==0)
						JOptionPane.showMessageDialog(Ex02_DBSawon.this, "삭제 실패");
					else
						JOptionPane.showMessageDialog(Ex02_DBSawon.this, nn+"개 삭제 성공");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					db.dbclose(pstmt, conn);
				}

			}
		});

		//radioButton 이벤트
		rdBtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				String sql="";
				if(cbSel.getSelectedItem().toString().equals("전체"))
				{
					sql = "select * from sawon";
				}
				else
				{
					sql="select * from sawon where buseo = ?";
				}

				writeRadio(sql);

			}
		});

		rdBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;		
				ResultSet rs =null;

				String sql ="";
				if(cbSel.getSelectedItem().toString().equals("전체"))
				{
					sql = "select * from sawon where gender = '남자'";					
				}
				else
				{
					sql = "select * from sawon where buseo = ? and gender = '남자'";					
				}
				writeRadio(sql);
			}
		});

		rdBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String sql ="";
				if(cbSel.getSelectedItem().toString().equals("전체")) {
					sql = "select * from sawon where gender = '여자'";
				}
				else {
					sql = "select * from sawon where buseo = ? and gender ='여자'";
				}
				writeRadio(sql);
			}
		});

		rdBtn1.setSelected(true);
		rdBtn2.setSelected(false);
		rdBtn3.setSelected(false);

		writeSawon();
	}

	public void writeSawon() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;



		String sql = "";
		if(order==1) {
			sql="select * from sawon";
		}
		else if(order==2) {
			sql="select * from sawon where buseo = '홍보부'";
		}
		else if(order==3) {
			sql="select * from sawon where buseo = '교육부'";
		}
		else if(order==4) {
			sql="select * from sawon where buseo = '인사부'";
		}
		else if(order==5) {
			sql="select * from sawon where buseo = '영업부'";
		}

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			tableModel.setRowCount(0);
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));

				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbclose(pstmt, conn, rs);
		}

	}

	public void writeRadio(String sql) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;

		try {
			pstmt = conn.prepareStatement(sql);

			if(!cbSel.getSelectedItem().toString().equals("전체"))
			{
				pstmt.setString(1, cbSel.getSelectedItem().toString());
			}
			rs = pstmt.executeQuery();
			tableModel.setRowCount(0);
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));

				tableModel.addRow(data);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			db.dbclose(pstmt, conn, rs);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_DBSawon a = new Ex02_DBSawon("사원관리");

	}

}
