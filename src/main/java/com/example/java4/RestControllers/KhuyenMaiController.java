package com.example.java4.RestControllers;
import com.example.java4.requestStore.KhuyenMaiStore;
import com.example.java4.entitiesLv2.KhuyenMai;
import com.example.java4.entitiesNoMap.KhuyenMaiNoMap;
import com.example.java4.repositories.KhuyenMaiRepository;
import com.example.java4.repositoriesNoMap.KhuyenMaiRepoNoMap;
import com.example.java4.requestUpdate.KhuyenMaiUpdate;
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
@RequestMapping("khuyen-mai")
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepo;
    @Autowired
    KhuyenMaiRepoNoMap khuyenMaiRepoNoMap;
    public KhuyenMaiController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<KhuyenMai>> index(@RequestParam("page")Optional<Integer> pageParam){
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1, 20);
        return ResponseEntity.ok(khuyenMaiRepo.findByTrangThai(1,pageable).getContent());
    }

    @CrossOrigin
    @GetMapping("/get-all")
    public ResponseEntity<List<KhuyenMai>> getAll(@RequestParam("page")Optional<Integer> pageParam){
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1, 20);
        return ResponseEntity.ok(khuyenMaiRepo.findAllByPage(pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(khuyenMaiRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountstt1() {
        return ResponseEntity.ok(khuyenMaiRepo.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountstt0() {
        return ResponseEntity.ok(khuyenMaiRepo.getCountStt0());
    }

    @CrossOrigin
    @GetMapping("detail/{id}")
    public ResponseEntity<KhuyenMai> getDetail(@PathVariable(value = "id") KhuyenMai khuyenMai){
        return ResponseEntity.ok(khuyenMai);
    }
    @CrossOrigin
    @PostMapping ("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@RequestBody @Valid KhuyenMaiUpdate newKhuyenMai, BindingResult result,
                                            @PathVariable(value ="id") KhuyenMaiNoMap khuyenMai){
        if (result.hasErrors()) {
            System.out.println("error at khuyen mai "+result);
            return ResponseEntity.ok(false);
        }
        else{
            khuyenMai.setTen(newKhuyenMai.getTen());
            khuyenMai.setNgayBatDau(Date.valueOf(newKhuyenMai.getNgayBatDau()));
            khuyenMai.setNgayKetThuc(Date.valueOf(newKhuyenMai.getNgayKetThuc()));
            khuyenMai.setGiaTriGiam(Float.valueOf(newKhuyenMai.getGiaTriGiam()));
            khuyenMai.setTrangThai(Integer.valueOf(newKhuyenMai.getTrangThai()));
            khuyenMaiRepoNoMap.save(khuyenMai);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(khuyenMaiRepo.enableStt(id));
    }


    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(khuyenMaiRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid KhuyenMaiStore newKhuyenMai,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            LocalDateTime localNow = LocalDateTime.now();
            String ma = "KM"+(khuyenMaiRepo.getCount()+1);
            KhuyenMaiNoMap khuyenMai = new KhuyenMaiNoMap();
            khuyenMai.setMa(ma);
            khuyenMai.setTen(newKhuyenMai.getTen());
            khuyenMai.setNgayBatDau(Date.valueOf(newKhuyenMai.getNgayBatDau()));
            khuyenMai.setNgayKetThuc(Date.valueOf(newKhuyenMai.getNgayKetThuc()));
            khuyenMai.setGiaTriGiam(Float.valueOf(newKhuyenMai.getGiaTriGiam()));
            khuyenMai.setTrangThai(Integer.valueOf(newKhuyenMai.getTrangThai()));
            khuyenMai.setNgayTao(localNow);
            khuyenMaiRepoNoMap.save(khuyenMai);
            //call procedure
            return ResponseEntity.ok(true);
        }
    }
}