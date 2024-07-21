package com.example.java4.RestControllers;
import com.example.java4.requestStore.ChucVuStore;
import com.example.java4.entitiesLv1.*;
import com.example.java4.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    ChucVuRepository chucVuRepo;
    public ChucVuController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<ChucVu>> index(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(chucVuRepo.findByTrangThai(1, pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("/get-all")
    public ResponseEntity<List<ChucVu>> getAll(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(chucVuRepo.findAllByPage(pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(chucVuRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountStt1() {
        return ResponseEntity.ok(chucVuRepo.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountStt0() {
        return ResponseEntity.ok(chucVuRepo.getCountStt0());
    }
    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<ChucVu> getDetail(@PathVariable(name="id") ChucVu chucVu){
             return ResponseEntity.ok(chucVu);
    }
    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") ChucVu chucVu,
                                            @RequestBody @Valid ChucVuStore newChucVu,
                                            BindingResult rs){
               if(rs.hasErrors()){
                   System.out.println("update error: " + rs);
                   return  ResponseEntity.ok(false);
               }
               else{
                   chucVu.setTen(newChucVu.getTen());
                   chucVu.setTrangThai(Integer.valueOf(newChucVu.getTrangThai()));
                   chucVuRepo.save(chucVu);
                   return ResponseEntity.ok(true);
               }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(chucVuRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(chucVuRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid ChucVuStore newChucVu,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("chuc vu accused failed: "+result);
            return ResponseEntity.ok(false);
        } else {
            LocalDateTime localNow = LocalDateTime.now();
            String ma = "CV"+(chucVuRepo.getCount()+1);
            ChucVu chucVu = new ChucVu();
            chucVu.setMa(ma);
            chucVu.setTen(newChucVu.getTen());
            chucVu.setTrangThai(Integer.valueOf(newChucVu.getTrangThai()));
            chucVu.setNgayTao(localNow);
            chucVuRepo.save(chucVu);
            return ResponseEntity.ok(true);
        }
    }
}