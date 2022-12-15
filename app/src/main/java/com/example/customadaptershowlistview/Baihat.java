package com.example.customadaptershowlistview;

public class Baihat {
    private String tenBH;
    private String TenCaSi;
    private float ThoiLuong;

    public Baihat(String tenBH, String tenCaSi, float thoiLuong) {
        this.tenBH = tenBH;
        TenCaSi = tenCaSi;
        ThoiLuong = thoiLuong;
    }

    public String getTenBH() {
        return tenBH;
    }

    public String getTenCaSi() {
        return TenCaSi;
    }

    public float getThoiLuong() {
        return ThoiLuong;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public void setTenCaSi(String tenCaSi) {
        TenCaSi = tenCaSi;
    }

    public void setThoiLuong(float thoiLuong) {
        ThoiLuong = thoiLuong;
    }
}
