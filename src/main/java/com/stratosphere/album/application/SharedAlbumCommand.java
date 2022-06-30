package com.stratosphere.album.application;

public class SharedAlbumCommand {
    private String permission;
    private Long albumId;
    private Long userId;

    public SharedAlbumCommand() {}

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
