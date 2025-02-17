package com.example.moviereviewweb.controller;

import com.example.moviereviewweb.Bean.Comment;
import com.example.moviereviewweb.Bean.Result;
import com.example.moviereviewweb.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")//添加评价————接收comment对象信息在请求体中
    public Result addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping("/comment/delete/{id}")//删除评价--接收评价的id
    public Result deleteComment(@PathVariable Integer id){
        return commentService.deletecomment(id);
    }

    @PostMapping("/comment/update")//更新评价 --动态sql更新
    public Result updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @GetMapping("/comment/deletebymovie/{id}")//删除评价，接收电影id
    public Result deleteByMovieId(@PathVariable Integer id){
        return commentService.deleteByMovieId(id);

    }

}
