package data.service;

import data.dto.BoardAnswerDto;
import data.mapper.BoardAnswerMapperinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardAnswerService {
    @Autowired
    private BoardAnswerMapperinter anInter;
    public void insertAnswer(BoardAnswerDto dto){
        anInter.insertAnswer(dto);
    }
    public List<BoardAnswerDto> selectAllAnswer(int num){
        return anInter.selectAllAnswer(num);
    }
    public void deleteAnswer(int aidx){
        anInter.deleteAnswer(aidx);
    }
}
