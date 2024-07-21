package com.example.java4.requestStore;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HDCTStore {
    private String id;
    @NotEmpty
    private String idHoaDon;
    @NotEmpty
    private String  idChiTietSP;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String soLuong;
}
