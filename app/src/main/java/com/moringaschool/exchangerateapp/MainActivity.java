package com.moringaschool.exchangerateapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.JsonObject;
import com.moringaschool.exchangerateapp.Authentication.LoginActivity;
import com.moringaschool.exchangerateapp.Profile.ProfileActivity;
import com.moringaschool.exchangerateapp.retrofit.RetrofitBuilder;
import com.moringaschool.exchangerateapp.retrofit.RetrofitInterface;

import static android.content.ContentValues.TAG;
import static java.lang.Integer.parseInt;
//
//import okhttp3.Callback;
//import okhttp3.Response;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //private static final String TAG = MainActivity.class.getSimpleName();
    private Button button;
    private EditText currencyToBeConverted;
    private EditText currencyConverted;
    private Spinner convertToDropdown;
    private Spinner convertFromDropdown;


   // @BindView(R.id.errorTextView) TextView mErrorTextView;
   // @BindView(R.id.progressBar)ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // ButterKnife.bind(this);

        //Initialization
        currencyConverted = (EditText) findViewById(R.id.currency_converted);
        currencyToBeConverted = (EditText) findViewById(R.id.currency_to_be_converted);
        convertToDropdown = (Spinner) findViewById(R.id.convert_to);
        convertFromDropdown = (Spinner) findViewById(R.id.convert_from);
        button = (Button) findViewById(R.id.button);

        //Adding Functionality
        String[] dropDownList = {"USD", "KES", "EUR", "NZD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
        convertToDropdown.setAdapter(adapter);
        convertFromDropdown.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitInterface retrofitInterface = RetrofitBuilder.getRetrofitInstance().create(RetrofitInterface.class);
                //Call<JSONObject>  call = retrofitInterface.getExchangeCurrency("INR");
                Call<JsonObject> call = retrofitInterface.getExchangeCurrency(convertFromDropdown.getSelectedItem().toString());
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        //Log.d("response",String.valueOf(response.body()));
                        JsonObject res = response.body();
                        JsonObject rates = res.getAsJsonObject("rates");
                        double currency = Double.valueOf(currencyToBeConverted.getText().toString());
                        double multiplier = Double.valueOf(rates.get(convertToDropdown.getSelectedItem().toString()).toString());
                        double result = currency * multiplier;
                        currencyConverted.setText(String.valueOf(result));
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.e("Error Message", "onFailure: ",t );
                        //hideProgressBar();
                        //showFailureMessage();
                    }
                });
            }
        });




//        private void showFailureMessage() {
//            mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
//            mErrorTextView.setVisibility(View.VISIBLE);
//        }
//
//        private void showUnsuccessfulMessage() {
//            mErrorTextView.setText("Something went wrong. Please try again later");
//            mErrorTextView.setVisibility(View.VISIBLE);
//        }
//
//
//        private void hideProgressBar() {
//            mProgressBar.setVisibility(View.GONE);
//        }





    }

}











//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//
//    //esthers work
//
//    private Button mFindRatesButton;
//    private EditText mRateEditText;
//    private TextView mAppNameTextView;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener(){
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
//
//                } else {
//
//                }
//            }
//        };
//
//        //Esthers work
//
//        mRateEditText = (EditText) findViewById(R.id.rateEditText);
//        mFindRatesButton = (Button) findViewById(R.id.findRatesButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
//
//        mFindRatesButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v == mFindRatesButton) {
//            int rate = parseInt(mRateEditText.getText().toString());
//             Log.d(TAG, String.valueOf(rate));
//            Intent intent = new Intent(MainActivity.this, RatesActivity.class);
//            intent.putExtra("rate", rate);
//            startActivity(intent);
//        }
//
//            }
//        });
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//        if(id == R.id.action_logout){
//            logout();
//            return true;
//        }
//        if(id == R.id.profile){
//            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//            startActivity(intent);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void logout(){
//        FirebaseAuth.getInstance().signOut();
//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        finish();
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
//    }
//


