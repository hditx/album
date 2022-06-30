package com.stratosphere.album.infrastructure.controllers;

import com.stratosphere.album.application.ListAlbum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/albums")
@Tag(name = "Album")
public class GetAlbumsController {
    @Autowired
    private ListAlbum listAlbum;

    @Operation(summary = "List Album", description = "Consume API externa", tags = {"Album"})
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "503", description = "Bad gateway")
        }
    )
    @GetMapping
    public ResponseEntity<?> listAlbum() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listAlbum.invoke());
    }
}
