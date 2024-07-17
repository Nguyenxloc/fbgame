package com.example.java4.repositories;
import com.example.java4.entitiesLv2.GiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface GiaohangRepository extends JpaRepository<GiaoHang,String> {
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select gh from GiaoHang gh  ORDER BY gh.ngayTao asc")
    Page<GiaoHang> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select gh from GiaoHang gh  ORDER BY gh.ngayTao asc")
    Page<GiaoHang> findAllByPage(Pageable pageable);
    @Query("UPDATE GiaoHang giaoHang SET giaoHang.trangThai = 1 WHERE giaoHang.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE GiaoHang giaoHang SET giaoHang.trangThai = 0 WHERE giaoHang.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM giaohang",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM giaohang where trangThai = 1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM giaohang where trangThai= 0",nativeQuery = true)
    Integer getCountStt0();
}
