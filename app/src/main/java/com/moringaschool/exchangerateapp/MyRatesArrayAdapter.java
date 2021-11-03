package com.moringaschool.exchangerateapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class MyRatesArrayAdapter  extends ArrayAdapter {
    private Context mContext;
    private String[] mCountry;
    private int [] mRates;


    public MyRatesArrayAdapter(@NonNull Context context, int resource, String [] mCountry, int [] mRates) {
        super(context, resource);
        this.mContext = mContext;
        this.mCountry = mCountry;
        this.mRates= mRates;
    }

    @Override
    public Object getItem(int position) {
        String country = mCountry[position];
        int rate = mRates[position];

        return String.format("%s \nNew currency is: %s", country,rate);
    }

    @Override
    public int getCount() {
        return mCountry.length;
    }
}
