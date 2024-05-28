package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Alias("memberDto")
@Builder//builder 줄때는 allargs생성자 줘야함
@AllArgsConstructor
public class MemberDto {
	private int num;
	private String name;
	private String myid;
	private String passwd;	
	private String addr;	
	private String hp;	
	private String email;
	private String photo;	
	private String birthday;
	private Timestamp gaipday;
}
