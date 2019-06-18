package com.example.myapplication;

public class SinhVien {
    private int id;
    private String hoTen;
    private int tuoi;

    public SinhVien() {
    }

    public SinhVien(int id, String hoTen, int tuoi) {
        this.id = id;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
