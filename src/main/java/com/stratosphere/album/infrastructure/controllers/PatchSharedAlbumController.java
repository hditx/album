package com.stratosphere.album.infrastructure.controllers;

import com.stratosphere.album.application.ModifySharedAlbum;
import com.stratosphere.album.application.ModifySharedAlbumCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/shared-album")
@Tag(name = "Shared Album")
public class PatchSharedAlbumController {
    @Autowired
    private ModifySharedAlbum modifySharedAlbum;

    @Operation(summary = "Update shared album", description = "update permission", tags = {"Shared Album"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateSharedAlbum(@PathVariable("id") String id,
                                               @RequestBody ModifySharedAlbumCommand modifySharedAlbumCommand) {
        modifySharedAlbum.invoke(id, modifySharedAlbumCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
