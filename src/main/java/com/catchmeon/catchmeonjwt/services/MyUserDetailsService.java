package com.catchmeon.catchmeonjwt.services;
import com.catchmeon.catchmeonjwt.models.UserCMO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
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
        DocumentReference docRef = db.collection("user").document(userName);
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
        UserCMO usercmo = null;
        if (document.exists()) {
            // convert document to POJO
            usercmo = document.toObject(UserCMO.class);
            System.out.println(usercmo);

        } else {
            System.out.println("No such document!");
            return null;
        }
        String username=  usercmo.getUsername();
        String password=  usercmo.getPassword();



        return new User(username, password, new ArrayList<>());
    }


}
