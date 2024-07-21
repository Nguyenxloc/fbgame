package com.example.java4.repositoriesNoMap;
import com.example.java4.entitiesNoMap.DiaChiKHNoMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DiaChiKHNoMapRepo extends JpaRepository<DiaChiKHNoMap,String> {

}
