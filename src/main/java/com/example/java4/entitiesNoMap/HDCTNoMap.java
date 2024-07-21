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
@Table(name="hoadonchitiet")
public class HDCTNoMap {
    @Id
    @Column(name="IdHDCT")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="IdHoaDon")
    private String idHoaDon;
    @Column(name ="IdChiTietSP")
    private String idChiTietSP;
    @Column(name="TrangThai")
    private Integer trangThai;
    @Column(name="NgayTao")
    private LocalDateTime ngayTao;
    @Column(name="SoLuong")
    private Integer soLuong;
}