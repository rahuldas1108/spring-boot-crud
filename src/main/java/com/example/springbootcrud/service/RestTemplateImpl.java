package com.example.springbootcrud.service;

import com.example.springbootcrud.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
@Service
public class RestTemplateImpl {

    @Value("${rest.endpoint}")
    private String restUrl;

    RestTemplate restTemplate=new RestTemplate();

    public HttpHeaders getHttpHeader(){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    public void restService() throws JsonProcessingException {
        String url= restUrl+"/users/1";
        System.out.println("URL : "+ url);
        HttpEntity<String> requestEntity= new HttpEntity<>(getHttpHeader());
        //ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        User result= (restTemplate.exchange(url, HttpMethod.GET,requestEntity, User.class).getBody());
        //result.getBody().
       // String output = restTemplate.getForObject(url, String.class);
       /* ObjectMapper objectMapper=new ObjectMapper();
        JsonNode userNode = objectMapper.readValue(result, JsonNode.class);
        String city = userNode.get("address").get("city").asText();
        System.out.println("City : "+ city);
        String zipcode=userNode.get("address").get("zipcode").asText();
        System.out.println("Zipcode : "+ zipcode);*/
        System.out.println(result);
    }
    public  void dummyComments() throws JSONException {

        //beginning with JsonObject
        String url= "https://dummyjson.com/comments";
        System.out.println("url -> "+ url);
        HttpEntity<String> requestEntity= new HttpEntity<>(getHttpHeader());
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String output=result.getBody().toString();
        System.out.println(output);

        JSONObject object=new JSONObject(output);
        System.out.println("total value from main object -> "+object.getString("total"));
        System.out.println("limit value from main object -> "+object.getString("limit"));
        JSONArray jsonArray= object.getJSONArray("comments");
        System.out.println("Json Array from Json Object : "+jsonArray);
        System.out.println("Json Array length : "+jsonArray.length());
        System.out.println("Json Array[0] : "+jsonArray.getJSONObject(0));
        System.out.println("Json Array[0] -> json object -> object.body : "+ jsonArray.getJSONObject(0).getString("body"));
        System.out.println("Json Array[0] -> json object -> jsonObject(user) -> user.usernamme : "+
                jsonArray.getJSONObject(0).getJSONObject("user").getString("username"));

        //beginning with JsonArray
        String url1= "https://jsonplaceholder.typicode.com/users";
        System.out.println("url -> "+ url1);
        ResponseEntity<String> result1 = restTemplate.exchange(url1, HttpMethod.GET, requestEntity, String.class);
        String output1=result1.getBody().toString();
       // System.out.println("output of array json - > "+output1);

        JSONArray jsonArray1=new JSONArray(output1);
        System.out.println("JSonArray-> "+jsonArray1);
        System.out.println("JSonArray-> lenghth - > "+jsonArray1.length());
        System.out.println("json array-> jsonObject-> name : "+jsonArray1.getJSONObject(0).getString("name"));
        System.out.println("json array-> jsonObject-> email : "+jsonArray1.getJSONObject(0).getString("email"));
        System.out.println("json array-> jsonObject-> website : "+jsonArray1.getJSONObject(0).getString("website"));
        System.out.println("json array-> jsonObject-> jsonObject(address)-> city : "+
                jsonArray1.getJSONObject(0).getJSONObject("address").getString("city"));
        System.out.println("json array-> jsonObject-> jsonObject(address)-> jsonObject(geo)-> lat : "+
                jsonArray1.getJSONObject(0).getJSONObject("address").getJSONObject("geo").getString("lat"));
        System.out.println("json array-> jsonObject-> jsonObject(company)-> name : "+
                jsonArray1.getJSONObject(0).getJSONObject("company").getString("name"));


    }




}
