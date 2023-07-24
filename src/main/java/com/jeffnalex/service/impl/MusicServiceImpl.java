package com.jeffnalex.service.impl;

import com.jeffnalex.mapper.MusicMapper;
import com.jeffnalex.entity.Song;
import com.jeffnalex.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;
    @Override
    public List<Song> list() {
        return musicMapper.list();
    }

    @Override
    public List<Song> getSongByAlbum(Long album_id) {
        return musicMapper.getSongByAlbum(album_id);
    }

    @Override
    public List<Song> getSongByArtist(Long artist_id) {
        return musicMapper.getSongByArtist(artist_id);
    }
}
