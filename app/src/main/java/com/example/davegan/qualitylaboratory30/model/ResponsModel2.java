package com.example.davegan.qualitylaboratory30.model;

import java.util.List;

public class ResponsModel2 {

    String kode,pesan;
    List<DataModel2> result;

    public List<DataModel2> getResult() { return result; }

    public void setResult(List<DataModel2> result) { this.result = result; }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) { this.pesan = pesan; }

}
