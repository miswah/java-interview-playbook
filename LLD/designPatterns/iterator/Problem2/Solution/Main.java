package org.miswah;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        playlist.add(new Song("Believer","Imagine Dragons",200));
        playlist.add(new Song("Numb","Linkin Park",180));
        playlist.add(new Song("Fix You","Coldplay",250));

        for(Song song : playlist){
            System.out.println(song.title());
        }
    }
}
