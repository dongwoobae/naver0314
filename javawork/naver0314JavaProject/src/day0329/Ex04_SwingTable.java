package day0329;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex04_SwingTable extends JFrame {
	JTable table;
	JLabel lblMessage;
	
	public Ex04_SwingTable(String title) {
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(450, 300);//창크기
		this.getContentPane().setBackground(new Color (200,191,231));//배경색 변경
		//상수 써도 되는데 원색이라 빡셈
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 x 누르면 종료
		//원래 x 누르면 setvisible이 false가 될뿐 종료되진않음
		this.initDesign();//프레임이 보이기 전에 해줘야됨. 각종 컴포넌트 생성
		this.setVisible(true);//창이 보일지 말지 여부
	}
	
	public void initDesign()
	{
		String [] title = {"이름","나이","혈액형","핸드폰","주소"};
		String [][] data = {
				{"이영자","32세","B","010-1234-1234","서울"},
				{"강호동","45세","O","010-8989-9999","부산"},
				{"유재석","50세","A","010-6562-5435","제주도"},
				{"제니","23세","AB","010-2345-6542","부천"}			
		};
		table=new JTable(data, title);
		//상단에 제목 출력
		 this.add("North",new JLabel("701 멤버현황", JLabel.CENTER));
		//프레임의 센터에 추가
		this.add("Center",new JScrollPane(table));//테이블도 스크롤바가 생겨야 한다(제목포함)
		
		//메세지 라벨을 하단에 출력
		lblMessage = new JLabel("결과 나올 곳...", JLabel.CENTER);
		lblMessage.setFont(new Font("",Font.BOLD ,16));
		this.add("South",lblMessage);
		
		//테이블 이벤트
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				//선택한 행번호
				int rowIndex=table.getSelectedRow();
				System.out.println(rowIndex);
				
			//클릭한 곳에서 이름,나이,주소 정도만 얻어서 메세지에 출력해보자
				String name = table.getValueAt(rowIndex, 0).toString();
				String age = table.getValueAt(rowIndex, 1).toString();
				String addr = table.getValueAt(rowIndex, 4).toString();
				
				String m =name+"님은 "+age+"이며 "+addr+"에 살고 있어요";
				lblMessage.setText(m);
			}
			
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_SwingTable a = new Ex04_SwingTable("테이블");
				
	}

}
