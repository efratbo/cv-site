package org.example;

import org.kohsuke.github.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class GithubAuthApi implements IGithubService {
    private final GitHub github;

    // Constructor to authenticate with the token
    public GithubAuthApi() throws IOException {
        String token = getToken();
        this.github = new GitHubBuilder().withOAuthToken(token).build();
    }

    private String getToken() {
        String token;
        token = System.getenv("GITHUB_TOKEN");
        if (Objects.equals(token, "") || token == null) {
            try (
                    InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
                Properties prop = new Properties();
                if (input == null) {
                    System.out.println("Sorry, unable to find config.properties");
                }
                prop.load(input);
                token = prop.getProperty("GITHUB_TOKEN");
                System.out.println("GitHub Token: " + token);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return token;
    }

    @Override
    public GHUser fetchMyself() throws IOException {
        return github.getMyself();
    }

    // Fetch all repositories for a user (your own repos)
    @Override
    public List<GHRepository> fetchMyRepos() throws IOException {
        return github.getMyself().listRepositories().toList();
    }

    // Fetch the people the user follows
    // Fetch the people the user follows and return them as a list
    @Override
    public List<GHUser> fetchFollowing() throws IOException {
        List<GHUser> followers = new ArrayList<>();
        for (GHUser user : github.getMyself().listFollows()) {
            followers.add(user);
        }
        return followers;
    }

    @Override
    public List<GHRepository> searchRepos(String repoName, String language, String username, int pageNumber, int pageSize) throws IOException {
        GHRepositorySearchBuilder searchBuilder = github.searchRepositories();

        // Apply filters from parameters
        if (repoName != null) {
            searchBuilder.q(repoName);
        }
        if (language != null) {
            searchBuilder.language(language);
        }
        if (username != null) {
            searchBuilder.user(username);
        }

        // Get a paginated list (PagedIterable) of repositories
        PagedIterable<GHRepository> pagedResults = searchBuilder.list().withPageSize(pageSize);

        // Convert paginated results to a list for the requested page
        List<GHRepository> results = new ArrayList<>();
        int start = (pageNumber - 1) * pageSize;
        int end = start + pageSize;

        int index = 0;
        for (GHRepository repo : pagedResults) {
            // Add only the repositories within the requested pageNumber
            if (index >= start && index < end) {
                results.add(repo);
            }
            if (index >= end) break;
            index++;
        }

        return results;
    }

    @Override
    public Date getLastUpdated() throws IOException {
        return fetchMyself().getUpdatedAt();
    }
}
