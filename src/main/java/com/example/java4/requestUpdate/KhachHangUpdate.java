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
public class KhachHangUpdate {
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
}
