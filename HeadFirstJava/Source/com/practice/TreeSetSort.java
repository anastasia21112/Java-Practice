package com.practice;

import java.util.*;
import java.io.*;

public class TreeSetSort {

    ArrayList<Song> songList = new ArrayList<Song>();
    int val;
    
    public static void main(String[] args) {
	new TreeSetSort().go();
    }

    public void go() {
	getSongs();
	System.out.println(songList);
	Collections.sort(songList);
	System.out.println(songList);
	TreeSet<Song> songSet = new TreeSet<Song>();
	songSet.addAll(songList);
	System.out.println(songSet);
    }

    void getSongs() {
	try {
	    File file = new File("SongListMore.txt");
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    String line = null;
	    while((line = reader.readLine()) != null) {
		addSong(line);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    void addSong(String lineToParse) {
	String[] tokens = lineToParse.split("/");

	Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
	songList.add(nextSong);
    }
}