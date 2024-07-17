package com.example.java4.service;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv1.KichThuoc;
import com.example.java4.entitiesLv1.MauSac;
import com.example.java4.entitiesLv1.SanPham;
import com.example.java4.entitiesLv2.ChiTietSP;
import com.example.java4.repositories.ChiTietSPRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@CrossOrigin
@Service
public class SearchSPCT {
    @Autowired
    private ChiTietSPRepository chiTietSPRepo;
    public List<ChiTietSP> searchChiTietSanPham(Map<String, Object> params) {
        return chiTietSPRepo.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            params.forEach((key, value) -> {
                if (value != null) {
                    if (value instanceof String) {
                        predicates.add(criteriaBuilder.like(root.get(key).as(String.class), "%" + value + "%"));
                    } else if (value instanceof Integer) {
                        predicates.add(criteriaBuilder.equal(root.get(key), value));
                    } else if (value instanceof BigDecimal) {
                        predicates.add(criteriaBuilder.equal(root.get(key), value));
                    } else if (value instanceof LocalDateTime) {
                        predicates.add(criteriaBuilder.equal(root.get(key), value));
                    } else if (value instanceof MauSac) {
                        predicates.add(criteriaBuilder.equal(root.get("mauSac").get("id"), ((MauSac) value).getId()));
                    } else if (value instanceof KichThuoc) {
                        predicates.add(criteriaBuilder.equal(root.get("kichThuoc").get("id"), ((KichThuoc) value).getId()));
                    } else if (value instanceof ChatLieu) {
                        predicates.add(criteriaBuilder.equal(root.get("chatLieu").get("id"), ((ChatLieu) value).getId()));
                    }  else if (value instanceof SanPham) {
                        predicates.add(criteriaBuilder.equal(root.get("sp").get("id"), ((SanPham) value).getId()));
                    }
                }
            });
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}