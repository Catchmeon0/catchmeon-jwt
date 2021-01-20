package com.catchmeon.catchmeonjwt.models.request;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;

public class TweetRequest {
    String id;

    public TweetRequest(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getJsonData() throws Exception {

        String url = "https://api.twitter.com/1.1/statuses/show.json?id=" + this.id;

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAABhkLwEAAAAATX2kSV9bdfUDzPOSx9SaqwR8l78%3DuyiHlz9DclvL2VRhKgMaW1n8xdpGeUXpoe5QHdff4ckPC0cdDT");

//this is response:
        HttpResponse response = client.execute(get);
        // System.out.println("Response: " + response.getStatusLine());
        String responseString = new BasicResponseHandler().handleResponse(response);
        // System.out.println("Body: " + responseString);
        return responseString;
    }

}
