package com.moringaschool.exchangerateapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

//public class MyRatesArrayAdapter  extends BaseAdapter {
//    private Context mContext;
//   // private String[] mCountry;
//    private ArrayList<Rates> mRates;
//    public MyRatesArrayAdapter(Context context,ArrayList<Rates> mRates){
//        this.mContext = context;
//        this.mRates= mRates;
//
//    }
//
//    @Override
//    public int getCount() {
//        return mRates.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mRates.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }

//    public MyRatesArrayAdapter(Context context,  List<Rates> mRates) {
//        super(context);
//        this.mContext = mContext;
//       //// this.mCountry = mCountry;
//        this.mRates= mRates;
//    }

//    @Override
//    public Object getItem(int position) {
//      //  String country = mCountry[position];
//        String rate = mRates[position];
//
//        return String.format("%s \nNew currency is: %s",rate);
//    }
//
//    @Override
//    public int getCount() {
//        return mRates.length;
//    }
//}
