package com.atipera.taskatipera.services.impl;

import com.atipera.taskatipera.clients.GitHubUserClient;
import com.atipera.taskatipera.models.GitHubRepository;
import com.atipera.taskatipera.payload.responses.RepositoryResponse;
import com.atipera.taskatipera.services.RepoService;
import com.atipera.taskatipera.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final GitHubUserClient client;
    private final RepoService repoService;

    @Override
    public List<GitHubRepository> extractAllRepositoriesByUsername(String username) {
        List<RepositoryResponse> responseBody = client.extractAllUsersRepositoriesByUsername(username);
        return responseBody
                .stream()
                .filter(repository -> !repository.isFork())
                .map(repository -> new GitHubRepository(
                        repository.name(),
                        repository.repositoryOwner().login(),
                        repoService.extractAllRepoBranchesByNameAndUsername(repository.name(), username)
                ))
                .toList();
    }
}
