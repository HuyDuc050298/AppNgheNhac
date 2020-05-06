package com.example.appngenhac;

public class Song {
    public String namesong;
    public int filemp3;

    public Song(String namesong, int filemp3) {
        this.namesong = namesong;
        this.filemp3 = filemp3;
    }

    public String getNamesong() {
        return namesong;
    }

    public void setNamesong(String namesong) {
        this.namesong = namesong;
    }

    public int getFilemp3() {
        return filemp3;
    }

    public void setFilemp3(int filemp3) {
        this.filemp3 = filemp3;
    }
}
