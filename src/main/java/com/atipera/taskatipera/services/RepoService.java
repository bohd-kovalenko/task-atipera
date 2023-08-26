package com.atipera.taskatipera.services;

import com.atipera.taskatipera.models.GitHubRepositoryBranch;

import java.util.List;

public interface RepoService {
    List<GitHubRepositoryBranch> extractAllRepoBranchesByNameAndUsername(String repoName, String username);
}
