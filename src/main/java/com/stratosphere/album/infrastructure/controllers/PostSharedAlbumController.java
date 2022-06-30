package com.stratosphere.album.infrastructure.controllers;

import com.stratosphere.album.application.CreateSharedAlbum;
import com.stratosphere.album.application.SharedAlbumCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/shared-album")
@Tag(name = "Shared Album")
public class PostSharedAlbumController {

    @Autowired
    private CreateSharedAlbum createSharedAlbum;

    @Operation(summary = "Create shared album", description = "Create new shared album", tags = {"Shared Album"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PostMapping
    public ResponseEntity<?> createSharedAlbum(@RequestBody SharedAlbumCommand cmd) {
        createSharedAlbum.invoke(cmd);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
