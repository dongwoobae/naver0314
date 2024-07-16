package bit.repository.mycar;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import bit.data.mycar.MycarDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MyCarDao {
	
	private MyCarDaoInter myCarDaoInter;
	
	public List<MycarDto> getAllDatas()
	{
		return myCarDaoInter.findAll(Sort.by(Sort.Direction.DESC,"num"));//번호의 내림차순
	}

	public void insertMycar(MycarDto mycar){
		myCarDaoInter.save(mycar);
	}
	public void deleteMycar(Long num){
		myCarDaoInter.deleteById(num);
	}
	//수정 - 구입일, 사진, 등록일 제외 수정
	public void updateMycar(MycarDto mycar){
		myCarDaoInter.save(mycar);//num이 포함이 되있으므로 수정이됨. (num이 없으면 insert가 실행됨)
	}
}










