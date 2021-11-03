package com.moringaschool.exchangerateapp;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
}