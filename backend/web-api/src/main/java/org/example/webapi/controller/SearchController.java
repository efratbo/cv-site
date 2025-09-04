package org.example.webapi.controller;

import org.example.webapi.DTOs.RepositoryDto;
import org.example.webapi.GithubService;
import org.example.webapi.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cv-site/search")
public class SearchController {
    @Autowired
    private GithubService githubService;

    @PostMapping("/repositories")
    public ResponseEntity<List<RepositoryDto>> searchRepositories(@RequestBody SearchCriteria searchCriteria) {
        List<RepositoryDto> repositories = githubService.searchRepos(
                searchCriteria.getRepoName(),
                searchCriteria.getLanguage(),
                searchCriteria.getUsername(),
                searchCriteria.getPageNumber(),
                searchCriteria.getPageSize()
        );
        return ResponseEntity.ok(repositories);
    }

}
