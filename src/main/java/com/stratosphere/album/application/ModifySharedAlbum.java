package com.stratosphere.album.application;

import com.stratosphere.album.domain.SharedAlbum;
import com.stratosphere.album.infrastructure.MysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifySharedAlbum {
    @Autowired
    private MysqlRepository mysqlRepository;

    public void invoke(String id, ModifySharedAlbumCommand cmd) {
        SharedAlbum sharedAlbum = updateSharedAlbum(id, cmd);
        mysqlRepository.save(sharedAlbum);
    }

    private SharedAlbum updateSharedAlbum(String id, ModifySharedAlbumCommand cmd) {
        SharedAlbum sharedAlbum = mysqlRepository.findByIdAndAlbumId(id, cmd.getAlbumId());
        sharedAlbum.setPermission(cmd.getPermission());
        return sharedAlbum;
    }
}
