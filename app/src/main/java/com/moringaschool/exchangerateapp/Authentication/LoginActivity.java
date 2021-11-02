package com.moringaschool.exchangerateapp.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.exchangerateapp.MainActivity;
import com.moringaschool.exchangerateapp.R;
import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    ImageView facebook, twitter, google;
    TextView register;
    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    facebook = findViewById(R.id.facebook);
    twitter = findViewById(R.id.twitter);
    google = findViewById(R.id.google);
    register = findViewById(R.id.moveToRegister);

    email = findViewById(R.id.email);
    password =findViewById(R.id.password);
    login = findViewById(R.id.login);


        mAuth = FirebaseAuth.getInstance();



        //logging in logic
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"Sign up to continue",Toast.LENGTH_SHORT).show();
                }
            }
        };


    //login icons
        Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2v0cgwh1SL9ATrJVVGWlejPaTQsbxhwLM2Q&usqp=CAU")
                .resize(50, 50)
                .centerCrop()
                .into(facebook);
        Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2v0cgwh1SL9ATrJVVGWlejPaTQsbxhwLM2Q&usqp=CAU")
                .resize(50, 50)
                .centerCrop()
                .into(twitter);
        Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2v0cgwh1SL9ATrJVVGWlejPaTQsbxhwLM2Q&usqp=CAU")
                .resize(50, 50)
                .centerCrop()
                .into(google);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.


    }


}