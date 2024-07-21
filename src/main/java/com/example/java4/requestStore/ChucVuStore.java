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
public class ChucVuStore {
    private String id;
    @NotEmpty
    private String ten;
    @NotEmpty
    private String trangThai;
}
