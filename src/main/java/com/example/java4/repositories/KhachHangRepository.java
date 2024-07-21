package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv1.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface KhachHangRepository
        extends JpaRepository<KhachHang,String>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select kh from KhachHang kh  ORDER BY kh.ngayTao asc")
    Page<KhachHang> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select kh from KhachHang kh  ORDER BY kh.ngayTao asc")
    Page<KhachHang> findAllByPage(Pageable pageable);
    Optional<KhachHang> findById(String id);
    @Query("UPDATE KhachHang kh SET kh.trangThai = 1 WHERE kh.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE KhachHang kh SET kh.trangThai = 0 WHERE kh.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM khachhang",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM khachhang where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM khachhang where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
};
