package enbities;

/**
 * Created by DoanTrang on 5/21/2018.
 */

public class Contact {
    private int id;
    private String ykien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYkien() {
        return ykien;
    }

    public void setYkien(String ykien) {
        this.ykien = ykien;
    }

    public Contact(int id, String ykien) {
        this.id = id;
        this.ykien = ykien;
    }

    public Contact() {
    }
}
