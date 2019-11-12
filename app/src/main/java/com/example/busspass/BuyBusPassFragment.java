package com.example.busspass;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyBusPassFragment extends Fragment {

    public Button mPlus,mMinus,mProceedToPay;
    TextView mQuantity,mTotalPass,mTotalPrice;
    public int quantity,totalpass,totalprice;


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


    }
}