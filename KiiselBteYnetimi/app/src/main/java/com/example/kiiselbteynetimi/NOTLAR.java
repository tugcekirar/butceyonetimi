package com.example.kiiselbteynetimi;
public class NOTLAR {
    private int id3;
    private String not;
    public NOTLAR(int id, String not) {
        this.id3 = id;
        this.not = not;
    }
    public NOTLAR() { }
    public int getId() { return id3; }
    public void setId(int id) { this.id3 = id; }
    public String getNot() { return not; }
    public void setNot(String not){ }
    @Override
    public String toString() {
        return "NOT: "+ not; }
}
