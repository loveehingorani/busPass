package com.example.busspass;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static androidx.core.content.ContextCompat.getSystemService;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyBusPassFragment extends Fragment {

    public Button mPlus,mMinus,mProceedToPay;
    TextView mQuantity,mTotalPass,mTotalPrice;
    public int quantity=1,totalpass,totalprice=25;
    String orderId,customerId="023";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_buy_bus_pass,container,false);
        mPlus= v.findViewById(R.id.plus);
        mMinus= v.findViewById(R.id.minus);
        mProceedToPay= v.findViewById(R.id.proceed_to_pay);

        mQuantity=v.findViewById(R.id.quantity);
        mTotalPass=v.findViewById(R.id.total_pass);
        mTotalPrice=v.findViewById(R.id.total_price);


        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPlus(mPlus);

            }
        });


        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doMinus(mMinus);

            }
        });
        mProceedToPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToPay(mProceedToPay);

            }
        });

        //Allow read sms permission
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS}, 101);
        }

        return v;
    }
    public void doMinus(View view)
    {
        quantity= Integer.parseInt(mQuantity.getText().toString());
        if(quantity==1) {
            Toast.makeText(getActivity(), "Minimum Quantity:1", Toast.LENGTH_LONG).show();
        }

        else{
            quantity--;
            mQuantity.setText(""+quantity);
        }
        mTotalPass.setText(""+quantity);
        totalprice=quantity*25;
        mTotalPrice.setText(""+totalprice);

    }
    public void doPlus(View view){
        quantity= Integer.parseInt(mQuantity.getText().toString());
        if(quantity==10)
        {
            Toast.makeText(getActivity(),"Maximum Quantity:10",Toast.LENGTH_LONG).show();
        }
        else{
            quantity++;
            mQuantity.setText(""+quantity);
        }
        mTotalPass.setText(""+quantity);
        totalprice=quantity*25;
        mTotalPrice.setText(""+totalprice);
    }


    public void proceedToPay(View view){

        ConnectivityManager cm = (ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo == null || !(netInfo.isConnectedOrConnecting())) {
            //Don't allow click if internet is down
            Toast.makeText(getContext(), "Unable to access internet: Check if internet is working and allow app permission to access internet in settings", Toast.LENGTH_LONG).show();
            return;
        }


        //TODO:Code for customer Id here

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Calendar calendar= Calendar.getInstance();
        String time=calendar.getTimeInMillis()+"";

        orderId=customerId+"."+date+"."+time;
        Intent callChecksum = new  Intent(getActivity(),Checksum.class);
        callChecksum.putExtra("Transaction Amount",totalprice);
        callChecksum.putExtra("Order Id",orderId);
        callChecksum.putExtra("Customer Id",customerId);

        startActivity(callChecksum);

        getActivity().finish();
    }
}