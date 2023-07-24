package com.jeffnalex.service.impl;

import com.jeffnalex.entity.Comment;
import com.jeffnalex.mapper.CommentRepository;
import com.jeffnalex.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void save(Comment comment){

        commentRepository.save(comment);
    }

    public void delete(String id){
        commentRepository.deleteById(id);
    }

    public List<Comment> list(){
        return commentRepository.findAll();
    }

    public void update(Comment comment){
        commentRepository.save(comment);
    }


}
