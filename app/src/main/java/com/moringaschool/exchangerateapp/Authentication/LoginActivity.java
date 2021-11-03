package com.moringaschool.exchangerateapp.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                    finish();
                }
            }
        };


    facebook = findViewById(R.id.facebook);
    twitter = findViewById(R.id.twitter);
    google = findViewById(R.id.google);
    register = findViewById(R.id.moveToRegister);

    email = findViewById(R.id.email);
    password =findViewById(R.id.password);
    login = findViewById(R.id.login);


        mAuth = FirebaseAuth.getInstance();



        //logging in logic


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

        //logging in logic

       login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Login();

            }
        });
    }

    private void Login() {
        String getEmail = email.getText().toString();
        String getPassword = password.getText().toString();


        if(TextUtils.isEmpty(getEmail)){
            email.setError("Enter your Email");
            return;
        }else if(TextUtils.isEmpty(getPassword)) {
            password.setError("Enter your Password");
            return;

        }else if(getPassword.length()<6){
            password.setError("Length of password is too short!");
            return;
        }else if(!isValidEmail(getEmail)){
            email.setError("Invalid Email");
            return;
        }

        mAuth.signInWithEmailAndPassword(getEmail,getPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "Login failed, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}




