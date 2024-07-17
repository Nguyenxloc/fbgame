package com.example.java4.requestStore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonStore {
    private String id;
    @NotEmpty
    private String  pttt;
    private String idKhuyenMai;
    private String idNhanVien;
    private String idKhachHang;
    @NotEmpty
    private String ngayThanhToan;
    @NotEmpty
    private String trangThai;
}
