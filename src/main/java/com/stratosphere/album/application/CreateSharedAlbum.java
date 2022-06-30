package com.stratosphere.album.application;

import com.stratosphere.album.domain.SharedAlbum;
import com.stratosphere.album.infrastructure.MysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateSharedAlbum {
    @Autowired
    private MysqlRepository mysqlRepository;

    public void invoke(SharedAlbumCommand cmd) {
        SharedAlbum sharedAlbum = getSharedAlbum(cmd);
        mysqlRepository.save(sharedAlbum);
    }

    private SharedAlbum getSharedAlbum(SharedAlbumCommand cmd) {
        return new SharedAlbum(
            UUID.randomUUID().toString(),
            cmd.getPermission(),
            cmd.getAlbumId(),
            cmd.getUserId()
        );
    }
}
