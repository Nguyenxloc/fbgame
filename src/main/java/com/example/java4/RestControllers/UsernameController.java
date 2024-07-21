package com.example.java4.RestControllers;
import com.example.java4.entitiesLv1.ScoreBoard;
import com.example.java4.repositories.ScoreRepository;
import com.example.java4.requestStore.ScoreBoardStore;
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
@RequestMapping("username")
public class UsernameController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    ScoreRepository scoreRepo;
    public UsernameController() {

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
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid ScoreBoardStore newScore,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return ResponseEntity.ok(false);
        } else {
            LocalDateTime localNow = LocalDateTime.now();
            ScoreBoard scoreBoard = new ScoreBoard();
            scoreBoard.setUserName(newScore.getUserName());
            scoreBoard.setScore(0);
            scoreBoard.setDayTime(localNow);
//            System.out.println("check username existed: "+scoreRepo.isExisted(newScore.getUserName()));
            if(scoreRepo.isExisted(newScore.getUserName())==null){
                System.out.println("========================check: ");
                scoreRepo.save(scoreBoard);
                return ResponseEntity.ok(true);
            }
            else{
                return ResponseEntity.ok(false);
            }
        }
    }
}