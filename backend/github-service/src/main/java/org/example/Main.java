package org.example;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        try {
            GithubAuthApi githubApi = new GithubAuthApi();
            GHUser myself = githubApi.fetchMyself();
            System.out.println("Myself: " + myself);

            List<GHRepository> myRepos = githubApi.fetchMyRepos();
            System.out.println("My Repositories: ");
            for (GHRepository repo : myRepos) {
//                System.out.println(repo);
                try{
                    String readme= repo.getReadme().getContent();
                    System.out.println("Readme: "+readme);
                }catch (Exception e){
                    System.out.println("No Readme found");
                }

            }
            List<GHUser> users = githubApi.fetchFollowing();
            System.out.println("\nFollowing Users: ");
            for (GHUser user : users) {
                System.out.println(user);
            }
            List<GHRepository> repositoriesByUsername = githubApi.searchRepos(null, "c++", null, 1, 10);
            System.out.println("\nPublic Repositories by serach: ");
            for (GHRepository repo : repositoriesByUsername) {
                System.out.println(repo);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}