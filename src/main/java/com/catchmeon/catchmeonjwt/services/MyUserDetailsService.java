package com.catchmeon.catchmeonjwt.services;
import com.catchmeon.catchmeonjwt.models.UserCMO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Firestore db = FirestoreClient.getFirestore();

        // Create a reference to the users collection
        CollectionReference _users = db.collection("user");
        // Create a query against the collection.
        Query query = _users.whereEqualTo("username", userName);
        // retrieve  query results asynchronously using query.get()
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        DocumentSnapshot userDocument = null;
        try {
            userDocument = querySnapshot.get().getDocuments().get(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String usertId = userDocument.getId();

        DocumentReference docRef = db.collection("user").document(usertId);
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
        if (    document.exists()) {
            // convert document to POJO
            userCMO = document.toObject(UserCMO.class);
            System.out.println(userCMO);
        } else {
            System.out.println("User not found");
            return null;
        }
        String username=  userCMO.getUsername();
        String password=  userCMO.getPassword();



        return new User(username, password, new ArrayList<>());
    }


}
