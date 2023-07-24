package com.jeffnalex.service.impl;

import com.jeffnalex.entity.AlbumAndArtist;
import com.jeffnalex.mapper.ArtistMapper;
import com.jeffnalex.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistMapper artistMapper;

    @Override
    public List<AlbumAndArtist> list() {
        return artistMapper.list();
    }
}
