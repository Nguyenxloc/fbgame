package com.example.java4.requestStore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaChiNVStore {
    private String id;
    @NotEmpty
    private String idNV;
    @NotEmpty
    private String idPhuongXa;
    @NotEmpty
    private String idQuanHuyen;
    @NotEmpty
    private String IdTinhThanh;
    @NotEmpty
    private String phuongXa;
    @NotEmpty
    private String quanHuyen;
    @NotEmpty
    private String tinhThanh;
    @NotEmpty
    private String trangThai;
}
