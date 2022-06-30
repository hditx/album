package com.stratosphere.album.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ListPhotos {
    private static final String URL = "https://jsonplaceholder.typicode.com/photos";
    @Autowired
    private RestTemplate restTemplate;

    public List<Object> invoke() {
        final var result = restTemplate.getForEntity(URL, Object[].class);
        return Arrays.asList(result.getBody());
    }
}
