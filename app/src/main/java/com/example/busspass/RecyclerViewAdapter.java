package com.example.busspass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.paytm.pgsdk.easypay.manager.PaytmAssist.getContext;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    MondayDatabaseHelper mondaydb;
    TuesdayDatabaseHelper tuesdaydb;
    WednesdayDatabaseHelper wednesdaydb;
    ThursdayDatabaseHelper thursdaydb;
    FridayDatabaseHelper fridaydb;
    SaturdayDatabaseHelper saturdaydb;
    SundayDatabaseHelper sundaydb;
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
        Boolean switchset=itemList.get(position).getSetReminder();
        Boolean switchnotify=itemList.get(position).getNotifyMe();
        if(switchset==true)
        {
            holder.mSetReminder.setChecked(true);
        }
        else
        {
            holder.mSetReminder.setChecked(false);
        }
        if(switchnotify==true)
        {
            holder.mNotifyMe.setChecked(true);
        }
        else
        {
            holder.mNotifyMe.setChecked(false);
        }

        mondaydb=new MondayDatabaseHelper(mContext);
        tuesdaydb=new TuesdayDatabaseHelper(mContext);
        wednesdaydb=new WednesdayDatabaseHelper(mContext);
        thursdaydb=new ThursdayDatabaseHelper(mContext);
        fridaydb=new FridayDatabaseHelper(mContext);
        saturdaydb=new SaturdayDatabaseHelper(mContext);
        sundaydb=new SundayDatabaseHelper(mContext);

        holder.mSetReminder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(holder.mSetReminder.isChecked()==true)
                {
                    if(itemList.get(position).getDay().equals("Monday")) {
                        mondaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                       Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Tuesday")) {
                        tuesdaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Wednesday")) {
                        wednesdaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Thursday")) {
                        thursdaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Friday")) {
                        fridaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Saturday")) {
                        saturdaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Sunday")) {
                        sundaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    if(itemList.get(position).getDay().equals("Monday")) {
                       mondaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                       Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Tuesday")) {
                        tuesdaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Wednesday")) {
                        wednesdaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Thursday")) {
                        thursdaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Friday")) {
                        fridaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Saturday")) {
                        saturdaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Sunday")) {
                        sundaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }



                }
            }
        });
        holder.mNotifyMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(holder.mNotifyMe.isChecked()==true)
                {
                    if(itemList.get(position).getDay().equals("Monday")) {
                        mondaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),true);
                        Toast.makeText(mContext, "You Will Be Notified", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Tuesday")) {
                        tuesdaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),true);
                        Toast.makeText(mContext, "You Will Be Notified", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Wednesday")) {
                        wednesdaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),true);
                        Toast.makeText(mContext, "You Will Be Notified", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Thurday")) {
                        thursdaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),true);
                        Toast.makeText(mContext, "You Will Be Notified", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Friday")) {
                        fridaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),true);
                        Toast.makeText(mContext, "You Will Be Notified", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Saturday")) {
                        saturdaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),true);
                        Toast.makeText(mContext, "You Will Be Notified", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Sunday")) {
                        sundaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),true);
                        Toast.makeText(mContext, "You Will Be Notified", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    if(itemList.get(position).getDay().equals("Monday")) {
                        mondaydb.updatedata(itemList.get(position).getId(), itemList.get(position).getSetReminder(),false);
                        Toast.makeText(mContext, "Notification Off", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Tuesday")) {
                        tuesdaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),false);
                        Toast.makeText(mContext, "Notification Off", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Wednesday")) {
                        wednesdaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),false);
                        Toast.makeText(mContext, "Notification Off", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Thurday")) {
                        thursdaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),false);
                        Toast.makeText(mContext, "Notification Off", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Friday")) {
                        fridaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),false);
                        Toast.makeText(mContext, "Notification Off", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Saturday")) {
                        saturdaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),false);
                        Toast.makeText(mContext, "Notification Off", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Sunday")) {
                        sundaydb.updatedata(itemList.get(position).getId(),  itemList.get(position).getSetReminder(),false);
                        Toast.makeText(mContext, "Notification Off", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView time,start,end,bus;
        Switch mSetReminder,mNotifyMe;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.time);
            start = (TextView) itemView.findViewById(R.id.start);
            end = (TextView) itemView.findViewById(R.id.end);
            bus = (TextView) itemView.findViewById(R.id.bus);
            mSetReminder=itemView.findViewById(R.id.setReminder);
            mNotifyMe=itemView.findViewById(R.id.notifyMe);
        }
    }
}
