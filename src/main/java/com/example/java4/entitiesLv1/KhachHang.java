package com.example.java4.entitiesLv1;
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
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "Ma")
    private String ma;
    @Column(name="HoTen")
    private String hoTen;
    @Column(name="NgaySinh")
    private String ngaySinh;
    @Column(name="Sdt")
    private String sdt;
    @Column(name="MatKhau")
    private String matKhau;
    @Column(name="NgayTao")
    private LocalDateTime ngayTao;
    @Column(name ="TrangThai")
    private Integer trangThai;
}