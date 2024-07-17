package com.example.java4.entitiesLv2;
import com.example.java4.entitiesLv1.ChatLieu;
import com.example.java4.entitiesLv1.KichThuoc;
import com.example.java4.entitiesLv1.MauSac;
import com.example.java4.entitiesLv1.SanPham;
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
@Table(name = "chitietsp")
public class ChiTietSP {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name="IdSP",referencedColumnName = "Id")
    private SanPham sp;
    @ManyToOne
    @JoinColumn(name="IdMauSac",referencedColumnName = "Id")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name="IdKichThuoc",referencedColumnName = "Id")
    private KichThuoc kichThuoc;
    @ManyToOne
    @JoinColumn(name="IdChatLieu",referencedColumnName = "Id")
    private ChatLieu chatLieu;
    @Column(name="NamBH")
    private int namBH;
    @Column(name="MoTa")
    private String moTa;
    @Column(name="SoLuongTon")
    private Integer soLuongTon;
    @Column(name="GiaNhap")
    private Long giaNhap;
    @Column(name="GiaBan")
    private Long giaBan;
    @Column(name="NgayTao")
    private LocalDateTime ngayTao;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="HinhAnh1")
    private String hinhAnh1;
    @Column(name="HinhAnh2")
    private String hinhAnh2;
    @Column(name="HinhAnh3")
    private String hinhAnh3;
}