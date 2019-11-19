package com.example.busspass;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TransactionFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_transaction,container,false);


        ArrayList<TransactionInfo> transactionList=new ArrayList<TransactionInfo>();
        transactionList.add(new TransactionInfo("26 oct","4:00 PM","25"));
        transactionList.add(new TransactionInfo("26 oct","4:00 PM","25"));
        transactionList.add(new TransactionInfo("26 oct","4:00 PM","25"));
        transactionList.add(new TransactionInfo("26 oct","4:00 PM","25"));
        transactionList.add(new TransactionInfo("26 oct","4:00 PM","25"));
        transactionList.add(new TransactionInfo("26 oct","4:00 PM","25"));


        RecyclerView recyclerView=(RecyclerView) v.findViewById(R.id.recyclerView1);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new TransactionRecyclerAdapter(getContext(),transactionList));

        return v;
    }

}
