package com.example.java4.requestUpdate;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HDCTUpdate {
    @NotEmpty
    private String  idChiTietSP;
    @NotEmpty
    private String trangThai;
    @NotEmpty
    private String soLuong;
}
