package com.jeffnalex.mapper;

import com.jeffnalex.entity.AlbumAndArtist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AlbumMapper {

    @Select("select * from Album")
    List<AlbumAndArtist> list();
}
