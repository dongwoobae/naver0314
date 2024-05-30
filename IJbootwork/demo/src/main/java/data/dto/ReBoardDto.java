package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("ReBoardDto")
public class ReBoardDto {
	private int num;
	private String writer;
	private String myid;
	private String subject;
	private String uploadphoto;
	private String content;
	private int readcount;
	private int regroup;
	private int restep;
	private int relevel;
	private int commentCount;
	private Timestamp writeday;
}
