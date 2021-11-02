package com.moringaschool.exchangerateapp.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.exchangerateapp.R;
import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity {
    ImageView facebook, twitter, google;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    facebook = findViewById(R.id.facebook);
    twitter = findViewById(R.id.twitter);
    google = findViewById(R.id.google);
    register = findViewById(R.id.moveToRegister);

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


}