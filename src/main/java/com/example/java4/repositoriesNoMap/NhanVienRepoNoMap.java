package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesLv2.NhanVien;
import com.example.java4.entitiesNoMap.NhanVienNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhanVienRepoNoMap
        extends JpaRepository<NhanVienNoMap,String>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    Page<NhanVien> findByTrangThai(int trangThai, Pageable pageable);
    Optional<NhanVienNoMap> findById(String id);
};
