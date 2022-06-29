package com.example.springbootcrud.feignClient;

import com.example.springbootcrud.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient (value = "dummyJson", url="https://dummyjson.com" )
public interface DummyJsonClient {

    @RequestMapping (method = RequestMethod.GET, value = "/users/{id}", produces = "application/json")
    User getUserById(@PathVariable("id") long id);


}
