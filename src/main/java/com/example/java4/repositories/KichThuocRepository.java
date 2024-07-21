package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv1.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface KichThuocRepository
        extends JpaRepository<KichThuoc,String>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select kt from KichThuoc kt ORDER BY kt.ngayTao asc")
    Page<KichThuoc> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select kt from KichThuoc kt ORDER BY kt.ngayTao asc")
    Page<KichThuoc> findAllByPage(Pageable pageable);
    @Query("UPDATE KichThuoc kt SET kt.trangThai = 1 WHERE kt.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE KichThuoc kt SET kt.trangThai = 0 WHERE kt.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM kichthuoc",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM kichthuoc where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM kichthuoc where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
};
