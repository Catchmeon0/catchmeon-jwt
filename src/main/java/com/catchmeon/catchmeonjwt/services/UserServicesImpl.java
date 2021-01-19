package com.catchmeon.catchmeonjwt.services;


import com.catchmeon.catchmeonjwt.models.UserCMO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        DocumentReference docRef = db.collection("user").document(username);
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



        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection("user").document(userCMO.getUsername()).set(userCMO);

        DocumentReference docRef = db.collection("user").document(userCMO.getUsername());
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
