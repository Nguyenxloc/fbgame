package com.example.java4.RestControllers;
import com.example.java4.entitiesLv2.DiaChiNV;
import com.example.java4.entitiesNoMap.DiaChiNVNoMap;
import com.example.java4.repositories.DiaChiNVRepository;
import com.example.java4.repositoriesNoMap.DiaChiNVNoMapRepo;
import com.example.java4.requestStore.DiaChiNVStore;
import com.example.java4.requestUpdate.DiaChiNVUpdate;
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
@RequestMapping("dia-chi-nv")
public class DiaChiNVController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    DiaChiNVRepository diaChiNVRepo;
    @Autowired
    DiaChiNVNoMapRepo diaChiNVNoMapRepo;
    public DiaChiNVController() {
    }

    @GetMapping("/index")
    public ResponseEntity<List<DiaChiNV>> index(@RequestParam("page") Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(diaChiNVRepo.findByTrangThai(1, pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("/get-all")
    public ResponseEntity<List<DiaChiNV>> getAll(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(diaChiNVRepo.findAllByPage(pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(diaChiNVRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountStt1() {
        return ResponseEntity.ok(diaChiNVRepo.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountStt0() {
        return ResponseEntity.ok(diaChiNVRepo.getCountStt0());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<DiaChiNV> getDetail(@PathVariable(name="id") DiaChiNV diaChiNV){
        return ResponseEntity.ok(diaChiNV);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") DiaChiNVNoMap diaChiNV,
                                            @RequestBody @Valid DiaChiNVUpdate newDiaChiNV,
                                            BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("update error: " + rs);
            return  ResponseEntity.ok(false);
        }
        else{
            diaChiNV.setIdPhuongXa(newDiaChiNV.getIdPhuongXa());
            diaChiNV.setIdQuanHuyen(newDiaChiNV.getIdQuanHuyen());
            diaChiNV.setIdTinhThanh(newDiaChiNV.getIdTinhThanh());
            diaChiNV.setPhuongXa(newDiaChiNV.getPhuongXa());
            diaChiNV.setQuanHuyen(newDiaChiNV.getQuanHuyen());
            diaChiNV.setTinhThanh(newDiaChiNV.getTinhThanh());
            diaChiNV.setTrangThai(Integer.valueOf(newDiaChiNV.getTrangThai()));
            diaChiNVNoMapRepo.save(diaChiNV);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiNVRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(diaChiNVRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid DiaChiNVStore newDiaChiNV,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: "+result);
            return ResponseEntity.ok(false);
        } else {
            LocalDateTime localNow = LocalDateTime.now();
            DiaChiNVNoMap diaChiNV = new DiaChiNVNoMap();
            diaChiNV.setId(newDiaChiNV.getId());
            diaChiNV.setIdNV(newDiaChiNV.getIdNV());
            diaChiNV.setIdPhuongXa(newDiaChiNV.getIdPhuongXa());
            diaChiNV.setIdQuanHuyen(newDiaChiNV.getIdQuanHuyen());
            diaChiNV.setIdTinhThanh(newDiaChiNV.getIdTinhThanh());
            diaChiNV.setTrangThai(Integer.valueOf(newDiaChiNV.getTrangThai()));
            diaChiNV.setNgayTao(localNow);
            diaChiNVNoMapRepo.save(diaChiNV);
            return ResponseEntity.ok(true);
        }
    }
}