package anno.study.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Component("shopcont")
//@RequiredArgsConstructor// AllArgsConstructor 를 쓰면 다른 변수가 추가될 시 error남.
public class shopcontroller {
	//@NonNull
	@Autowired//autowired로도 가능.
	ShopDao dao;
	//ShopDao dao = new ShopDao();//여기서 new ShopDao를 생성하는 것인데 ShopDao dao; 라고만쓰면 
	//생성되지 않아서 AllargsConstructor로 생성을 해야함.
	
	public void insert(String sang, int su, int dan) {
		ShopDto dto = new ShopDto(sang,su,dan);
		dao.insert(dto);
	}
	
	public void delete(String sang) {
		dao.delete(sang);
	}
	
	public void update(String sang, int su, int dan) {
		ShopDto dto= new ShopDto();	
		dto.setSang(sang);
		dto.setDan(dan);
		dto.setSu(su);
		
		dao.update(dto);
		dao.selectAll();
	}
	
	
}
