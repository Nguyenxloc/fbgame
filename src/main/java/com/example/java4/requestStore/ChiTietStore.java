package com.example.java4.requestStore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietStore {
    private String id;
    @NotEmpty
    private String idSp;
    @NotEmpty
    private String idMauSac;
    @NotEmpty
    private String idKichThuoc;
    @NotEmpty
    private String idChatLieu;
    @Positive
    private String namBH;
    @NotEmpty
    private String moTa;
    @Positive
    private String soLuongTon;
    @Positive
    private String giaNhap;
    @Positive
    private String giaBan;
    @NotEmpty
    private String  trangThai;
    @NotEmpty
    private String hinhAnh1;
    @NotEmpty
    private String hinhAnh2;
    @NotEmpty
    private String hinhAnh3;

}
