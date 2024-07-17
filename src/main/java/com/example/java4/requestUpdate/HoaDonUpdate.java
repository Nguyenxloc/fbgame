package com.example.java4.requestUpdate;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonUpdate {
    @NotEmpty
    private String pttt;
    private String idKhuyenMai;
    private String idNhanVien;
    private String idKhachHang;
    @NotEmpty
    private String ngayThanhToan;
    @NotEmpty
    private String trangThai;
}
