package com.stratosphere.album.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FindUserCommentsName {
    private static final String URL_USER = "https://jsonplaceholder.typicode.com/users?name=";
    private static final String URL_POST = "https://jsonplaceholder.typicode.com/posts?userId=";
    private static final String URL_COMMENT = "https://jsonplaceholder.typicode.com/comments?postId=";
    @Autowired
    private RestTemplate restTemplate;

    public List<Object> invoke(String name) {
        Long userId = getUserId(name);
        List<Long> postIdList = getPostIdList(userId);
        return getComments(postIdList);
    }

    private Long getUserId(String name) {
        var user = restTemplate
                .getForEntity(URL_USER + name, Object.class)
                .getBody();
        assert user != null;
        return Long.parseLong(((LinkedHashMap) ((ArrayList) user).get(0)).get("id").toString());
    }

    private List<Long> getPostIdList(Long userId) {
        return Arrays
                .stream(Objects.requireNonNull(restTemplate
                        .getForEntity(URL_POST + userId, Object[].class)
                        .getBody()))
                .map(it -> Long.parseLong(((LinkedHashMap<?, ?>) it).get("id").toString()))
                .collect(Collectors.toList());
    }

    private List<Object> getComments(List<Long> postIdList) {
        List<Object> userComment = new ArrayList<>();
        postIdList.forEach(it -> {
            Object[] comment = restTemplate
                    .getForEntity(URL_COMMENT + it, Object[].class)
                    .getBody();
            assert comment != null;
            userComment.addAll(Arrays.asList(comment));
        });
        return userComment;
    }
}
