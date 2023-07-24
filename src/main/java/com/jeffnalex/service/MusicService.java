package com.jeffnalex.service;

import com.jeffnalex.entity.Song;

import java.util.List;

public interface MusicService {
    List<Song> list();

    List<Song> getSongByAlbum(Long album_id);

    List<Song> getSongByArtist(Long artist_id);
}
