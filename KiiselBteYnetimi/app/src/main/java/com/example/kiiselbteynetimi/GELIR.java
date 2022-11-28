package com.example.kiiselbteynetimi;
public class GELIR {
    private int id1;
    private int gelirmiktar;
    private String gelirturu;
    public GELIR(int id, int gelirmiktar, String gelirturu) {
        this.id1 = id;
        this.gelirmiktar = gelirmiktar;
        this.gelirturu = gelirturu;
    }
    public GELIR() { }
    public int getId() {
        return id1;
    }
    public void setId(int id) {
        this.id1 = id;
    }
    public int getGelirmiktar() {
        return gelirmiktar;
    }
    public void setGelirmiktar(int gelirmiktar) {
        this.gelirmiktar = gelirmiktar;
    }
    public String getGelirturu() {
        return gelirturu;
    }
    public void setGelirturu(String gelirturu) {
        this.gelirturu = gelirturu;
    }
    @Override
    public String toString() {
        return "GELİR: MİKTAR: " + gelirmiktar + ", GELİR TÜRÜ: " + gelirturu ; }
}
