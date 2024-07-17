package com.example.java4.entitiesNoMap;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "khuyenmai")
public class KhuyenMaiNoMap {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="Ma")
    private String ma;
    @Column(name ="Ten")
    private String ten;
    @Column(name ="NgayBatDau")
    private Date ngayBatDau;
    @Column(name="NgayKetThuc")
    private Date ngayKetThuc;
    @Column(name="GiaTriGiam")
    private Float giaTriGiam;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name ="NgayTao")
    private LocalDateTime ngayTao;
}
