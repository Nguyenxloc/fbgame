package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesNoMap.KhuyenMaiNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepoNoMap extends JpaRepository<KhuyenMaiNoMap,String> {
    int ACTIVE  = 1;
    int INACTIVE =0;
    Page<KhuyenMaiNoMap> findByTrangThai(int trangThai, Pageable pageable);
}
