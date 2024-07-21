package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.ScoreBoard;
import com.example.java4.repositories.ScoreRepository;
import com.example.java4.requestStore.ScoreBoardStore;
import com.example.java4.requestUpdate.ScoreBoardUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("score-board")
public class ScoreBoardController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    ScoreRepository scoreRepo;
    public ScoreBoardController() {

    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<ScoreBoard>> index(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(scoreRepo.getGloryBoard(pageable).getContent()) ;
    }

    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(scoreRepo.getCountUser());
    }
    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<ScoreBoard> getDetail(@PathVariable(value = "id") ScoreBoard  scoreBoard){
        return ResponseEntity.ok(scoreBoard);
    }

    @CrossOrigin
    @PostMapping("update")
    public ResponseEntity<Boolean> update(
            @RequestBody @Valid ScoreBoardUpdate newScore,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return ResponseEntity.ok(false);
        } else {
            LocalDateTime localNow = LocalDateTime.now();
            ScoreBoard scoreBoard = new ScoreBoard();
            scoreBoard.setUserName(newScore.getUserName());
            scoreBoard.setScore(Integer.valueOf(newScore.getScore()));
            scoreBoard.setDayTime(localNow);
            if(scoreRepo.isExisted(newScore.getUserName())==null){
                System.out.println("========================check: ");
                scoreRepo.save(scoreBoard);
                return ResponseEntity.ok(true);
            }
            else{
                ScoreBoard scoreBoard0 = scoreRepo.isExisted(newScore.getUserName());
                ScoreBoard scoreBoard1 = new ScoreBoard();
                scoreBoard1.setId(scoreBoard0.getId());
                scoreBoard1.setUserName(scoreBoard1.getUserName());
                scoreBoard1.setScore(Integer.valueOf(newScore.getScore()));
                scoreBoard1.setDayTime(scoreBoard1.getDayTime());
                scoreRepo.save(scoreBoard1);
                System.out.println("=================test score record: "+scoreBoard1.getScore());
                return ResponseEntity.ok(true);
            }
        }
    }
}