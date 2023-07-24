package com.jeffnalex.controller;

import com.jeffnalex.entity.AlbumAndArtist;
import com.jeffnalex.result.Result;
import com.jeffnalex.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artists")
@Slf4j
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public Result<List<AlbumAndArtist>> list(){
        List<AlbumAndArtist> albumAndArtistList = artistService.list();

        return Result.success(albumAndArtistList);
    }
}
