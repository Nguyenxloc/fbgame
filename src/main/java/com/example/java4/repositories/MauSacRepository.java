package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv1.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MauSacRepository
        extends JpaRepository<MauSac,String>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select ms from MauSac ms ORDER BY ms.ngayTao asc")
    Page<MauSac> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select ms from MauSac ms ORDER BY ms.ngayTao asc")
    Page<MauSac> findAllByPage(Pageable pageable);
    @Query("UPDATE MauSac ms SET ms.trangThai = 1 WHERE ms.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE MauSac ms SET ms.trangThai = 0 WHERE ms.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM mausac",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM mausac where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM mausac where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
} ;
