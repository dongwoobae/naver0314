package mycar.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "mycar")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MyCarDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @Column(name = "carname",length = 30)//name이 변수명이랑 같을 경우 생략 가능
    private String carname;
    private int carprice;
    @Column(length = 20)
    private String carcolor;
    @Column(length = 20)
    private String carguip;
    @Column(length = 100)
    private String carphoto;
    @CreationTimestamp
    @Column(updatable = false)//이걸 안주면 수정 시 따로 이 값을 안주면 null값이 들어감
    private Timestamp writeday;
    @Transient//dto에서는 받지만 table column으로는 생성이 안됨
    private int commentcount;//댓글 개수
    @Transient
    private String message;//하고 싶은 말
}
