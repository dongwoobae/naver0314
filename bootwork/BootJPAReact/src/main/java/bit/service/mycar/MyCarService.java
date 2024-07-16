package bit.service.mycar;

import java.util.List;

import org.springframework.stereotype.Service;

import bit.data.mycar.MycarDto;
import bit.repository.mycar.MyCarDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyCarService {
	
	private MyCarDao myCarDao;
	
	public List<MycarDto> getAllDatas()
	{
		return myCarDao.getAllDatas();
	}

	public void insertMycar(MycarDto mycar) {
		myCarDao.insertMycar(mycar);
	}
	public void deleteMycar(Long num){
		myCarDao.deleteMycar(num);
	}
	public void updateMycar(MycarDto mycar){
		myCarDao.updateMycar(mycar);
	}

}
