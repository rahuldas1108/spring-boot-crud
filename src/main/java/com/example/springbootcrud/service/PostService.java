package com.example.springbootcrud.service;

import com.example.springbootcrud.dto.Post;
import com.example.springbootcrud.dto.User;
import com.example.springbootcrud.exception.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(long id) throws NotFoundException;

    User getUserById(long id);
}
