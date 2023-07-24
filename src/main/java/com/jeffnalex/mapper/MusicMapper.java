package com.jeffnalex.mapper;

import com.jeffnalex.entity.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicMapper {
    @Select("SELECT s.id,s.name ,group_concat(a.name) as artist \n" +
            "from Song s \n" +
            "join Song_Artist sa on s.id = sa.song_id\n" +
            "join Artist a on a.id = sa.artist_id\n" +
            "group by s.id")
    List<Song> list();

    @Select("select s.id, s.name, group_concat(a.name) as artist\n" +
            "from song s\n" +
            "join song_artist sa ON s.id = sa.song_id\n" +
            "join artist a ON sa.artist_id = a.id\n" +
            "where s.album_id = #{album_id}\n" +
            "group by s.id;")
    List<Song> getSongByAlbum(Long album_id);

    @Select("select s.id, s.name, group_concat(a.name) as artist\n" +
            "from artist a\n" +
            "join song_artist sa ON a.id = sa.artist_id\n" +
            "join song s ON sa.song_id = s.id\n" +
            "where a.id = #{artist_id}\n" +
            "group by s.id;")
    List<Song> getSongByArtist(Long artist_id);
}
