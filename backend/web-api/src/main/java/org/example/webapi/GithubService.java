package org.example.webapi;

import org.example.GithubAuthApi;
import org.example.IGithubService;
import org.example.webapi.DTOs.RepositoryDto;
import org.example.webapi.DTOs.UserDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubService {
    private final IGithubService githubAuthApi;
    private Instant lastChecked = Instant.now();

    public GithubService() {
        try {
            githubAuthApi = new GithubAuthApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Cacheable(value = "repositories", key = "'my-repos'")
    public List<RepositoryDto> getMyRepos() {
        try {
            System.out.println("Fetching my repositories from GitHub.");
            return githubAuthApi.fetchMyRepos().stream()
                    .map(RepositoryDto::mapToRepositoryDto) // Convert GHRepository to RepositoryDto
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean hasUpdates() {
        try {
            Instant lastUpdated = githubAuthApi.getLastUpdated().toInstant();
            if (lastUpdated.isAfter(lastChecked)) {
                System.out.println("last checked: " + lastChecked + " last updated: " + lastUpdated);
                return true;
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @CacheEvict(value = "repositories", key = "'my-repos'", condition = "#root.target.hasUpdates()")
    public void evictCacheIfUpdated() {
        lastChecked = Instant.now();
    }

    @Cacheable(value = "following", key = "'my-following'")
    public List<UserDto> getUsersIFollow() {
        try {
            System.out.println("Fetching users I follow from GitHub.");
            return githubAuthApi.fetchFollowing().stream().map(UserDto::mapToUserDto) // Convert GHRepository to RepositoryDto
                    .collect(Collectors.toList()); // Collect into a list
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDto getMyself() {
        try {
            return UserDto.mapToUserDto(githubAuthApi.fetchMyself());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<RepositoryDto> searchRepos(String repoName, String language, String username, int pageNumber, int pageSize) {
        try {
            return githubAuthApi.searchRepos(repoName, language, username, pageNumber, pageSize).stream().map(RepositoryDto::mapToRepositoryDto) // Convert GHRepository to RepositoryDto
                    .collect(Collectors.toList()); // Collect into a list
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
