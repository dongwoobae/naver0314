package member.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
	private int id;
	private String userid;
	private String passwd;
	private String content;
	private Timestamp writeday;
}
