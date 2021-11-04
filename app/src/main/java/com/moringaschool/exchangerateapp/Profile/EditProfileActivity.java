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

public class EditProfileActivity extends AppCompatActivity {

    ImageView image;
    EditText email, phone, bio, username;
    Button editProfile;


    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        image = findViewById(R.id.profilepic);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        bio = findViewById(R.id.bio);
        username = findViewById(R.id.username);

        editProfile = findViewById(R.id.updateProfileBtn);


        mDatabaseReference = mDatabase.getReference().child("name");
        mDatabaseReference.setValue("Donald Duck");


        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                addData();
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addData() {





         //Get all values

        String Name = username.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Phone = phone.getText().toString().trim();
        String Bio = bio.getText().toString().trim();
//        Image Image = (image.getImageAlpha());

         Profilepojo profilepojo = new Profilepojo(Email, Phone, Bio, Name);


//        root.setValue("Testing");
//         root.setValue(profilepojo);
//        root saveData= new root(Name, Email,Phone, Bio);
//
//        root.setValue(saveData);
        Toast.makeText(EditProfileActivity.this,"Successfull",Toast.LENGTH_SHORT).show();


    }
}