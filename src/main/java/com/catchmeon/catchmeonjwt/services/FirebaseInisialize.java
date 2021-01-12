package com.catchmeon.catchmeonjwt.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;


@Service
public class FirebaseInisialize {

    @PostConstruct
    public void initialize(){

        try {
            FileInputStream serviceAccount = new FileInputStream("./catchmeon-4e321-firebase-adminsdk-13mhg-077f355881.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://catchmeon-4e321-default-rtdb.europe-west1.firebasedatabase.app")
                    .build();


        FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
