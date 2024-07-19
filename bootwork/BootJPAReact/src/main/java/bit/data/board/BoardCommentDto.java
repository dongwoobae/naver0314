package bit.data.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boardanswer")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class BoardCommentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @ManyToOne
    @JoinColumn(name = "boardNum")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BoardDto boardDto;
    @Column(length = 50)
    private String nickname;
    @Column(length = 40,updatable = false)
    private String cpass;
    @Column(length = 40,updatable = false)
    private String loginip;
    @Column(length = 500)
    private String comment;
    @Column(updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp writeday;
}
