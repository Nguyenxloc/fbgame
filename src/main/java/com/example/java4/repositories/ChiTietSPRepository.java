package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv1.ChucVu;
import com.example.java4.entitiesLv2.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChiTietSPRepository
        extends JpaRepository<ChiTietSP,String>, JpaSpecificationExecutor<ChiTietSP>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "SELECT ctsp FROM ChiTietSP ctsp where ctsp.trangThai=:trangThai ORDER BY ctsp.ngayTao asc")
    Page<ChiTietSP> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "SELECT ctsp FROM ChiTietSP ctsp where ctsp.trangThai=1 ORDER BY ctsp.ngayTao asc")
    Page<ChiTietSP> findAllByPage(Pageable pageable);
    @Query(value = "SELECT ctsp FROM ChiTietSP ctsp where ctsp.trangThai=:trangThai and ctsp.sp.id=:idSP ORDER BY ctsp.ngayTao asc")
    Page<ChiTietSP> findByIdSP(int trangThai,String idSP,Pageable pageAble);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE ChiTietSP ctsp SET ctsp.trangThai = 1 WHERE ctsp.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE ChiTietSP ctsp SET ctsp.trangThai = 0 WHERE ctsp.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM chitietsp",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM chitietsp where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM chitietsp where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
    @Query(value = "SELECT COUNT(*) FROM chitietsp where IdSP=:idsp",nativeQuery = true)
    Integer getCountByidsp(String idsp);
    @Query(value = "SELECT COUNT(*) FROM chitietsp where trangThai=1 and IdSP=:idsp",nativeQuery = true)
    Integer getCountStt1Byidsp(String idsp);
    @Query(value = "SELECT COUNT(*) FROM chitietsp where trangThai=0 and IdSP=:idsp",nativeQuery = true)
    Integer getCountStt0Byidsp(String idsp);
};
