package com.atipera.taskatipera.clients;

import com.atipera.taskatipera.payload.responses.BranchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "github-repo-client", url = "https://api.github.com/repos")
public interface GitHubRepoClient {
    @GetMapping(value = "/{username}/{repositoryName}/branches", produces = "application/json")
    List<BranchResponse> extractBranchesInfoByRepositoryNameAndUsername(@PathVariable("repositoryName") String repositoryName,
                                                                        @PathVariable("username") String username);
}
