package bit.data.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name="reactboard")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNum;
    @Column(length = 100)
    private String title;
    @Column(length = 2000)
    private String content;
    @Column(updatable = false)
    private int readcount;
    @Column(length = 60)
    private String photo;
    @Column(length = 30, updatable = false)
    private String writer;
    @Column(length = 30, updatable = false)
    private String pass;
    @Column(updatable=false)
    @CreationTimestamp
    @JsonFormat
    private Timestamp writeday;
    @Transient
    private int answercount;
}
