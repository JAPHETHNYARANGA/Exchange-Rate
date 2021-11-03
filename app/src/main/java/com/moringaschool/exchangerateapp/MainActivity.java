package com.moringaschool.exchangerateapp;

//import static androidx.collection.ArraySet.TAG;
import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindRatesButton;
    private EditText mRateEditText;
    private TextView mAppNameTextView;

//    @BindView(R.id.findRatesButton) Button mFindRatesButton;
//    @BindView(R.id.rateEditText) EditText mRateEditText;
//    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife.bind(this);

        mRateEditText = (EditText) findViewById(R.id.rateEditText);
        mFindRatesButton = (Button) findViewById(R.id.findRatesButton);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);

        mFindRatesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRatesButton) {
            int rate = parseInt(mRateEditText.getText().toString());
            // Log.d(TAG, String.valueOf(rate));
            Intent intent = new Intent(MainActivity.this, RatesActivity.class);
            intent.putExtra("rate", rate);
            startActivity(intent);
        }

    }
}

//    parseInt(myEditWidget. getText(). toString());
