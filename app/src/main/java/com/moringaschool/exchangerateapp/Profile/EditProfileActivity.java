package com.moringaschool.exchangerateapp.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.exchangerateapp.MainActivity;
import com.moringaschool.exchangerateapp.R;

import java.util.HashMap;

public class EditProfileActivity extends AppCompatActivity {

    ImageView image;
    EditText email, phone, bio, username;
    Button editProfile;


    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

         mDatabase= FirebaseDatabase.getInstance();
         mDatabaseReference = mDatabase.getReference();

        image = findViewById(R.id.profilepic);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        bio = findViewById(R.id.bio);
        username = findViewById(R.id.username);

        editProfile = findViewById(R.id.updateProfileBtn);



//
//        Profilepojo profilepojo = new Profilepojo(Email, Phone, Bio, Name);
//        mDatabaseReference = mDatabase.getReference().child("name");


        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = username.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Phone = phone.getText().toString().trim();
        String Bio = bio.getText().toString().trim();
//        Image Image = (image.getImageAlpha());

                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name",Name);
                hashMap.put("email",Email);
                hashMap.put("phone",Phone);
                hashMap.put("bio",Bio);



                Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

}