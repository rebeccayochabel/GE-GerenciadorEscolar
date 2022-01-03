package br.com.gerenciadorescolar.ge.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


@Service
public class Firebase{

    @PostConstruct
    private void iniFirestore() throws IOException {

        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("ge-firebase.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://gerenescolar-default-rtdb.firebaseio.com")
        .build();

        FirebaseApp.initializeApp(options);
    }

    public Firestore getFirestore(){
        return FirestoreClient.getFirestore();
    }
}
