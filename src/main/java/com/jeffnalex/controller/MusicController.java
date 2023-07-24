package com.jeffnalex.controller;


import com.jeffnalex.result.Result;
import com.jeffnalex.entity.Song;
import com.jeffnalex.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musics")
@Slf4j
public class MusicController {
    @Autowired
    private MusicService musicService ;


    @GetMapping
    public Result<List<Song>> albumList(){
        List<Song> songList = musicService.list();
        return Result.success(songList);
    }

    @GetMapping("/albums/{album_id}")
    public Result<List<Song>> songListOfAlbum(@PathVariable Long album_id){
        List<Song> songList = musicService.getSongByAlbum(album_id);

        return Result.success(songList);
    }

    @GetMapping("/artists/{artist_id}")
    public Result<List<Song>> songListOfArtist(@PathVariable Long artist_id){
        List<Song> songList = musicService.getSongByArtist(artist_id);

        return Result.success(songList);
    }





}
