package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv2.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HoaDonRepository
        extends JpaRepository<HoaDon,String>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select hd from HoaDon hd ORDER BY hd.ngayTao asc")
    Page<HoaDon> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select hd from HoaDon hd ORDER BY hd.ngayTao asc")
    Page<HoaDon> findAllByPage(Pageable pageable);
    @Query(value = "SELECT TOP 5 * FROM HoaDonChiTiet ORDER BY ID DESC",
           nativeQuery = true)
    public List<HoaDon> findByTrangThai(int trangThai);
    @Query("UPDATE HoaDon hoaDon SET hoaDon.trangThai = 1 WHERE hoaDon.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE HoaDon hoaDon SET hoaDon.trangThai = 0 WHERE hoaDon.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM hoadon",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM hoadon where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM hoadon where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
};
