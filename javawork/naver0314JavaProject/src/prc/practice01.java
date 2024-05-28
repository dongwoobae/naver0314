package prc;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class practice01 {
	final static double PI = 3.14;
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("원의 반지름 입력");
	double radius = sc.nextDouble();
	double s = radius*radius*PI;
	NumberFormat nf = NumberFormat.getInstance();
	nf.setMaximumFractionDigits(2);
	System.out.println("원의 면적: "+nf.format(s));
	List<String> list = new ArrayList<String>();
	String [] arr = list.toArray(new String [list.size()]);
}
}
