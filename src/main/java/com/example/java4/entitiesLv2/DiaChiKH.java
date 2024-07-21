package com.example.java4.entitiesLv2;

import com.example.java4.entitiesLv1.KhachHang;
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
@Table(name = "diachikh")
public class DiaChiKH {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name="IdKH", referencedColumnName = "Id")
    private KhachHang kh;
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
    @Column(name="NgayTao")
    private LocalDateTime ngayTao;
}
