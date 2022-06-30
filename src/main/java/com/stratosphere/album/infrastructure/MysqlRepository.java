package com.stratosphere.album.infrastructure;

import com.stratosphere.album.domain.SharedAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MysqlRepository extends JpaRepository<SharedAlbum, String> {
    List<SharedAlbum> findByPermissionAndAlbumId(String permission, Long albumId);
    SharedAlbum findByIdAndAlbumId(String id, Long albumId);
}
