package com.stratosphere.album.infrastructure.controllers;

import com.stratosphere.album.application.ListUser;
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
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/users")
@Tag(name = "Users")
public class GetUserController {
    @Autowired
    private ListUser listUser;

    @Operation(summary = "List Users", description = "Consume API externa", tags = {"Users"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "503", description = "Bad gateway")
            }
    )
    @GetMapping
    public ResponseEntity<?> listUser() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listUser.invoke());
    }
}
