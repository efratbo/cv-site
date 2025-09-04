package org.example.webapi.DTOs;

import org.kohsuke.github.GHRepository;

import java.io.IOException;

public class RepositoryDto {
    private String nodeId;
    private String name;
    private String description;
    private String homepage;
    private boolean fork;
    private boolean archived;
    private String visibility;
    private int size;
    private String language;
    private boolean isTemplate;
    private String url;
    private long id;
    private String createdAt;
    private String updatedAt;
    private int stars;
    private String markdown;

    // Constructor
    public RepositoryDto(String nodeId, String name, String description, String homepage, boolean fork,
                         boolean archived, String visibility, int size, String language, boolean isTemplate,
                         String url, long id, String createdAt, String updatedAt, int stars, String markdown) {
        this.nodeId = nodeId;
        this.name = name;
        this.description = description;
        this.homepage = homepage;
        this.fork = fork;
        this.archived = archived;
        this.visibility = visibility;
        this.size = size;
        this.language = language;
        this.isTemplate = isTemplate;
        this.url = url;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.stars = stars;
        this.markdown = markdown;
    }

    public static RepositoryDto mapToRepositoryDto(GHRepository repository) {
        String readmeContent = null;
        try {
            readmeContent = repository.getReadme().getContent();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("No Readme found");
        }
        try {
            return new RepositoryDto(
                    repository.getNodeId(),
                    repository.getName(),
                    repository.getDescription(),
                    repository.getHomepage(),
                    repository.isFork(),
                    repository.isArchived(),
                    repository.getVisibility().toString(),
                    repository.getSize(),
                    repository.getLanguage(),
                    repository.isTemplate(),
                    repository.getHtmlUrl().toString(),
                    repository.getId(),
                    repository.getCreatedAt().toString(),
                    repository.getUpdatedAt().toString(),
                    repository.getStargazersCount(),
                    readmeContent
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Getters and setters
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }
}
