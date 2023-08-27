package com.atipera.taskatipera.services;

import com.atipera.taskatipera.models.GitHubRepository;

import java.util.List;

public interface UserService {
    List<GitHubRepository> extractAllRepositoriesByUsername(String username);
}
