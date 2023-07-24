package com.jeffnalex.service;

import com.jeffnalex.entity.Comment;

import java.util.List;

public interface CommentService {


    List<Comment> list();

    void delete(String id);

    void save(Comment comment);

        void update(Comment comment);
}
