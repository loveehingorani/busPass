package com.example.busspass;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;


public class TransactionFragment extends Fragment {

    private ArrayList<Transactions> transactionList;
    private TransactionRecyclerAdapter transactionRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_transaction,container,false);

        transactionList = new ArrayList<>();
        transactionRecyclerAdapter = new TransactionRecyclerAdapter(getContext(), transactionList);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(transactionRecyclerAdapter);
        updateData();
        return v;
    }

    private void updateData(){
        FirebaseFirestore.getInstance()
                .collection("Transactions")
                .whereEqualTo("uid", FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    transactionList.clear();
                    for(DocumentSnapshot documentSnapshot: queryDocumentSnapshots){

                        Transactions transactions = documentSnapshot.toObject(Transactions.class);
                        transactionList.add(transactions);

                    }
                    Collections.reverse(transactionList);
                    transactionRecyclerAdapter.notifyDataSetChanged();
                });
    }
}
