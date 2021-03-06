package com.example.springbootcrud.service;

import com.example.springbootcrud.controller.PostController;
import com.example.springbootcrud.dto.Post;
import com.example.springbootcrud.dto.User;
import com.example.springbootcrud.exception.NotFoundException;
import com.example.springbootcrud.feignClient.DummyJsonClient;
import com.example.springbootcrud.feignClient.JsonPlaceholderClient;
import feign.Feign;

import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class Postserviceimpl implements PostService {
    private static final Logger logger = LoggerFactory.getLogger(Postserviceimpl.class);
    @Autowired
    private JsonPlaceholderClient jsonPlaceholderClient;

    //@Autowired
    private DummyJsonClient dummyJsonClient= Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(DummyJsonClient.class,"https://dummyjson.com/users/" );



    @Override
    public List<Post> getAllPosts() {
        logger.info("Sending request to feign client inteface");
        List<Post> posts = jsonPlaceholderClient.getAllPosts();
        return posts;
    }

    @Override
    @Cacheable(cacheNames = "posts", key = "#id")
    public Post getPostById(long id)  {
        logger.info("Sending request to feign client inteface");
        Post post= jsonPlaceholderClient.getPostById(id);
       return post;
    }

    @Override
    @Cacheable(cacheNames = "user", key = "#id")
    public User getUserById(long id) throws URISyntaxException {
        logger.info("Sending request to User feign client inteface ");
      //  URI uri = new URI("https://dummyjson.com");
        User user= dummyJsonClient.getUserById(id);
        return user;
    }
}
