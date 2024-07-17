package com.example.java4.RestControllers;

import com.example.java4.entitiesLv2.GiaoHang;
import com.example.java4.entitiesNoMap.GiaoHangNoMap;
import com.example.java4.repositoriesNoMap.GiaoHangRepoNoMap;
import com.example.java4.requestStore.GiaoHangStore;
import com.example.java4.repositories.*;
import com.example.java4.requestUpdate.GiaoHangUpdate;
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
@RequestMapping("giao-hang")
public class GiaoHangController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    GiaohangRepository giaoHangRepo;
    @Autowired
    GiaoHangRepoNoMap giaoHangRepoNoMap;
    public GiaoHangController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<GiaoHang>> index(@RequestParam("page") Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(giaoHangRepo.findByTrangThai(1,pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("/get-all")
    public ResponseEntity<List<GiaoHang>> getAll(@RequestParam("page") Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(giaoHangRepo.findAllByPage(pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(giaoHangRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountStt1() {
        return ResponseEntity.ok(giaoHangRepo.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountstt0() {
        return ResponseEntity.ok(giaoHangRepo.getCountStt0());
    }

    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<GiaoHang> getDetail(@PathVariable(name="id") GiaoHang giaoHang){
         return ResponseEntity.ok(giaoHang);
    }

    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(name="id") GiaoHangNoMap giaoHang,
                                            @RequestBody @Valid GiaoHangUpdate newGiaoHang,
                                            BindingResult rs){
        if(rs.hasErrors()){
            System.out.println("update error: " + rs);
            return  ResponseEntity.ok(false);
        }
        else{
            giaoHang.setHoTen(newGiaoHang.getHoTen());
            giaoHang.setSdt(newGiaoHang.getSdt());
            giaoHang.setDiaChi(newGiaoHang.getDiaChi());
            giaoHang.setIdPhuongXa(newGiaoHang.getPhuongXa());
            giaoHang.setIdQuanHuyen(newGiaoHang.getQuanHuyen());
            giaoHang.setIdTinhThanh(newGiaoHang.getTinhThanh());
            giaoHang.setPhuongXa(newGiaoHang.getPhuongXa());
            giaoHang.setQuanHuyen(newGiaoHang.getQuanHuyen());
            giaoHang.setTinhThanh(newGiaoHang.getTinhThanh());
            giaoHang.setTrangThai(Integer.valueOf(newGiaoHang.getTrangThai()));
            giaoHangRepoNoMap.save(giaoHang);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(giaoHangRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(giaoHangRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid GiaoHangStore newGiaoHangStore,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("temp error at giaoHang: "+result);
            return ResponseEntity.ok(false);
        } else {
            LocalDateTime localNow = LocalDateTime.now();
            GiaoHangNoMap giaoHang= new GiaoHangNoMap();
            giaoHang.setId(newGiaoHangStore.getId());
            giaoHang.setHoTen(newGiaoHangStore.getHoTen());
            giaoHang.setSdt(newGiaoHangStore.getSdt());
            giaoHang.setDiaChi(newGiaoHangStore.getDiaChi());
            giaoHang.setIdPhuongXa(newGiaoHangStore.getPhuongXa());
            giaoHang.setIdQuanHuyen(newGiaoHangStore.getQuanHuyen());
            giaoHang.setIdTinhThanh(newGiaoHangStore.getTinhThanh());
            giaoHang.setPhuongXa(newGiaoHangStore.getPhuongXa());
            giaoHang.setQuanHuyen(newGiaoHangStore.getQuanHuyen());
            giaoHang.setTinhThanh(newGiaoHangStore.getTinhThanh());
            giaoHang.setTrangThai(Integer.valueOf(newGiaoHangStore.getTrangThai()));
            giaoHang.setNgayTao(localNow);
            giaoHangRepoNoMap.save(giaoHang);
            return ResponseEntity.ok(true);
        }
    }
}