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
@Table(name="hoadon")
public class HoaDon {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="Ma")
    private String ma;
    @Column(name="pttt")
    private String pttt;
    @ManyToOne
    @JoinColumn(name="IdKM",referencedColumnName = "Id")
    private KhuyenMai khuyenMai;
    @ManyToOne
    @JoinColumn(name="IdNV",referencedColumnName ="Id")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name="IdKH", referencedColumnName = "Id")
    private KhachHang khachHang;
    @Column(name="NgayTao")
    private LocalDateTime ngayTao;
    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name="TrangThai")
    private int trangThai;
}