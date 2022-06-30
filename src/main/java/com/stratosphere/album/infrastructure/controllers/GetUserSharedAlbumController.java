package com.stratosphere.album.infrastructure.controllers;

import com.stratosphere.album.application.FindUserSharedAlbum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/shared-album")
@Tag(name = "Shared Album")
public class GetUserSharedAlbumController {

    @Autowired
    private FindUserSharedAlbum findUserSharedAlbum;

    @Operation(summary = "List shared album", description = "List users", tags = {"Shared Album"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/{permission}/{albumId}")
    public ResponseEntity<?> getUserList(@PathVariable("permission") String permission,
                                         @PathVariable("albumId") Long albumId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findUserSharedAlbum.invoke(permission, albumId));
    }
}
