package com.example.java4.entitiesLv1;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scoreBoard")
public class ScoreBoard {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="username")
    private String userName;
    @Column(name ="score")
    private Integer score;
    @Column(name="daytime")
    private LocalDateTime dayTime;
}
