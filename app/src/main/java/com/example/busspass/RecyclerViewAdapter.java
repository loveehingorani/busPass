package com.example.busspass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    Context mContext;
    List<BusInfo> itemList;
    public RecyclerViewAdapter(Context context,List<BusInfo> itemList)
    {
        mContext=context;
        this.itemList=itemList;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
    View v=inflater.inflate(R.layout.list_item,parent,false);

        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        String s1 = itemList.get(position).getTime();
        holder.time.setText(s1);
        String s2 = itemList.get(position).getStart();
        holder.start.setText(s2);
        String s3 = itemList.get(position).getEnd();
        holder.end.setText(s3);
        String s4 = itemList.get(position).getBus();
        holder.bus.setText(s4);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView time,start,end,bus;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.time);
            start = (TextView) itemView.findViewById(R.id.start);
            end = (TextView) itemView.findViewById(R.id.end);
            bus = (TextView) itemView.findViewById(R.id.bus);
        }
    }
}
