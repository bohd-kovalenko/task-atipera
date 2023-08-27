package com.atipera.taskatipera.controllers;

import com.atipera.taskatipera.models.GitHubRepository;
import com.atipera.taskatipera.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;


    @Test
    public void testExtractAllUsersRepositoriesWhenUsernameIsGivenThenReturnCorrectRepositories() {
        List<GitHubRepository> expectedRepositories = Arrays.asList(
                new GitHubRepository("repo1", "user1", null),
                new GitHubRepository("repo2", "user1", null)
        );
        when(userService.extractAllRepositoriesByUsername(anyString())).thenReturn(expectedRepositories);

        ResponseEntity<List<GitHubRepository>> response = userController.extractAllUsersRepositories("user1");

        assertEquals(expectedRepositories, response.getBody());
    }

    @Test
    public void testExtractAllUsersRepositoriesWhenCalledThenUserServiceIsInvokedWithCorrectUsername() {
        String expectedUsername = "user1";
        when(userService.extractAllRepositoriesByUsername(anyString())).thenReturn(null);

        userController.extractAllUsersRepositories(expectedUsername);

        verify(userService, times(1)).extractAllRepositoriesByUsername(expectedUsername);
    }

    @Test
    public void testExtractAllUsersRepositoriesWhenCalledThenReturnHttpStatusOk() {
        when(userService.extractAllRepositoriesByUsername(anyString())).thenReturn(null);

        ResponseEntity<List<GitHubRepository>> response = userController.extractAllUsersRepositories("user1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}