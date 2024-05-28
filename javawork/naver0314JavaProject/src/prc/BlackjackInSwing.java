package prc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BlackjackInSwing extends JFrame {
	JButton btnStart,btnEnd,btnGetCard,btnShowRs;
	DefaultTableModel tableModel;
	JTable table;
	
	
	public BlackjackInSwing(String title) {
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
		BlackJack bj = new BlackJack();
		JPanel p1 = new JPanel();
		btnStart=new JButton("게임시작");
		p1.add(btnStart);
		btnEnd=new JButton("게임 종료");
		p1.add(btnEnd);
		this.add("North",p1);
		
		String title[] = {"카드"};
		tableModel = new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add(table);
		
		JPanel p3 = new JPanel();
		btnGetCard = new JButton("한장 더 받기");
		p3.add(btnGetCard);
		btnShowRs = new JButton("체크");
		p3.add(btnShowRs);
		this.add("South",p3);
		
		
		//게임시작 버튼 구현
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(BlackjackInSwing.this, "블랙잭 시작");
				for(int i=0;i<2;i++)
				{
					bj.card();
					Vector<String> card = new Vector<String>();
					card.add(bj.card());
					tableModel.addColumn(i, card);
				}
				
			}
		});
//		String a = tableModel.getValueAt(1, 2).toString();
//		int aNum =Integer.parseInt(a.substring(a.length()-1, a.length()-1));
//		String b = tableModel.getValueAt(1, 3).toString();
//		int bNum =Integer.parseInt(b.substring(b.length()-1, b.length()-1));
//		int score = aNum+bNum;
//		System.out.println(score);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackjackInSwing a = new BlackjackInSwing("기본창");
				
	}

}
