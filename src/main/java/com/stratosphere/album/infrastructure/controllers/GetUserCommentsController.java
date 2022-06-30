package com.stratosphere.album.infrastructure.controllers;

import com.stratosphere.album.application.FindUserComments;
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
@RequestMapping("/v1/comments/user")
@Tag(name = "Comments")
public class GetUserCommentsController {
    @Autowired
    private FindUserComments findUserComments;

    @Operation(summary = "List Comments for username", description = "Consume API externa", tags = {"Comments"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "503", description = "Bad gateway")
            }
    )
    @GetMapping("/{username}")
    public ResponseEntity<?> listCommentsUsers(@PathVariable("username") String user) {
        return ResponseEntity.status(HttpStatus.OK).body(findUserComments.invoke(user));
    }
}
