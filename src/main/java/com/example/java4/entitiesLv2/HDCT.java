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
@Table(name="hoadonchitiet")
public class HDCT {
    @Id
    @Column(name="IdHDCT")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name="IdHoaDon",referencedColumnName = "Id")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name ="IdChiTietSP", referencedColumnName = "Id")
    private ChiTietSP chiTietSP;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private LocalDateTime ngayTao;
    @Column(name="SoLuong")
    private Integer soLuong;
}