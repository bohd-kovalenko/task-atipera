package com.atipera.taskatipera.controllers;

import com.atipera.taskatipera.models.GitHubRepository;
import com.atipera.taskatipera.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/github/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}/repositories")
    public ResponseEntity<List<GitHubRepository>> extractAllUsersRepositories(@PathVariable("username") String username) {
        log.info("GET method on /github/users/{username}/repositories");
        List<GitHubRepository> responseBody = userService.extractAllRepositoriesByUsername(username);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
