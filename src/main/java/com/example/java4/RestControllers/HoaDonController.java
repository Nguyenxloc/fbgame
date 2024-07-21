package com.example.java4.RestControllers;
import com.example.java4.requestStore.HoaDonStore;
import com.example.java4.entitiesLv2.HoaDon;
import com.example.java4.entitiesNoMap.HoaDonNoMap;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.HoaDonRepoNoMap;
import com.example.java4.requestUpdate.HoaDonUpdate;
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
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepository hdRepo;
    @Autowired
    private HoaDonRepoNoMap hoaDonRepoNoMap;
    public HoaDonController() {
    }
    @CrossOrigin
    @GetMapping("index")
    public ResponseEntity<List<HoaDon>> index(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1, 20);
        return ResponseEntity.ok(hdRepo.findByTrangThai(1, pageable ).getContent());
    }
    @CrossOrigin
    @GetMapping("get-all")
    public ResponseEntity<List<HoaDon>> getAll(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1, 20);
        return ResponseEntity.ok(hdRepo.findAllByPage(pageable ).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(hdRepo.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountstt1() {
        return ResponseEntity.ok(hdRepo.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountstt0() {
        return ResponseEntity.ok(hdRepo.getCountStt0());
    }

    @CrossOrigin
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<HoaDon> getDetail(@PathVariable(value = "id") HoaDon hoaDon){
             return ResponseEntity.ok(hoaDon);
    }
    @CrossOrigin
    @PostMapping("update/{id}")
    public ResponseEntity<Boolean> doUpdate(
            @RequestBody  @Valid HoaDonUpdate newHoaDon,
            BindingResult result, @PathVariable(value = "id") HoaDonNoMap hd
    ) {
        if (result.hasErrors()){
            System.out.println("tempt error: "+result);
            return ResponseEntity.ok(false);
        }
        else{
            hd.setPttt(newHoaDon.getPttt());
            hd.setIdKhuyenMai(newHoaDon.getIdKhuyenMai());
            hd.setIdNhanVien(newHoaDon.getIdNhanVien());
            hd.setIdKhachHang(newHoaDon.getIdKhachHang());
            hd.setNgayThanhToan(Date.valueOf(newHoaDon.getNgayThanhToan()));
            hd.setTrangThai(Integer.valueOf(newHoaDon.getTrangThai()));
            hoaDonRepoNoMap.save(hd);
            return  ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(hdRepo.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(hdRepo.enableStt(id));
    }
    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> save(
            @RequestBody @Valid HoaDonStore newHoaDon,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("temp error: "+ result);
            return ResponseEntity.ok(false);
        }
        else{
            //conduct ma by select count
            LocalDateTime localNow = LocalDateTime.now();
            String ma = "HD"+(hdRepo.getCount()+1);
            HoaDonNoMap hd = new HoaDonNoMap();
            hd.setMa(ma);
            hd.setPttt(newHoaDon.getPttt());
            hd.setIdKhuyenMai(newHoaDon.getIdKhuyenMai());
            hd.setIdNhanVien(newHoaDon.getIdNhanVien());
            hd.setIdKhachHang(newHoaDon.getIdKhachHang());
            hd.setNgayThanhToan(Date.valueOf(newHoaDon.getNgayThanhToan()));
            hd.setTrangThai(Integer.valueOf(newHoaDon.getTrangThai()));
            hd.setNgayTao(localNow);
            hoaDonRepoNoMap.save(hd);
            return ResponseEntity.ok(true);
        }
    }
}