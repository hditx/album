package com.stratosphere.album.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shared_album")
public class SharedAlbum {
    @Id
    private String id;
    private String permission;
    private Long albumId;
    private Long userId;

    public SharedAlbum() {}

    public SharedAlbum(String id, String permission, Long albumId, Long userId) {
        this.id = id;
        this.permission = permission;
        this.albumId = albumId;
        this.userId = userId;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "permission")
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Column(name = "album_id")
    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
