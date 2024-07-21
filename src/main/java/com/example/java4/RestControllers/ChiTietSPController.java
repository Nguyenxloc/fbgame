package com.example.java4.RestControllers;

import com.example.java4.requestStore.ChiTietStore;
import com.example.java4.entitiesLv2.ChiTietSP;
import com.example.java4.entitiesNoMap.ChiTietSPNoMap;
import com.example.java4.repositories.*;
import com.example.java4.repositoriesNoMap.ChiTietSPRepoNoMap;
import com.example.java4.requestUpdate.ChiTietUpdate;
import com.example.java4.service.SearchSPCT;
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
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("chi-tiet-sp")
public class ChiTietSPController {
    //    @RequestMapping(name="login", method = RequestMethod.POST)
    @Autowired
    KichThuocRepository kichThuocRepo;
    @Autowired
    MauSacRepository mauSacRepo;
    @Autowired
    ChiTietSPRepository chiTietSPRepository;
    @Autowired
    ChiTietSPRepoNoMap chiTietSPRepoNoMap;
    @Autowired
    SearchSPCT search;

    public ChiTietSPController() {
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<ChiTietSP>> index(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(chiTietSPRepository.findByTrangThai(1,pageable).getContent());
    }

    @CrossOrigin
    @GetMapping("/detail-byidsp/{idSP}")
    public ResponseEntity<List<ChiTietSP>> GetIndexByIdSP(@PathVariable(value = "idSP") String idSP,@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(chiTietSPRepository.findByIdSP(1,idSP,pageable).getContent());
    }

    @CrossOrigin
    @GetMapping("/get-all")
    public ResponseEntity<List<ChiTietSP>> getAll(@RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(1);
        Pageable pageable = PageRequest.of(page-1,20);
        return ResponseEntity.ok(chiTietSPRepository.findAllByPage(pageable).getContent());
    }
    @CrossOrigin
    @GetMapping("count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(chiTietSPRepository.getCount());
    }
    @CrossOrigin
    @GetMapping("count-stt1")
    public ResponseEntity<Integer> getCountstt1() {
        return ResponseEntity.ok(chiTietSPRepository.getCountStt1());
    }
    @CrossOrigin
    @GetMapping("count-stt0")
    public ResponseEntity<Integer> getCountstt0() {
        return ResponseEntity.ok(chiTietSPRepository.getCountStt0());
    }
    @CrossOrigin
    @GetMapping("count-byidsp/{idsp}")
    public ResponseEntity<Integer> getCountByidsp(@PathVariable("idsp") String idSP) {
        return ResponseEntity.ok(chiTietSPRepository.getCountByidsp(idSP));
    }
    @CrossOrigin
    @GetMapping("count-stt1-byidsp/{idsp}")
    public ResponseEntity<Integer> getCountstt1ByIdsp(@PathVariable("idsp") String idSP) {
        return ResponseEntity.ok(chiTietSPRepository.getCountStt1Byidsp(idSP));
    }
    @CrossOrigin
    @GetMapping("count-stt0-byidsp/{idsp}")
    public ResponseEntity<Integer> getCountstt0ByIdsp(@PathVariable("idsp") String idSP) {
        return ResponseEntity.ok(chiTietSPRepository.getCountStt0Byidsp(idSP));
    }
    @CrossOrigin
    @GetMapping("/detail/{id}")
    public ResponseEntity<ChiTietSP> getDetail(@PathVariable(value = "id") ChiTietSP chiTietSP) {
        return ResponseEntity.ok(chiTietSP);
    }
    @CrossOrigin
    @PostMapping("/update/{id}")
    public ResponseEntity<Boolean> doUpdate(@PathVariable(value = "id") ChiTietSPNoMap chiTietSP,
                                            @RequestBody @Valid ChiTietUpdate newChiTietSP,
                                            BindingResult rs) {
          if(rs.hasErrors()){
              System.out.println("update error: "+rs);
              return ResponseEntity.ok(false);
          } else{
              chiTietSP.setIdMauSac(newChiTietSP.getIdMauSac());
              chiTietSP.setIdKichThuoc(newChiTietSP.getIdKichThuoc());
              chiTietSP.setIdChatLieu(newChiTietSP.getIdChatLieu());
              chiTietSP.setNamBH(Integer.valueOf(newChiTietSP.getNamBH()));
              chiTietSP.setMoTa(newChiTietSP.getMoTa());
              chiTietSP.setSoLuongTon(Integer.valueOf(newChiTietSP.getSoLuongTon()));
              chiTietSP.setGiaNhap(Long.valueOf(newChiTietSP.getGiaNhap()));
              chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaBan()));
              chiTietSP.setTrangThai(Integer.valueOf(newChiTietSP.getTrangThai()));
              chiTietSP.setHinhAnh1(newChiTietSP.getHinhAnh1());
              chiTietSP.setHinhAnh2(newChiTietSP.getHinhAnh2());
              chiTietSP.setHinhAnh3(newChiTietSP.getHinhAnh3());
              chiTietSPRepoNoMap.save(chiTietSP);
              return  ResponseEntity.ok(true);
          }
    }

    @CrossOrigin
    @PostMapping("/enable-status/{id}")
    public ResponseEntity<Integer> enableStatus(@PathVariable(value = "id") String id) {
            return ResponseEntity.ok(chiTietSPRepository.enableStt(id));
    }


    @CrossOrigin
    @PostMapping("/disable-status/{id}")
    public ResponseEntity<Integer> disableStatus(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(chiTietSPRepository.enableStt(id));
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity<Boolean> Store(
            @RequestBody @Valid ChiTietStore newChiTietSP,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println("temp error: " + result);
            return ResponseEntity.ok(false);
        } else {
            LocalDateTime localNow = LocalDateTime.now();
            ChiTietSPNoMap chiTietSP = new ChiTietSPNoMap();
            chiTietSP.setIdSp(newChiTietSP.getIdSp());
            chiTietSP.setIdMauSac(newChiTietSP.getIdMauSac());
            chiTietSP.setIdKichThuoc(newChiTietSP.getIdKichThuoc());
            chiTietSP.setIdChatLieu(newChiTietSP.getIdChatLieu());
            chiTietSP.setNamBH(Integer.valueOf(newChiTietSP.getNamBH()));
            chiTietSP.setMoTa(newChiTietSP.getMoTa());
            chiTietSP.setSoLuongTon(Integer.valueOf(newChiTietSP.getSoLuongTon()));
            chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaNhap()));
            chiTietSP.setGiaBan(Long.valueOf(newChiTietSP.getGiaBan()));
            chiTietSP.setTrangThai(Integer.valueOf(newChiTietSP.getTrangThai()));
            chiTietSP.setHinhAnh1(newChiTietSP.getHinhAnh1());
            chiTietSP.setHinhAnh2(newChiTietSP.getHinhAnh2());
            chiTietSP.setHinhAnh3(newChiTietSP.getHinhAnh3());
            chiTietSP.setNgayTao(localNow);
            chiTietSPRepoNoMap.save(chiTietSP);
            return ResponseEntity.ok(true);
        }
    }

    @CrossOrigin
    @GetMapping("/search")
    public ResponseEntity<List<ChiTietSP>> searchChiTietSanPham(@RequestParam Map<String, Object> params) {
        System.out.println("test hash map: "+params);
        List<ChiTietSP> chiTietSanPhams = search.searchChiTietSanPham(params);
        return ResponseEntity.ok(chiTietSanPhams);
    }
}