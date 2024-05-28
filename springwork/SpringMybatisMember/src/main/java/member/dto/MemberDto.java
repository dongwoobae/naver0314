package member.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
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
