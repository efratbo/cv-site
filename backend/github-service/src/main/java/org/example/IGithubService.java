package org.example;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface IGithubService {
    GHUser fetchMyself() throws IOException;

    List<GHRepository> fetchMyRepos() throws IOException;

    List<GHUser> fetchFollowing() throws IOException;

    List<GHRepository> searchRepos(String repoName, String language, String username, int pageNumber, int pageSize) throws IOException;

    Date getLastUpdated() throws IOException;
}
