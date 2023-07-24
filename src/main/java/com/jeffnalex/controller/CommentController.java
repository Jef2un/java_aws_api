package com.jeffnalex.controller;

import com.jeffnalex.entity.Comment;
import com.jeffnalex.result.Result;
import com.jeffnalex.service.CommentService;
import com.jeffnalex.service.impl.CommentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@Slf4j
public class CommentController {
    @Autowired
    private CommentService commentService;


    @GetMapping
    public Result<List<Comment>> list(){
        List<Comment> commentList = commentService.list();
        log.info("讀取完畢．．．．．．．．．．．");
        return Result.success(commentList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        commentService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Comment comment){
        commentService.save(comment);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Comment comment){
        commentService.update(comment);
        return Result.success();
    }



}
