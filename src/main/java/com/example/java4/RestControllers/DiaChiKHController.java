package com.example.java4.RestControllers;
import com.example.java4.entitiesLv2.DiaChiKH;
import com.example.java4.entitiesNoMap.DiaChiKHNoMap;
import com.example.java4.repositories.DiaChiKHRepository;
import com.example.java4.repositoriesNoMap.DiaChiKHNoMapRepo;
import com.example.java4.requestStore.DiaChiKHStore;
import com.example.java4.requestUpdate.DiaChiKHUpdate;
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
@RequestMapping("dia-chi-kh")
public class DiaChiKHController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    DiaChiKHRepository diaChiKHRepo;
    @Autowired
    DiaChiKHNoMapRepo diaChiKHNoMapRepo;
    public DiaChiKHController() {
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<DiaChiKH>> index(@RequestParam("page") Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(diaChiKHRepo.findByTrangThai(1, pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("/get-all")
    public ResponseEntity<List<DiaChiKH>> getAll(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(diaChiKHRepo.findAllByPage(pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(diaChiKHRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountStt1() {
        return ResponseEntity.ok(diaChiKHRepo.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountStt0() {
        return ResponseEntity.ok(diaChiKHRepo.getCountStt0());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<DiaChiKH> getDetail(@PathVariable(name="id") DiaChiKH diaChiKH){
        return ResponseEntity.ok(diaChiKH);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") DiaChiKHNoMap diaChiKH,
                                            @RequestBody @Valid DiaChiKHUpdate newDiaChiKH,
                                            BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("update error: " + rs);
            return  ResponseEntity.ok(false);
        }
        else{
            diaChiKH.setIdPhuongXa(newDiaChiKH.getIdPhuongXa());
            diaChiKH.setIdQuanHuyen(newDiaChiKH.getIdQuanHuyen());
            diaChiKH.setIdTinhThanh(newDiaChiKH.getIdTinhThanh());
            diaChiKH.setPhuongXa(newDiaChiKH.getPhuongXa());
            diaChiKH.setQuanHuyen(newDiaChiKH.getQuanHuyen());
            diaChiKH.setTinhThanh(newDiaChiKH.getTinhThanh());
            diaChiKH.setTrangThai(Integer.valueOf(newDiaChiKH.getTrangThai()));
            diaChiKHNoMapRepo.save(diaChiKH);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiKHRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiKHRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid DiaChiKHStore newDiaChiKH,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return ResponseEntity.ok(false);
        } else {
            LocalDateTime localNow = LocalDateTime.now();
            DiaChiKHNoMap diaChiKH = new DiaChiKHNoMap();
            diaChiKH.setIdPhuongXa(newDiaChiKH.getIdPhuongXa());
            diaChiKH.setIdQuanHuyen(newDiaChiKH.getIdQuanHuyen());
            diaChiKH.setIdTinhThanh(newDiaChiKH.getIdTinhThanh());
            diaChiKH.setPhuongXa(newDiaChiKH.getPhuongXa());
            diaChiKH.setQuanHuyen(newDiaChiKH.getQuanHuyen());
            diaChiKH.setTinhThanh(newDiaChiKH.getTinhThanh());
            diaChiKH.setTrangThai(Integer.valueOf(newDiaChiKH.getTrangThai()));
            diaChiKH.setNgayTao(localNow);
            diaChiKHNoMapRepo.save(diaChiKH);
            return ResponseEntity.ok(true);
        }
    }
}