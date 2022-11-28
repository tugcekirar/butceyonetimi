package com.example.kiiselbteynetimi;
public class ALISVERIS {
    private int id4;
    private String alinacak;
    public ALISVERIS(int id4, String alinacak) {
        this.id4 = id4;
        this.alinacak = alinacak;
    }
    public ALISVERIS() { }
    public int getId4() {
        return id4;
    }
    public void setId4(int id4) {
        this.id4 = id4;
    }
    public String getAlinacak() {
        return alinacak;
    }
    public void setAlinacak(String alinacak) {
        this.alinacak = alinacak;
    }
    @Override
    public String toString() {
        return alinacak;
    }
}
