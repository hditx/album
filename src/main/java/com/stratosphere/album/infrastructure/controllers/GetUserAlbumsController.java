package com.stratosphere.album.infrastructure.controllers;

import com.stratosphere.album.application.FindUserAlbum;
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
@RequestMapping("/v1/users/album")
@Tag(name = "Users")
public class GetUserAlbumsController {
    @Autowired
    private FindUserAlbum findUserAlbum;

    @Operation(summary = "List User album", description = "Consume API externa", tags = {"Users"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "503", description = "Bad gateway")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> listUserAlbum(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findUserAlbum.invoke(id));
    }
}
