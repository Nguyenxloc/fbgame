package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv2.NhanVien;
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
public interface NhanVienRepository
        extends JpaRepository<NhanVien,String>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select nv from NhanVien nv  ORDER BY nv.ngayTao asc")
    Page<NhanVien> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select nv from NhanVien nv  ORDER BY nv.ngayTao asc")
    Page<NhanVien> findAllByPage(Pageable pageable);
    Optional<NhanVien> findById(String id);
    @Query("UPDATE NhanVien nv SET nv.trangThai = 1 WHERE nv.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE NhanVien nv SET nv.trangThai = 0 WHERE nv.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM nhanvien",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM nhanvien",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM nhanvien",nativeQuery = true)
    Integer getCountStt0();
};
