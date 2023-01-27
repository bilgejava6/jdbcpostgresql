package com.muhammet.repository.entity;

public class Adres extends BaseEntity {
    Long id;
    Long musteriid;
    String il;
    String ilce;
    String mahalle;

    public Adres() {
    }

    public Adres(Long id, Long musteriid, String il, String ilce, String mahalle) {
        this.id = id;
        this.musteriid = musteriid;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMusteriid() {
        return musteriid;
    }

    public void setMusteriid(Long musteriid) {
        this.musteriid = musteriid;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }
}
