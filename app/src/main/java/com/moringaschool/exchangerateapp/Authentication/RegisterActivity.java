package com.moringaschool.exchangerateapp.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.exchangerateapp.MainActivity;
import com.moringaschool.exchangerateapp.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {



    private EditText password, confirmPassword, email, username;
    private Button register;
    TextView login;

    ImageView facebook, twitter, google;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.moveToLogin);




        facebook = findViewById(R.id.facebook);
        twitter = findViewById(R.id.twitter);
        google = findViewById(R.id.google);


        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmpassword);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        register =findViewById(R.id.register);


        //login icons
        Picasso.get()
                .load("https://i.pinimg.com/236x/4e/ff/ea/4effeae35be0a015037d4412c63e71da.jpg")
                .resize(50, 50)
                .centerCrop()
                .into(facebook);
        Picasso.get()
                .load("https://i.pinimg.com/236x/84/3d/d8/843dd8ca717a56cfc9a615df10d39944.jpg")
                .resize(50, 50)
                .centerCrop()
                .into(twitter);
        Picasso.get()
                .load("https://i.pinimg.com/236x/39/21/6d/39216d73519bca962bd4a01f3e8f4a4b.jpg")
                .resize(50, 50)
                .centerCrop()
                .into(google);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Register();

            }
        });
    }

    private void Register() {
        String getEmail = email.getText().toString();
        String getPassword = password.getText().toString();
        String getUserName = username.getText().toString();
        String getConfirmPassword = confirmPassword.getText().toString();

        if(TextUtils.isEmpty(getEmail)){
            email.setError("Enter your Email");
            return;
        }else if(TextUtils.isEmpty(getPassword)) {
            password.setError("Enter your Password");
            return;
        }else if(TextUtils.isEmpty(getUserName)) {
            username.setError("Enter your username");
            return;
        }else if(TextUtils.isEmpty(getConfirmPassword)) {
            confirmPassword.setError("Confirm your Password");
            return;
        }else if(!getPassword.equals(getConfirmPassword)){
            confirmPassword.setError("Passwords dont match");
            return;
        }else if(getPassword.length()<6){
            password.setError("Length of password is too short!");
            return;
        }else if(!isValidEmail(getEmail)){
            email.setError("Invalid Email");
            return;
        }

        mAuth.createUserWithEmailAndPassword(getEmail,getPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Successfully registered, Now Login", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this, "Signup failed, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


}