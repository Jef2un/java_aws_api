package com.jeffnalex.service.impl;

import com.jeffnalex.entity.AlbumAndArtist;
import com.jeffnalex.mapper.AlbumMapper;
import com.jeffnalex.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public List<AlbumAndArtist> list() {
        return albumMapper.list();
    }
}
