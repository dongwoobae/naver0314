package day0325;


public class Shop {

	private String sang;
	private int su;
	private int dan;
	
	
	
	//setter,getter
	
	public String getSang() {
		return sang;
	}





	public void setSang(String sang) {
		this.sang = sang;
	}





	public int getSu() {
		return su;
	}





	public void setSu(int su) {
		this.su = su;
	}





	public int getDan() {
		return dan;
	}





	public void setDan(int dan) {
		this.dan = dan;
	}
//setSangpum으로 한번에 받기
	public void setSangpum(String sang,int su,int dan)
	{
		/*
		 * setSang(sang);
		 * setSu(su);
		 * setDan(dan);
		 * 으로 줘도 됨
		 */
		this.sang=sang;
		this.su=su;
		this.dan=dan;
	}
	//생성자 4개
	public Shop()//class가 public일때는 생성자도 public으로 해주는게 에러가 날 확률이 적다
	{
		this("상품미정",0,1000);
	}
	public Shop(String sang)
	{
		this(sang,10,1500);
	}
	public Shop(int su,int dan)
	{
		this("키위",su,dan);
	}
	public Shop(String sang,int su, int dan)
	{
		this.sang=sang;
		this.su=su;
		this.dan=dan;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
