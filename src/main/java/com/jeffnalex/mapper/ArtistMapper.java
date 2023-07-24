package com.jeffnalex.mapper;

import com.jeffnalex.entity.AlbumAndArtist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArtistMapper {

    @Select("select * from Artist")
    List<AlbumAndArtist> list();
}
