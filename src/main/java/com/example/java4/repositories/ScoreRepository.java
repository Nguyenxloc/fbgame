package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ScoreBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreBoard, Integer> {
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "SELECT scb FROM ScoreBoard scb ORDER BY scb.score DESC")
    Page<ScoreBoard> getGloryBoard(Pageable pageable);
    @Query(value = "SELECT COUNT(*) FROM  scoreboard",nativeQuery = true)
    Integer getCountUser();
    @Query(value = "SELECT scb from ScoreBoard  scb WHERE  scb.userName = :username")
    ScoreBoard isExisted (@Param("username") String username);
    @Query(value = "SELECT scb FROM ScoreBoard scb ORDER BY scb.score DESC")
    List<ScoreBoard> getTopScore();
}
