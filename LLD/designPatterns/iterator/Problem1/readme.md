# Playlist Iterator

```java
public record Song(
        String title,
        String artist,
        int durationSeconds
) {}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final List<Song> songs = new ArrayList<>();

    public void add(Song song) {
        songs.add(song);
    }

    // TODO
}
```

Make Playlist implement Iterable

The iterator should traverse songs in insertion order.


## Usages

```java
Playlist playlist = new Playlist();

playlist.add(new Song("Believer","Imagine Dragons",200));
playlist.add(new Song("Numb","Linkin Park",180));
playlist.add(new Song("Fix You","Coldplay",250));

for(Song song : playlist){
    System.out.println(song.title());
}
```

 ## Expected

```java
Believer
Numb
Fix You
```