package com.stratosphere.album.application;

import com.stratosphere.album.domain.SharedAlbum;
import com.stratosphere.album.infrastructure.MysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FindUserSharedAlbum {
    private static final String URL = "";
    @Autowired
    private MysqlRepository mysqlRepository;
    @Autowired
    private RestTemplate restTemplate;

    public List<Object> invoke(String permission, Long albumId) {
        List<Long> usersList = getUsersId(permission, albumId);
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForEntity(URL, Object[].class).getBody()));
    }

    private List<Long> getUsersId(String permission, Long albumId) {
        return mysqlRepository
                .findByPermissionAndAlbumId(permission, albumId)
                .stream()
                .map(SharedAlbum::getAlbumId)
                .collect(Collectors.toList());
    }
}
