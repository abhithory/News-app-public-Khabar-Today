package com.sanapps.publickhabartoday;

import java.util.List;

public class Posts {
    private String id;
    private String published;
    private String url;
    private String title;
    private String content;
    private List<String> labels;

    public void setId(String id) {
        this.id = id;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getId() {
        return id;
    }

    public String getPublished() {
        return published;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getLabels() {
        return labels;
    }
}
