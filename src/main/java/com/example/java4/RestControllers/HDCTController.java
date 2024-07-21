package com.example.java4.RestControllers;
import com.example.java4.requestStore.HDCTStore;
import com.example.java4.entitiesLv2.HDCT;
import com.example.java4.entitiesNoMap.HDCTNoMap;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.HDCTRepoNoMap;
import com.example.java4.requestUpdate.HDCTUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("hdct")
public class HDCTController {
    @Autowired
    HoaDonRepository hdRepo;
    @Autowired
    ChiTietSPRepository spctRepository;
    @Autowired
    HDCTRepository hdctRepository;
    @Autowired
    HDCTRepoNoMap hdctRepoNoMap;
    public HDCTController() {
    }

    public Timestamp StringsToTimeStampt(String date, String time){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            java.util.Date parsedDate = dateFormat.parse(date +" "+time+":00.000");
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            System.out.println("timestamp:"+timestamp);
            return timestamp;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[]  TimeStampToStrings(Timestamp timeStampt){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(timeStampt);
            String[] parts = s.split(" ");
            return parts;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @CrossOrigin()
    @GetMapping("/index")
    public ResponseEntity<List<HDCT>> getIndex(@RequestParam("page")Optional<Integer> pageParams) {
        int page = pageParams.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(hdctRepository.findByTrangThai(1,pageable).getContent());
    }

    @CrossOrigin()
    @GetMapping("/get-all")
    public ResponseEntity<List<HDCT>> getAll(@RequestParam("page")Optional<Integer> pageParams) {
        int page = pageParams.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(hdctRepository.findAllByPage(pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(hdctRepository.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountstt1() {
        return ResponseEntity.ok(hdctRepository.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountstt0() {
        return ResponseEntity.ok(hdctRepository.getCountStt0());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<HDCT> getDetail(@PathVariable(value = "id") HDCT hdct){
        return ResponseEntity.ok(hdct);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") HDCTNoMap hdct,
                                            @RequestBody @Valid HDCTUpdate newHDCT,
                                            BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("update hdct error: " + rs);
            return  ResponseEntity.ok(false);
        }
        else{
            hdct.setIdChiTietSP(newHDCT.getIdChiTietSP());
            hdct.setTrangThai(Integer.valueOf(newHDCT.getTrangThai()));
            hdct.setSoLuong(Integer.valueOf(newHDCT.getSoLuong()));
            hdctRepoNoMap.save(hdct);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(hdctRepository.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(hdctRepository.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid HDCTStore newHDCT, BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: " + result);
            return ResponseEntity.ok(false);
        } else {
            LocalDateTime localNow = LocalDateTime.now();
            HDCTNoMap hdct = new HDCTNoMap();
            hdct.setIdHoaDon(newHDCT.getIdHoaDon());
            hdct.setIdChiTietSP(newHDCT.getIdChiTietSP());
            hdct.setTrangThai(Integer.valueOf(newHDCT.getTrangThai()));
            hdct.setSoLuong(Integer.valueOf(newHDCT.getSoLuong()));
            hdct.setNgayTao(localNow);
            hdctRepoNoMap.save(hdct);
            return ResponseEntity.ok(true);
        }
    }
}