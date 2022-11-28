package com.example.kiiselbteynetimi;
public class GIDER {
    private int id2;
    private int gidermiktar;
    private String giderturu;
    public GIDER(int id, int gidermiktar, String giderturu) {
        this.id2 = id;
        this.gidermiktar = gidermiktar;
        this.giderturu = giderturu;
    }
    public GIDER() { }
    public int getId() { return id2; }
    public void setId(int id) {
        this.id2 = id;
    }
    public int getGidermiktar() {
        return gidermiktar;
    }
    public void setGidermiktar(int gidermiktar) {
        this.gidermiktar = gidermiktar;
    }
    public String getGiderturu() {
        return giderturu;
    }
    public void setGiderturu(String giderturu) {
        this.giderturu = giderturu;
    }
    @Override
    public String toString() {
        return "GİDER: MİKTAR: " + gidermiktar + ", GİDER TÜRÜ: " + giderturu ; }
}
