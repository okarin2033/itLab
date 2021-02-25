package ru.mirea.shop.api;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

public class ApiWork {
    final static String host = "http://localhost:8080/";
    static final RestTemplate restTemplate = new RestTemplate();

    public static String getMethod(String path){
        return restTemplate.getForObject((host+path),String.class);
    }

    public static String postMethod(String path, Object obj){
        String answer=restTemplate.postForObject((host+path), obj, String.class);
        return answer;
    }
    public static String putMethod(String path, Object obj) {
        String answer=restTemplate.exchange((host+path), HttpMethod.PUT, String.class, obj);
        return answer;
    }


}
