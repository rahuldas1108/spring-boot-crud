package com.example.springbootcrud.feignClient;

import com.example.springbootcrud.dto.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

import static org.springframework.cloud.openfeign.encoding.HttpEncoding.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/*
@FeignClient (value = "dummyJson", url="https://dummyjson.com" )
public interface DummyJsonClient {

    @RequestMapping (method = RequestMethod.GET, value = "/users/{id}", produces = "application/json")
    User getUserById(@PathVariable("id") long id);
}
*/

public interface DummyJsonClient {
    //@RequestLine("GET /{id}")
    @RequestLine("GET /{id}")
    @Headers("Content-Type: application/json")
    User getUserById(@Param long id); //throws ThrowableProblem;
}