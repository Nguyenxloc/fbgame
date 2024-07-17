package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesLv2.ChiTietSP;
import com.example.java4.entitiesNoMap.ChiTietSPNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChiTietSPRepoNoMap
        extends JpaRepository<ChiTietSPNoMap,String>, JpaSpecificationExecutor<ChiTietSP>
{
    int ACTIVE  = 1;
    int INACTIVE =0;
    Page<ChiTietSP> findByTrangThai(int trangThai, Pageable pageable);
    Optional<ChiTietSPNoMap> findById(String id);
};
