package com.stratosphere.album.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FindUserAlbum {
    private static final String URL = "https://jsonplaceholder.typicode.com/users/";
    @Autowired
    private RestTemplate restTemplate;

    public List<Object> invoke(Long id) {
        final var result = restTemplate.getForEntity(URL + id + "/albums", Object[].class);
        return Arrays.asList(result.getBody());
    }
}
