package com.example.java4.repositories;

import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv2.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai,String> {
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select km from KhuyenMai km ORDER BY km.ngayTao asc")
    Page<KhuyenMai> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select km from KhuyenMai km ORDER BY km.ngayTao asc")
    Page<KhuyenMai> findAllByPage(Pageable pageable);
    @Query("UPDATE KhuyenMai km SET km.trangThai = 1 WHERE km.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE KhuyenMai km SET km.trangThai = 0 WHERE km.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM khuyenmai",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM khuyenmai where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM khuyenmai where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
}
