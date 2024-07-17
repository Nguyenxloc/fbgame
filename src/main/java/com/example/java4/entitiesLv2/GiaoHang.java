package com.example.java4.entitiesLv2;


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
@Table(name = "giaohang")
public class GiaoHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="HoTen")
    private String hoTen;
    @Column(name="Sdt")
    private String sdt;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private LocalDateTime ngayTao;
    @Column(name="IdPhuongXa")
    private String idPhuongXa;
    @Column(name="IdQuanHuyen")
    private String idQuanHuyen;
    @Column(name="IdTinhThanh")
    private String idTinhThanh;
    @Column(name="phuongXa")
    private String phuongXa;
    @Column(name="quanHuyen")
    private String quanHuyen;
    @Column(name="tinhThanh")
    private String tinhThanh;
}
