package com.moringaschool.exchangerateapp;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
<<<<<<< HEAD
import android.widget.ProgressBar;
=======
>>>>>>> cf1fc54a6b1d700c6a3e8b929eb5a89c32fa6ebf
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatesActivity extends AppCompatActivity {
//    private static final String TAG = RatesActivity.class.getSimpleName();
//
//    @BindView(R.id.errorTextView) TextView mErrorTextView;
//    @BindView(R.id.progressBar)
//    ProgressBar mProgressBar;
//    @BindView(R.id.rateTextView) TextView mRateTextView;
//    @BindView(R.id.listView) ListView mListView;
//
//    // private int [] rates  = new int [] {Integer.parseInt("dollars"), Integer.parseInt("euros")};
//
//
//   // private String [] country = new String [] {"Kshs","dollars"};
//    //private int [] rates  =new int[] {100,200};
//
//
//    // private String[] rates = new String[] {1000, 200,
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rates);
//        ButterKnife.bind(this);
//
////        mListView = (ListView) findViewById(R.id.listView);
////        mRateTextView = (TextView) findViewById(R.id.rateTextView);
//
//        //  ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, currencyRates);
//      //  MyRatesArrayAdapter adapter = new MyRatesArrayAdapter(this, android.R.layout.simple_list_item_1, country,rates); // the arguments must match constructor's parameters!
//      //  mListView.setAdapter(adapter);
//
//
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String rates = ((TextView)view).getText().toString();
//                Toast.makeText(RatesActivity.this, rates, Toast.LENGTH_LONG).show();
//            }
//        });
//
//        Intent intent = getIntent();
//        String rate = intent.getStringExtra("rate");
//     //   int rate = intent.getIntExtra("rate", 0);
//
//        // int rate = parseInt(intent.getStringExtra("rate"));
//        //int rate = parseInt(mRateEditText.getText().toString());
//        //int rate = intent.getStringExtra("rate");
//        mRateTextView.setText("The input currency is shs: " + rate);
//
//
//    CurrencyApi client = CurrencyClient.getClient();
//
//    Call<CurrencyExchangeRateSearchResponse> call = client.getRates("rates");
//
//    call.enqueue(new Callback<CurrencyExchangeRateSearchResponse>() {
//        @Override
//        public void onResponse(Call<CurrencyExchangeRateSearchResponse> call, Response<CurrencyExchangeRateSearchResponse> response) {
//            hideProgressBar();
//
//            if (response.isSuccessful()) {
//                assert response.body() != null;
//                List<Rates> ratesList = response.body().getRates();
//                String [] rates = new String[ratesList.size()];
//
//
//                for (int i = 0; i < rates.length; i++){
//                    rates[i] = String.valueOf(ratesList.get(i).getAll());
//                   // rates[i] = Integer.parseInt(String.valueOf(ratesList.get(i).getAll()));
//                }
//
////                for (int i = 0; i < categories.length; i++) {
////                    Category category = restaurantsList.get(i).getCategories().get(0);
////                    categories[i] = category.getTitle();
////                }
//
//                ArrayAdapter adapter = new MyRatesArrayAdapter(RatesActivity.this, android.R.layout.simple_list_item_1, rates);
//                mListView.setAdapter(adapter);
//
//                showRates();
//            } else {
//                showUnsuccessfulMessage();
//            }
//
//        }
//
//        @Override
//        public void onFailure(Call<CurrencyExchangeRateSearchResponse> call, Throwable t) {
//            hideProgressBar();
//            showFailureMessage();
//
//        }
//
//
//    });
//}
//
//
//
//
//    private void showFailureMessage() {
//        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showUnsuccessfulMessage() {
//        mErrorTextView.setText("Something went wrong. Please try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showRates() {
//        mListView.setVisibility(View.VISIBLE);
//        mRateTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }

=======

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class RatesActivity extends AppCompatActivity {
    private TextView mRateTextView;
    private ListView mListView;

//    @BindView(R.id.rateTextView) TextView mRateTextView;
//    @BindView(R.id.listView) ListView mListView;

   // private int [] rates  = new int [] {Integer.parseInt("dollars"), Integer.parseInt("euros")};
    private String [] country = new String [] {"Kshs","dollars"};
    private int [] rates  =new int[] {100,200};
  // private String[] rates = new String[] {1000, 200,

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rates);
      //  ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.listView);
        mRateTextView = (TextView) findViewById(R.id.rateTextView);

      //  ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, currencyRates);
        MyRatesArrayAdapter adapter = new MyRatesArrayAdapter(this, android.R.layout.simple_list_item_1, country,rates); // the arguments must match constructor's parameters!
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String rates = ((TextView)view).getText().toString();
                Toast.makeText(RatesActivity.this, rates, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        int rate = intent.getIntExtra("rate", 0);

       // int rate = parseInt(intent.getStringExtra("rate"));
        //int rate = parseInt(mRateEditText.getText().toString());
        //int rate = intent.getStringExtra("rate");
        mRateTextView.setText("The input currency is shs: " + rate);
    }
>>>>>>> cf1fc54a6b1d700c6a3e8b929eb5a89c32fa6ebf
}