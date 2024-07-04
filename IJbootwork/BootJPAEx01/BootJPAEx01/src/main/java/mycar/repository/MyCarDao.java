package mycar.repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarDao{

    private MyCarDaoInter daoInter;

    // db 저장
    public void insertCar(MyCarDto dto){
        daoInter.save(dto);//id 타입(당해 dto에서는 num)이 포함되어 있을 경우 자동으로 update 실행,
        //없을 경우 자동으로 insert 가 실행
    }

    //전체목록 가져오기
    public List<MyCarDto> getAllCars(){
        //return daoInter.findAll();//추가된 순서로 반환
        //return daoInter.findAll(Sort.by(Sort.Direction.DESC,"carprice"));//carprice의 desc 비싼것 부터 출력
        //return daoInter.findAll(Sort.by(Sort.Direction.ASC, "carname"));//자동차명의 오름차순
        return daoInter.findAll(Sort.by(Sort.Direction.DESC, "num"));
    }

    //하나의 목록 가져오기
    public MyCarDto getCarById(Long num){
        return daoInter.getReferenceById(num);
    }

    public void updateCar(MyCarDto dto){
        if(dto.getCarphoto().equals("no")){
            //daoInter.updateMycarNoPhoto(dto.getNum(),dto.getCarname(),dto.getCarprice(),dto.getCarcolor());
            //parameter들 따로따로 보낸거
            daoInter.updateMycarNoPhoto(dto);//dto 통째로 보낸거
        }else{
            daoInter.save(dto);//num이 포함되어 있을 경우 모든 컬럼 수정
        }
    }
}
