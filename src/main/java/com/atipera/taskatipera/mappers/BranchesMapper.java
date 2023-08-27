package com.atipera.taskatipera.mappers;

import com.atipera.taskatipera.models.GitHubRepositoryBranch;
import com.atipera.taskatipera.payload.responses.BranchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BranchesMapper {
    BranchesMapper INSTANCE = Mappers.getMapper(BranchesMapper.class);

    default GitHubRepositoryBranch ranchResponseToGitHubRepositoryBranch(BranchResponse branchResponse) {
        return new GitHubRepositoryBranch(
                branchResponse.name(),
                branchResponse.lastCommit().sha()
        );
    }

}
