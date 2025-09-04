package org.example.webapi.DTOs;

import org.kohsuke.github.GHUser;

import java.io.IOException;

public class UserDto {
    private String login;
    private String name;
    private String location;
    private String blog;
    private String email;
    private String bio;
    private String company;
    private String type;
    private int followers;
    private int following;
    private boolean hireable;
    private String url;
    private long id;
    private String nodeId;
    private String createdAt;
    private String updatedAt;

    // Constructor
    public UserDto(String login, String name, String location, String blog, String email, String bio,
                   String company, String type, int followers, int following, boolean hireable, String url,
                   long id, String nodeId, String createdAt, String updatedAt) {
        this.login = login;
        this.name = name;
        this.location = location;
        this.blog = blog;
        this.email = email;
        this.bio = bio;
        this.company = company;
        this.type = type;
        this.followers = followers;
        this.following = following;
        this.hireable = hireable;
        this.url = url;
        this.id = id;
        this.nodeId = nodeId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public static UserDto mapToUserDto(GHUser user) {
        try {
            return new UserDto(
                    user.getLogin(),
                    user.getName(),
                    user.getLocation(),
                    user.getBlog(),
                    user.getEmail(),
                    user.getBio(),
                    user.getCompany(),
                    user.getType(),
                    user.getFollowersCount(),
                    user.getFollowingCount(),
                    user.isHireable(),
                    user.getHtmlUrl().toString(),
                    user.getId(),
                    user.getNodeId(),
                    user.getCreatedAt().toString(),
                    user.getUpdatedAt().toString()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Getters and setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public boolean isHireable() {
        return hireable;
    }

    public void setHireable(boolean hireable) {
        this.hireable = hireable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
