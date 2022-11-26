package com.example.springbootcrud.controller;

import com.example.springbootcrud.dto.Post;
import com.example.springbootcrud.dto.User;
import com.example.springbootcrud.exception.NotFoundException;
import com.example.springbootcrud.service.EmployeeServiceImpl;
import com.example.springbootcrud.service.PostService;
import com.example.springbootcrud.service.RestTemplateImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    @Autowired
    private PostService postService;
    @Autowired
    RestTemplateImpl restTemplateimpl;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        logger.info("Sending request to service layer");
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable("postId") long id) throws NotFoundException {
        logger.info("Sending request to service layer");
        Post post= postService.getPostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) throws NotFoundException, URISyntaxException {
        logger.info("Sending request to service layer for user");
        User user= postService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/testRest")
    public void getuserRest() throws JsonProcessingException {
        logger.info("Sending request to service layer for user for testing rest template");
        restTemplateimpl.restService();
    }

    @GetMapping("/testRestDummy")
    public void getComments() throws JSONException {
        logger.info("Sending request to service layer for user for testing rest template");
        restTemplateimpl.dummyComments();
    }
}
