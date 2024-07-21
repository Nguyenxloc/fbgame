package com.example.java4.repositories;

import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv1.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChucVuRepository extends JpaRepository<ChucVu,String> {
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select cv from ChucVu cv ORDER BY cv.ngayTao asc")
    Page<ChucVu> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select cv from ChucVu cv ORDER BY cv.ngayTao asc")
    Page<ChucVu> findAllByPage(Pageable pageable);
    @Query("UPDATE ChucVu cv SET cv.trangThai = 1 WHERE cv.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE ChucVu cv SET cv.trangThai = 0 WHERE cv.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM chucvu",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM chucvu where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM chucvu where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
}
