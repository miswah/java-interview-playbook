package org.miswah;

import java.util.*;

public class Playlist implements Iterable<Song> {

    private final List<Song> songs = new ArrayList<>();
    private int size = 0;

    public void add(Song song) {
        songs.add(song);
        size++;
    }

    @Override
    public Iterator<Song> iterator() {
        return new PlaylistIterator<Song>();
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }

    // TODO

    private class PlaylistIterator<S> implements Iterator<Song> {
        private int currentIndex = songs.size() - 1;
        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public Song next() {
           if(!hasNext()){
               throw new NoSuchElementException("No more elements in the collection.");
           }
           return songs.get(currentIndex--);
        }
    }
}
