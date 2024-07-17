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
@Table(name="nhanvien")
public class NhanVienNoMap {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name ="Ma")
    private String ma;
    @Column(name ="HoTen")
    private String hoTen;
    @Column(name="GioiTinh")
    private String gioiTinh;
    @Column(name="NgaySinh")
    private Date ngaySinh;
    @Column(name="Sdt")
    private String sdt;
    @Column(name="MatKhau")
    private String matKhau;
    @Column(name="IdCV")
    private String idChucVu;
    @Column(name = "TrangThai")
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