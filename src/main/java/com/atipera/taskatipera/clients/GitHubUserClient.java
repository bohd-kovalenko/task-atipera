package com.atipera.taskatipera.clients;

import com.atipera.taskatipera.payload.responses.RepositoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "github-user-client", url = "https://api.github.com/users")
public interface GitHubUserClient {
    @GetMapping(value = "/{username}/repos", produces = "application/json")
    List<RepositoryResponse> extractAllUsersRepositoriesByUsername(@PathVariable("username") String username);
}
