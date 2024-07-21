package com.example.java4.repositories;
import com.example.java4.entitiesLv2.DiaChiKH;
import com.example.java4.entitiesLv2.DiaChiNV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DiaChiNVRepository extends JpaRepository<DiaChiNV,String> {
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select dcnv from DiaChiNV dcnv ORDER BY dcnv.ngayTao desc")
    Page<DiaChiNV> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select dcnv from DiaChiNV dcnv ORDER BY dcnv.ngayTao desc")
    Page<DiaChiNV> findAllByPage(Pageable pageable);
    @Query("UPDATE DiaChiNV dcnv SET dcnv.trangThai = 1 WHERE dcnv.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE DiaChiNV dcnv SET dcnv.trangThai = 0 WHERE dcnv.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM diachinv",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM diachinv where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM diachinv where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
}
