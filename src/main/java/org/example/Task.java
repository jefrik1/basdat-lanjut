package org.example;

public class Task {
    private String id;
    private String deskripsi;
    private boolean selesai;

    public Task() {
    }

    public Task(String deskripi, boolean selesai) {
        this.deskripsi = deskripsi;
        this.selesai = selesai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public void setSelesai(boolean selesai) {
        this.selesai = selesai;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", description='" + deskripsi + '\'' +
                ", completed=" + selesai +
                '}';
    }
}

