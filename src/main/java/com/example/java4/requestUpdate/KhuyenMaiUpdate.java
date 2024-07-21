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
public class KhuyenMaiUpdate {
    @NotEmpty
    private String ten;
    @NotEmpty
    private String ngayBatDau;
    @NotEmpty
    private String ngayKetThuc;
    @NotEmpty
    private String giaTriGiam;
    @NotEmpty
    private String trangThai;
}
