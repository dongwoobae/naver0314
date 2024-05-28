package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("badto")
@Builder
public class BoardAnswerDto {
    private int aidx;
    private int num;
    private String writer;
    private String content;
    private String myid;
    private Timestamp writeday;
}
