package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesNoMap.HDCTNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HDCTRepoNoMap
        extends JpaRepository<HDCTNoMap,String>
{
      int ACTIVE  = 1;
      int INACTIVE =0;
      Page<HDCTNoMap> findByTrangThai(int trangThai, Pageable pageable);
};
