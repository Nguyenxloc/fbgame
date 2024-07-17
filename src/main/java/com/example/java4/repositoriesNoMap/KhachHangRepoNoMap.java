package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesNoMap.KhachHangNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachHangRepoNoMap
        extends JpaRepository<KhachHangNoMap,String>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    Page<KhachHangNoMap> findByTrangThai(int trangThai, Pageable pageable);
    Optional<KhachHangNoMap> findById(String id);
};
