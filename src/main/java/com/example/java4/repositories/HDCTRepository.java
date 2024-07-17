package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv2.HDCT;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HDCTRepository
        extends JpaRepository<HDCT,String>
{
      int ACTIVE  = 1;
      int INACTIVE =0;
      @Query(value = "select hdct from HDCT hdct ORDER BY hdct.ngayTao asc")
      Page<HDCT> findByTrangThai(int trangThai, Pageable pageable);
      @Query(value = "select hdct from HDCT hdct ORDER BY hdct.ngayTao asc")
      Page<HDCT> findAllByPage(Pageable pageable);
      @Query("UPDATE HDCT hdct SET hdct.trangThai = 1 WHERE hdct.id=:id")
      int enableStt(@Param("id")String id);
      @Query("UPDATE HDCT hdct SET hdct.trangThai = 0 WHERE hdct.id=:id")
      int disableStt(@Param("id")String id);
      @Query(value = "SELECT COUNT(*) FROM hoadonchitiet",nativeQuery = true)
      Integer getCount();
      @Query(value = "SELECT COUNT(*) FROM hoadonchitiet where trangThai=1",nativeQuery = true)
      Integer getCountStt1();
      @Query(value = "SELECT COUNT(*) FROM hoadonchitiet where trangThai=0",nativeQuery = true)
      Integer getCountStt0();
};
