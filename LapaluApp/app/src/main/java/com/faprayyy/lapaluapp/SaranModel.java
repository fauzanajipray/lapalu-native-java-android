package com.faprayyy.lapaluapp;

public class SaranModel {
    private String nama;
    private String judul;
    private String laporan;

    public SaranModel(String nama, String judul, String laporan) {
        this.nama = nama;
        this.judul = judul;
        this.laporan = laporan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLaporan() {
        return laporan;
    }

    public void setLaporan(String laporan) {
        this.laporan = laporan;
    }
}
