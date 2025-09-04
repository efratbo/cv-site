package org.example.webapi.controller;


import org.example.webapi.DTOs.RepositoryDto;
import org.example.webapi.DTOs.UserDto;
import org.example.webapi.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cv-site/portfolio")
public class PortfolioController {
    @Autowired
    private GithubService githubService;

    //get my repos
    @GetMapping("/my-repos")
    public ResponseEntity<List<RepositoryDto>> getMyRepos() {
        githubService.evictCacheIfUpdated();
        return ResponseEntity.ok(githubService.getMyRepos().stream().toList());
    }

    @GetMapping("/myself")
    public ResponseEntity<UserDto> getMyself() {
        return ResponseEntity.ok(githubService.getMyself());
    }

    @GetMapping("/following")
    public ResponseEntity<List<UserDto>> getUsersIFollow() {
        return ResponseEntity.ok(githubService.getUsersIFollow());
    }
}
