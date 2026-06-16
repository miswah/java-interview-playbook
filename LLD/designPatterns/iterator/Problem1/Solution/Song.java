package org.miswah;

public record Song(
        String title,
        String artist,
        int durationSeconds
) {}