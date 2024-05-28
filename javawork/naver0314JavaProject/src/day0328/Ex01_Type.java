package day0328;

class GenericType<T>
{
	T []v;
	
	public void set(T[] n)
	{
		v=n;
	}
	
	public void print()
	{
		for(T s:v)
		{
			System.out.println(s+"  ");
		}System.out.println();
	}
}
public class Ex01_Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] s= {"장미꽃","안개꽃","국화꽃","후리지아"};
		Integer [] n = {100,89,90,78,99};
		Double [] d = {34.5,89.7,90.5};
		
		GenericType<String> gt1 = new GenericType<>();
		gt1.set(s);
		gt1.print();
		GenericType<Integer> gt2 = new GenericType<>();
		gt2.set(n);
		gt2.print();
		
		GenericType<Double> gt3 = new GenericType<>();
		gt3.set(d);
		gt3.print();
		
	}

}
