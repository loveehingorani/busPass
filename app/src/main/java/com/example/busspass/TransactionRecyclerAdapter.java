package com.example.busspass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionRecyclerAdapter extends RecyclerView.Adapter<TransactionRecyclerAdapter.RecycleViewHolder> {
    private String timeString;


    Context mContext;
    List<TransactionInfo> itemList;
    public TransactionRecyclerAdapter(Context context,List<TransactionInfo> itemList)
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
        String s1 = itemList.get(position).getTime();
        holder.time.setText(s1);
        String s2 = itemList.get(position).getDate();
        holder.date.setText(s2);
        String s3 = itemList.get(position).getAmount();
        holder.amount.setText(s3);
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
}