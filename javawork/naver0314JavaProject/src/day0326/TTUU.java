package day0326;

import java.io.FileWriter;

interface TU
{
	public void terminate();
}

class ListUp implements TU
{

	@Override
	public void terminate() {
		// TODO Auto-generated method stub
		System.out.println("삭제한다");
	}
	
}

public class TTUU
{
	public static void main(String[] args) {
		write(new ListUp());
	}
	public static void write(TU t)
	{
		t.terminate();
	}
	//public FileWriter(File type name = new type();)
}