package com.example.java4.requestStore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangStore {
    private String id;
    @NotEmpty
    private String hoTen;
    @NotEmpty
    private String ngaySinh;
    @NotEmpty
    private String sdt;
    @NotEmpty
    private String matKhau;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String idPhuongXa;
    @NotEmpty
    private String idQuanHuyen;
    @NotEmpty
    private String idTinhThanh;
    @NotEmpty
    private String phuongXa;
    @NotEmpty
    private String quanHuyen;
    @NotEmpty
    private String tinhThanh;
}
