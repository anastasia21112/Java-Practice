package com.practice;

public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public boolean equals(Object aSong) {
	Song s = (Song) aSong;
	return getTitle().equals(s.getTitle());
    }

    public int hashCode() {
	return title.hashCode();
    }
    
    Song(String t, String a, String r, String b) {
	title = t;
	artist = a;
	rating = r;
	bpm = b;
    }

    public int compareTo(Song s) {
	return title.compareTo(s.getTitle());
    }

    public String getTitle() {
	return title;
    }

    public String getArtist() {
	return artist;
    }

    public String getRating() {
	return rating;
    }

    public String getBPM() {
	return bpm;
    }

    public String toString() {
	return title + " : " + artist;
    }
}
