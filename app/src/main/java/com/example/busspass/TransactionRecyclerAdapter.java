package com.example.busspass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionRecyclerAdapter extends RecyclerView.Adapter<TransactionRecyclerAdapter.RecycleViewHolder> {
    private String timeString;


    Context mContext;
    List<Transactions> itemList;
    public TransactionRecyclerAdapter(Context context,List<Transactions> itemList)
    {
        mContext=context;
        this.itemList=itemList;

    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.transaction_list_item,parent,false);
        return new RecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        holder.date.setText(getDate(itemList.get(position).getTime()));
        holder.amount.setText(itemList.get(position).getAmount());
    }

    @Override
    public int getItemCount() {
       return itemList.size();
    }


    public class RecycleViewHolder extends RecyclerView.ViewHolder{
        TextView time,date,amount;

         public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
             time = (TextView) itemView.findViewById(R.id.time);
             date = (TextView) itemView.findViewById(R.id.date);
            amount = (TextView) itemView.findViewById(R.id.amount);
        }
    }

    private String getDate(Timestamp timestamp){
        String pattern = "yyyy-MM-dd, hh:mm a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(timestamp.toDate());
        return date;
    }
}