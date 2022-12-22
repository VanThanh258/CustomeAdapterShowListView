package com.example.customadaptershowlistview;

public class Baihat {
    private int MaBH;
    private String tenBH;
    private String TenCaSi;
    private float ThoiLuong;

    public Baihat( String tenBH, String tenCaSi, float thoiLuong) {
        this.tenBH = tenBH;
        TenCaSi = tenCaSi;
        ThoiLuong = thoiLuong;
    }

    public Baihat(){

    }

    public int getMaBH() {
        return MaBH;
    }

    public void setMaBH(int maBH) {
        MaBH = maBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getTenCaSi() {
        return TenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        TenCaSi = tenCaSi;
    }

    public float getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(float thoiLuong) {
        ThoiLuong = thoiLuong;
    }
}
