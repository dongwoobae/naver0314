package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex02_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<String>();//hashset은 무작위 treeset은 오름차순 정렬
		set1.add("이청아");
		set1.add("유지태");
		set1.add("한소희");
		set1.add("유지태");
		set1.add("정우성");
		set1.add("고창석");
		
		System.out.println("set1 개수: "+set1.size());
		System.out.println("** 출력 1 **");
		for(String s:set1)
		{
			System.out.println(s);
		}System.out.println();
		
		System.out.println("** 출력 2 **");
		Iterator<String> iter = set1.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

}
