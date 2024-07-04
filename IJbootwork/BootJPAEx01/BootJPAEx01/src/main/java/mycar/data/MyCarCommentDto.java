package mycar.data;

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
@Table(name = "mycar_comment")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//불필요한 직렬화 방지
public class MyCarCommentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    @ManyToOne//당해 테이블이 多를 맡고 있으면 ManyToOne 하나를 맡고 있으면 OneToMany
    @JoinColumn(name = "num")
    @OnDelete(action = OnDeleteAction.CASCADE)//부모테이블의 값이 지워지면 해당 값에 묶여있는 애들 삭제
    private MyCarDto myCar;
    @Column(length = 200)
    private String comment;
    @Column(length = 30,updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    @CreationTimestamp//entity가 생성되는 시점에 자동 등록되도록
    private Timestamp writeDay;
}
