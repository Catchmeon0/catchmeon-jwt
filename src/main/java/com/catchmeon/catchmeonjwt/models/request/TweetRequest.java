package com.catchmeon.catchmeonjwt.models.request;


import com.catchmeon.catchmeonjwt.models.UserCMO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.catchmeon.catchmeonjwt.util.key.authKey;

public class TweetRequest {
    public List<String> ListFollowedUserfromUserID;
    String id;

    public List<String> getListFollowedUserfromUserID(String userID) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("user").document(this.id);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = null;
        try {
            document = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        UserCMO userCMO = null;
        if (document.exists()) {
            // convert document to POJO
            userCMO = document.toObject(UserCMO.class);
            System.out.println(userCMO);
            ListFollowedUserfromUserID = userCMO.getUserFollowed();

        } else {
            System.out.println("User not found");
            return null;
        }
        return ListFollowedUserfromUserID;
    }

    public TweetRequest(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getJsonData(String statusID) throws Exception {

        String url = "https://api.twitter.com/1.1/statuses/show.json?id=" + statusID;

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        get.setHeader("Content-Type", "application/json");

        get.setHeader("Authorization", authKey);

//this is response:
        HttpResponse response = client.execute(get);
        // System.out.println("Response: " + response.getStatusLine());
        String responseString = new BasicResponseHandler().handleResponse(response);
        // System.out.println("Body: " + responseString);
        return responseString;
    }

    public String getTwitterIDFromUser(String userID) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("user").document(userID);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = null;
        try {
            document = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        UserCMO userCMO = null;
        if (document.exists()) {
            // convert document to POJO
            userCMO = document.toObject(UserCMO.class);
            System.out.println(userCMO);
            return (String) userCMO.getUserIds().get("twitter");

        } else {
            System.out.println("User not found");
            return null;
        }
    }

    public List<String> getListTwitterFollowedUserfromUserID(String userID) {
        List<String> listUserFollowed = getListFollowedUserfromUserID(userID);
        List<String> listTwitterFollowedUser = new ArrayList<String>();
        listUserFollowed.forEach(id -> listTwitterFollowedUser.add(getTwitterIDFromUser(id)));
        System.out.println(listTwitterFollowedUser);
        return listTwitterFollowedUser;
    }

    public String getTwitterStatusFromUserScreenName(String userTwitterScreenName) throws IOException, JSONException {
        String url = "https://api.twitter.com/1.1/users/show.json?screen_name=" + userTwitterScreenName;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Authorization", authKey);

//this is response:
        HttpResponse response = client.execute(get);
        String responseString = new BasicResponseHandler().handleResponse(response);

        JSONObject objJsonObject = new JSONObject(responseString);
        JSONObject objJsonObject2 = new JSONObject(objJsonObject.getString("status"));
        return objJsonObject2.getString("id_str");
    }

    public String listStatusJsonResponse() {
        String response = "{";
        List<String> listJsonData = new ArrayList<String>();
        List<String> listStatusOfFollowedUser = new ArrayList<String>();
        getListTwitterFollowedUserfromUserID(this.id).forEach(userTwitterScreenName -> {
            try {
                listStatusOfFollowedUser.add(getTwitterStatusFromUserScreenName(userTwitterScreenName));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });


        listStatusOfFollowedUser.forEach(statusID -> {
            try {
                listJsonData.add(getJsonData(statusID));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        int statusIndex=0;

        for (String data : listJsonData) {
            String status = "";
            String idx=Integer.toString(statusIndex);
            status += idx;
            response += "\""+ status + "\"  : ";
            response += data;
            response += ",";
            statusIndex ++;
        }

        String status = "";
        String idx=Integer.toString(statusIndex);
        status += idx;
        response += "\""+ status + "\"  : ";
        response += "{}";
        response += "";
        response +="}";

        return response;
    }
}
