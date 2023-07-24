package com.jeffnalex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@CompoundIndex(def = "{'userid':1,'nickname':-1}") 複合索引
public class Comment implements Serializable {

    @Id
    private String _id;
    private String content;
    private Date publishDate;
    @Indexed // 單條索引
    private String userId;
    private String userName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Integer likeNum;
    private String state;
    private String musicId;
}
