package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("CommentDto")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CommentDto {
	private String userid;
	private String passwd;
	private String content;
	private Timestamp writeday;
	private int mynum;
}
