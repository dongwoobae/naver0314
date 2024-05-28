package day0329;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Ex07_SwingFileMunje extends JFrame {
	static final String SAWON = "c:/naver03/sawon.txt";
	JComboBox<String> combo1,combo2,combo3,combo4;
	JButton btnSave, btnDelete;
	JPanel panel,panel1;
	JTable table;
	JTextField txt;
	DefaultTableModel tableModel;
	ButtonGroup bg1;

	String title[]= {"이름","혈액형","거주지역","직급"};
	String blood[]= {"A형","B형","O형","AB형"};
	String region[] = {"서울","경기도","충청도","경상도","전라도","강원도","제주도"};
	String level[] = {"인턴","사원","대리","과장","차장","부장"};


	public Ex07_SwingFileMunje(String title) {

		super(title);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowOpened(e);
				FileReader fr=null;
				BufferedReader br=null;

				try {
					fr = new FileReader(SAWON);
					br = new BufferedReader(fr);

					while(true)
					{
						String s = br.readLine();
						if(s==null)
							break;

						String [] a = s.split(",");
						tableModel.addRow(a);

					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.setLocation(100, 100);//시작위치
		this.setSize(300, 300);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				windowClose();

			}
		});
	}

	public void windowClose()
	{
		FileWriter fw = null;
		try {
			fw = new FileWriter(SAWON);

			for(int i=0;i<table.getRowCount();i++)
			{
				String name = table.getValueAt(i, 0).toString();
				String blood = table.getValueAt(i, 1).toString();
				String region = table.getValueAt(i, 2).toString();
				String level = table.getValueAt(i, 3).toString();

				String s = name+","+blood+","+region+","+level+"\n";

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
	}

	public void initDesign()
	{

		panel = new JPanel();
		combo1 = new JComboBox<String>(blood);
		combo2 = new JComboBox<String>(region);
		combo3 = new JComboBox<String>(level);
		txt = new JTextField(5);
		panel.add(txt);
		panel.add(combo1);
		panel.add(combo2);		
		panel.add(combo3);
		this.add("South",panel);

		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		panel1 = new JPanel();
		bg1 = new ButtonGroup();
		btnSave = new JButton("정보 저장하기");
		panel1.add(btnSave);
		btnDelete = new JButton("정보 삭제하기");
		panel1.add(btnDelete);
		this.add("North",panel1);




		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = txt.getText();
				String blood1 = combo1.getSelectedItem().toString();
				String region1 = combo2.getSelectedItem().toString();
				String level1 = combo3.getSelectedItem().toString();

				Vector<String> list = new Vector<String>();
				list.add(name);
				list.add(blood1);
				list.add(region1);
				list.add(level1);
				tableModel.addRow(list);

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex07_SwingFileMunje.this, "행을 선택해주십시오");	
				}
				else
					tableModel.removeRow(row);
			}
		});
	}

	public void saveFile()
	{
		for(int i=0;i<table.getRowCount();i++)
		{
			String name = table.getValueAt(i, 0).toString();
			String blood = table.getValueAt(i, 1).toString();
			String region = table.getValueAt(i, 2).toString();
			String level = table.getValueAt(i, 3).toString();

			String data = name+","+blood+","+region+","+level+"\n";

			FileWriter fw=null;
			try {
				fw= new FileWriter(SAWON);


				fw.write(data);
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
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex07_SwingFileMunje a = new Ex07_SwingFileMunje("사원");

	}

}
