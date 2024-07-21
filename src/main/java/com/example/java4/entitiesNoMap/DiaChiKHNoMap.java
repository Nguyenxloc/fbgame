package com.example.java4.entitiesNoMap;

import com.example.java4.entitiesLv1.KhachHang;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diachikh")
public class DiaChiKHNoMap {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="IdKH")
    private String idKH;
    @Column(name="IdPhuongXa")
    private String idPhuongXa;
    @Column(name="IdQuanHuyen")
    private String idQuanHuyen;
    @Column(name="IdTinhThanh")
    private String IdTinhThanh;
    @Column(name="PhuongXa")
    private String phuongXa;
    @Column(name="QuanHuyen")
    private String quanHuyen;
    @Column(name ="TinhThanh")
    private String tinhThanh;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name ="NgayTao")
    private LocalDateTime ngayTao;
}
