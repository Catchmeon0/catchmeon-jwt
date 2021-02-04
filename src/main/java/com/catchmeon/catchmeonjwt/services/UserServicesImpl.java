package com.catchmeon.catchmeonjwt.services;


import com.catchmeon.catchmeonjwt.models.UserCMO;
import com.catchmeon.catchmeonjwt.models.user_model;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
class UserServiceImpl implements UserDetailsService, UserService{


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     return null;
    }


    @Override
    public Iterable<UserCMO> getAllUsers() {
        return null;
    }

    @Override
    public UserCMO getUser(String username) {

        Firestore db = FirestoreClient.getFirestore();

        // Create a reference to the users collection
        CollectionReference _users = db.collection("user");
        // Create a query against the collection.
        Query query = _users.whereEqualTo("username", username);
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
            userCMO.setId(usertId);
            System.out.println(userCMO);
            return userCMO;
        } else {
            System.out.println("User not found");
            return null;
        }
    }

    @Override
    public UserCMO getUserbyId(String name) {
        return null;
    }

    @Override
    public UserCMO  createUser(UserCMO userCMO) throws ExecutionException, InterruptedException {
        HashMap<String, String> _userIds =userCMO.getUserIds();
        _userIds.put("twitter","");
        _userIds.put("youtube","");
        userCMO.setUserIds(_userIds);
        Firestore db = FirestoreClient.getFirestore();
        FirebaseAuth mAuth;

        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(userCMO.getEmail())
                .setEmailVerified(false)
                .setPassword(userCMO.getPassword())
                .setDisabled(false);

        UserRecord userRecord = null;
        mAuth = FirebaseAuth.getInstance();
        try {
            userRecord= mAuth.createUser(request);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }


        CollectionReference _user = db.collection("user");
        List<ApiFuture<WriteResult>> future = new ArrayList<>();
        future.add(_user.document(userRecord.getUid()).set(userCMO));

        String usertId = userRecord.getUid();
        CollectionReference users = db.collection("users");
        List<ApiFuture<WriteResult>> future2 = new ArrayList<>();
        future2.add(
                users
                        .document(usertId)
                .set(
                        new user_model(userCMO.getUsername(), userCMO.getPassword(), userCMO.getEmail(), userCMO.getUsername(), usertId) )
                );
        DocumentReference docRef = db.collection("user").document(usertId);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> fe = docRef.get();
        // block on response
        DocumentSnapshot document = null;
        try {
            document = fe.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        UserCMO user = null;
        if (    document.exists()) {
            // convert document to POJO
            user = document.toObject(UserCMO.class);
            System.out.println(userCMO);
            return user;
        } else {
            System.out.println("User not found");
            return null;
        }


    }

    @Override
    public UserCMO updateUser(UserCMO userCMO) {
        return null;
    }




    @Override
    public void deleteUser(String name) {

    }


}
