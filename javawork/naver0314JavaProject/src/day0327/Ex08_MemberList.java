package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex08_MemberList {
	List<MemberDto> list = new ArrayList<MemberDto>();
	Scanner sc = new Scanner(System.in);
	static final String FILENAME = "c:/naver03/member.txt";

	public Ex08_MemberList() {
		// TODO Auto-generated constructor stub
		memberReadFile();
	}

	//파일읽기-처음 생성시 자동으로 파일에서 멤버 읽어오기
	public void memberReadFile()
	{

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			while(true)
			{
				String s = br.readLine();
				if(s==null)
					break;
				//강심장,01073387551,부산시 해운대구,A 이런 형태로 읽어옴
				//,로 분리하기
				String []a = s.split(",");

				//MemberDto 생성후 setter 로 데이터를 넣어주기
				MemberDto dto = new MemberDto();
				dto.setName(a[0]);
				dto.setHp(a[1]);
				dto.setAddr(a[2]);
				dto.setBlood(a[3]);

				//list 에 추가
				list.add(dto);

			}
			System.out.println("총 "+list.size()+"명의 멤버 정보를 읽어왔어요");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("읽어올 멤버 정보가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}


	}

	//종료시 파일 저장
	public void memberSaveFile()
	{
		FileWriter fw =null;
		try {
			fw = new FileWriter(FILENAME);
			for(MemberDto dto:list)
			{
				String s =dto.getName()+","+dto.getHp()+","+dto.getAddr()
				+","+dto.getBlood()+"\n";
				fw.write(s);
			}
			System.out.printf("총 %d명의 정보를 파일에 저장하였습니다\n",list.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getMenu()
	{
		int menu=0;
		System.out.println("1. 멤버정보 추가");
		System.out.println("2. 멤버삭제");
		System.out.println("3. 전체멤버 출력");
		System.out.println("4. 이름으로 검색");
		System.out.println("5. 핸드폰으로 검색");
		System.out.println("6. 저장 후 종료");
		System.out.println("=".repeat(30));

		try {
			menu = Integer.parseInt(sc.nextLine());
		}
		catch (NumberFormatException e){//문자 입력시 발생하는 오류
			System.out.println("번호를 숫자로 입력해주세요");
		}
		return menu;
	}

	//멤버 데이터 추가
	public void addMember()
	{
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("핸드폰을 입력하세요");
		String hp = sc.nextLine();
		System.out.println("주소를 입력하세요");
		String addr = sc.nextLine();
		System.out.println("혈액형을 입력하세요");
		String blood = sc.nextLine();

		MemberDto dto = new MemberDto(name, hp, addr, blood);
		//list에 추가
		list.add(dto);
		System.out.println(list.size()+"번째 멤버 정보를 추가하였습니다!");
	}

	//멤버 삭제
	public void deleteMember()
	{
		boolean f = false;

		/*
		 * 삭제할 이름을 입력후 해당 이름에 해당하는 멤버 정보를 삭제한다
		 * 없을 경우 "~님은 명단에 없습니다"
		 * 있을 경우 "~님의 정보를 삭제하였습니다"
		 */

		System.out.println("삭제할 이름을 입력하시오");
		String name = sc.nextLine();

		for(int i=0;i<list.size();i++)
		{
			MemberDto m = list.get(i);
			if(m.getName().trim().equals(name))
			{
				f=true;
				list.remove(i);
				break;
			}
		}
		if(f)
		{
			System.out.println(name+"님의 정보를 삭제하였습니다");
		} else {
			System.out.println(name + "님은 명단에 없습니다");
		}
	}

	//전체 멤버 출력
	public void writeMember()
	{
		System.out.println("\t** 전체 멤버 명단 **\n");
		System.out.println("=".repeat(65));
		System.out.println("번호\t이름\t\t핸드폰\t\t주소\t\t혈액형");
		System.out.println("=".repeat(65));
		for (int i=0;i<list.size();i++)
		{
			MemberDto dto = list.get(i);
			System.out.printf("%d\t%s\t%s\t\t%s\t%s형\n",i+1,dto.getName(),dto.getHp(),dto.getAddr(),
					dto.getBlood().toUpperCase());
		}
		System.out.println("=".repeat(65));
	}

	//이름으로 검색
	public void searchName()
	{
		int search =0;
		System.out.println("찾을 이름을 검색하시오");
		String name = sc.nextLine();
		for (int i=0;i<list.size();i++)
		{
			MemberDto m = list.get(i);
			if(m.getName().trim().startsWith(name))
			{
				search ++;
				System.out.printf("%s님은 리스트 %d번째에 있습니다\n",m.getName(),i+1);
				System.out.println("이름: "+m.getName());
				System.out.println("핸드폰: "+m.getHp());
				System.out.println("주소: "+m.getAddr());
				System.out.println("혈액형: "+m.getBlood());
				System.out.println("=".repeat(30));

			}
		}
		if (search == 0)
			System.out.println(name+"님은 리스트에 없습니다");
	}

	//전화번호로 검색
	public void searchPhone()
	{
		int search =0;
		System.out.println("찾을 사람의 휴대폰 뒷자리를 검색하시오");
		String num = sc.nextLine();
		for (int i=0;i<list.size();i++)
		{
			MemberDto m = list.get(i);
			if(m.getHp().trim().endsWith(num))
			{
				search ++;
				System.out.printf("%s님은 리스트 %d번째에 있습니다\n",m.getName(),i+1);
				System.out.println("이름: "+m.getName());
				System.out.println("핸드폰: "+m.getHp());
				System.out.println("주소: "+m.getAddr());
				System.out.println("혈액형: "+m.getBlood());
				System.out.println("=".repeat(30));

			}
		}
		if (search == 0)
			System.out.println(num+"번호를 가진 멤버는 없습니다");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex08_MemberList ex = new Ex08_MemberList();

		while(true)
		{
			int menu=ex.getMenu();

			switch (menu)
			{
			case 1:
				ex.addMember();
				break;
			case 2:
				ex.deleteMember();
				break;
			case 3:
				ex.writeMember();
				break;
			case 4:
				ex.searchName();
				break;
			case 5:
				ex.searchPhone();
				break;
			case 6:
				ex.memberSaveFile();
				System.out.println("** 멤버 정보를 저장 후 종료합니다 **");
				System.exit(0);//무조건 종료
			default:
				System.out.println("잘못된 번호입니다");

			}
		}
	}

}
