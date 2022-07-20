package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "songName",columnDefinition = "song_name")
    private String songName;
    private String singer;
    @Column(name = "songType",columnDefinition = "song_type")
    private String songType;
    private String link;

    public Song() {
    }

    public Song(Integer id, String songName, String singer, String songType, String link) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.songType = songType;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                ", songType='" + songType + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
