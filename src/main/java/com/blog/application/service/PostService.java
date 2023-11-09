package com.blog.application.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    public String api(){
        String apiUrl = "https://api.adviceslip.com/advice";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);
        return response.substring(36).replace("}", "").replace("\"", "");
    }
}
