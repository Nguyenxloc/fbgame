package com.example.java4.requestUpdate;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChucVuUpdate {
    @NotEmpty
    private String ten;
    @NotEmpty
    private String trangThai;
}
