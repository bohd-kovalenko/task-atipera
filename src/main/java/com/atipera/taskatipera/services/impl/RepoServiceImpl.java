package com.atipera.taskatipera.services.impl;

import com.atipera.taskatipera.clients.GitHubRepoClient;
import com.atipera.taskatipera.mappers.BranchesMapper;
import com.atipera.taskatipera.models.GitHubRepositoryBranch;
import com.atipera.taskatipera.payload.responses.BranchResponse;
import com.atipera.taskatipera.services.RepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RepoServiceImpl implements RepoService {
    private final GitHubRepoClient client;

    @Override
    public List<GitHubRepositoryBranch> extractAllRepoBranchesByNameAndUsername(String repoName, String username) {
        List<BranchResponse> branchesResponse = client
                .extractBranchesInfoByRepositoryNameAndUsername(repoName, username);
        log.info(String.format("Performed branches extraction for %s repo", repoName));
        return branchesResponse
                .stream()
                .map(BranchesMapper.INSTANCE::ranchResponseToGitHubRepositoryBranch)
                .toList();
    }
}
