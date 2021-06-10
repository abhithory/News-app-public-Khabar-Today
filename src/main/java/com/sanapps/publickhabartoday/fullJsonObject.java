package com.sanapps.publickhabartoday;

import java.util.List;

public class fullJsonObject {

    private String nextPageToken;
    private List<Posts> items = null;

    public void setItems(List<Posts> items) {
        this.items = items;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public List<Posts> getItems() {
        return items;
    }
}
