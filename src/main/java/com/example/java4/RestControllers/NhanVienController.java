package com.example.java4.RestControllers;
import com.example.java4.requestStore.NhanVienStore;
import com.example.java4.entitiesLv2.NhanVien;
import com.example.java4.entitiesNoMap.NhanVienNoMap;
import com.example.java4.repositories.NhanVienRepository;
import com.example.java4.repositoriesNoMap.NhanVienRepoNoMap;
import com.example.java4.requestUpdate.NhanVienUpdate;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienRepository nvRepo;
    @Autowired
    NhanVienRepoNoMap nhanVienRepoNoMap;
    public NhanVienController() {
    }
    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<NhanVien>> index(@RequestParam("page") Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageale = PageRequest.of(page-1, 20);
        return ResponseEntity.ok(nvRepo.findByTrangThai(1,pageale).getContent());
    }

    @CrossOrigin
    @GetMapping("/get-all")
    public ResponseEntity<List<NhanVien>> getAll(@RequestParam("page") Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageale = PageRequest.of(page-1, 20);
        return ResponseEntity.ok(nvRepo.findAllByPage(pageale).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(nvRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountStt1() {
        return ResponseEntity.ok(nvRepo.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountStt0() {
        return ResponseEntity.ok(nvRepo.getCountStt0());
    }
    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<NhanVien> getDetail(@PathVariable("id") NhanVien nhanVien){
        return  ResponseEntity.ok(nhanVien);
    }
    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody @Valid NhanVienUpdate newNhanVien,
            BindingResult result,@PathVariable(value="id") NhanVienNoMap nv
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: " + result);
            return ResponseEntity.ok(false);
        }
        else{
            nv.setHoTen(newNhanVien.getHoTen());
            nv.setGioiTinh(newNhanVien.getGioiTinh());
            nv.setNgaySinh(Date.valueOf(newNhanVien.getNgaySinh()));
            nv.setSdt(newNhanVien.getSdt());
            nv.setMatKhau(newNhanVien.getMatKhau());
            nv.setIdChucVu(newNhanVien.getIdCV());
            nv.setTrangThai(Integer.valueOf(newNhanVien.getTrangThai()));
            nhanVienRepoNoMap.save(nv);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(nvRepo.enableStt(id));
    }


    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(nvRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid NhanVienStore newNhanVien,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("error temp: "+result);
            return ResponseEntity.ok(false);
        }
        else{
            LocalDateTime localNow = LocalDateTime.now();
            String ma = "NV"+(nvRepo.getCount()+1);
            NhanVienNoMap nv = new NhanVienNoMap();
            nv.setMa(ma);
            nv.setHoTen(newNhanVien.getHoTen());
            nv.setGioiTinh(newNhanVien.getGioiTinh());
            nv.setNgaySinh(Date.valueOf(newNhanVien.getNgaySinh()));
            nv.setSdt(newNhanVien.getSdt());
            nv.setMatKhau(newNhanVien.getMatKhau());
            nv.setIdChucVu(newNhanVien.getIdCV());
            nv.setTrangThai(Integer.valueOf(newNhanVien.getTrangThai()));
            nv.setNgayTao(localNow);
            nhanVienRepoNoMap.save(nv);
            return ResponseEntity.ok(true);
        }
    }
}