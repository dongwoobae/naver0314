package day0327;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex06_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<String> list1 = new Vector<String>();
		List<String> list1 = new ArrayList<String>();//vector 나 ArrayList 나 똑같다
		List<String> list2 = new Vector<String>(5,3);
		
		System.out.println("list 1 데이터 개수: "+list1.size());
		//System.out.println("list 1 할당 개수: "+((Vector<String>)list1).capacity());
		//capacity 는 list 에서 온 override 메소드가 아니라 vector 의 메소드로 다운해서 써줘야함
		System.out.println("list 2 데이터 개수: "+list2.size());//처음 할당 개수는 10개
		System.out.println("list 2 할당 개수: "+((Vector<String>)list2).capacity());
		String []str = {"red","blue","green","white","red","yellow","pink"};
		//list1, list2 에 배열 데이터 추가
		for(String s:str)
		{
			list1.add(s);
			list2.add(s);
		}
		
		System.out.println("=".repeat(20));
		System.out.println("list 1 데이터 개수: "+list1.size());
		//System.out.println("list 1 할당 개수: "+((Vector<String>)list1).capacity());
		System.out.println("list 2 데이터 개수: "+list2.size());
		System.out.println("list 2 할당 개수: "+((Vector<String>)list2).capacity());
		//할당 개수도 5->10개로 늘어남 
		//기본적으로 두배 늘어남
		//늘어나는 개수도 정해줄 수 있음
		System.out.println("** 출력 1 **");
		for(String s:list1) {
			System.out.println(s);//넣은 순서대로 나옴
		}System.out.println();
		
		System.out.println("** 출력 2 **");
		for(int i=0;i<list1.size();i++)
		{
			System.out.println(i+":"+list1.get(i));
		}System.out.println();
		
		System.out.println("** 출력 3 **");
		Iterator<String> iter = list1.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}System.out.println();
		
		System.out.println("** 출력 4 **");
		Object [] ob = list1.toArray();
		for(Object s:ob)
		{
			System.out.println((String)s);
		}
	}

}
