package com.stratosphere.album.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindUserPhotos {
    private static final String URL_ALBUM = "https://jsonplaceholder.typicode.com/albums?userId=";
    private static final String URL_PHOTOS = "https://jsonplaceholder.typicode.com/photos?albumId=";
    @Autowired
    private RestTemplate restTemplate;

    public List<Object> invoke(Long id) throws NoSuchFieldException {
        List<Object> usersPhotos = new ArrayList<>();
        final var result = restTemplate.getForEntity(URL_ALBUM + id, Object[].class);
        final var listAlbum = getAlbumIdList(result.getBody());
        listAlbum.forEach(it -> {
            Object[] user = restTemplate
                    .getForEntity(URL_PHOTOS + it, Object[].class)
                    .getBody();
            assert user != null;
            usersPhotos.addAll(Arrays.asList(user));
        });
        return usersPhotos;
    }

    private List<Long> getAlbumIdList(Object[] albumId) throws NoSuchFieldException {
        return Arrays.stream(albumId).map(it -> Long.parseLong(((LinkedHashMap) it).get("id").toString()))
                .collect(Collectors.toList());
    }
}
