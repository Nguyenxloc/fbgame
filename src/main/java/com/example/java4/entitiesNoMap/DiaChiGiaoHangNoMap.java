package com.example.java4.entitiesNoMap;

import com.example.java4.entitiesLv2.GiaoHang;
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
@Table(name = "diachigiaohang")
public class DiaChiGiaoHangNoMap {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name ="TrangThai")
    private Integer trangThai;
    @Column(name ="NgayTao")
    private LocalDateTime ngayTao;
    @Column(name = "IdPhuongXa")
    private String idPhuongXa;
    @Column(name="IdQuanHuyen")
    private String idQuanHuyen;
    @Column(name="IdTinhThanh")
    private String idTinhThanh;
    @Column(name="IdGiaoHang")
    private String idGiaoHang;
}
