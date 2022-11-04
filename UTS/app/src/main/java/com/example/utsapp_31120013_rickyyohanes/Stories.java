package com.example.utsapp_31120013_rickyyohanes;

public class Stories {
    private String storyTitle;
    private String storySlug;
    private String storyDescription;
    private String storyMoral;
    private int storyImages;

    public Stories(String storyTitle, String storySlug, String storyDescription, String storyMoral, int storyImages) {
        this.storyTitle = storyTitle;
        this.storySlug = storySlug;
        this.storyDescription = storyDescription;
        this.storyMoral = storyMoral;
        this.storyImages = storyImages;
    }

    public String getStoryDescription() {
        return storyDescription;
    }

    public String getStoryMoral() {
        return storyMoral;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public String getStorySlug() {
        return storySlug;
    }

    public int getStoryImages() {
        return storyImages;
    }

}
