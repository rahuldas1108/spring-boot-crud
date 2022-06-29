package com.example.springbootcrud.feignClient;

import com.example.springbootcrud.dto.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient (value = "jplaceholder", url="https://jsonplaceholder.typicode.com/" )
public interface JsonPlaceholderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getAllPosts();

    @RequestMapping (method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
    Post getPostById(@PathVariable ("postId") long id);
}
//https://dummyjson.com/users/2