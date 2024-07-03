package mycar.repository;

import mycar.data.MyCarDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long> {
    
}
