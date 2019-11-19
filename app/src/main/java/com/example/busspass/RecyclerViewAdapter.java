package com.example.busspass;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

import static com.paytm.pgsdk.easypay.manager.PaytmAssist.getContext;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private String timeString;


    private int hourInt;
    private int minuteInt;

    private int varMin=0;
    private int dayOfWeek=1;
    Calendar alarmCalendar;
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
//                        new AlarmSetter(itemList.get(position).getTime(),itemList.get(position).getDay());
                        AlarmSetter(itemList.get(position).getTime(),itemList.get(position).getDay(),Integer.parseInt((itemList.get(position).getId())));
                      //  AlarmSetter("11:59 AM","Tuesday",490);
                       Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Tuesday")) {
                        tuesdaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        AlarmSetter(itemList.get(position).getTime(),itemList.get(position).getDay(),29+Integer.parseInt((itemList.get(position).getId())));
                      //  AlarmSetter("12:00 PM","Tuesday",489);
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Wednesday")) {
                        wednesdaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        AlarmSetter(itemList.get(position).getTime(),itemList.get(position).getDay(),58+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Thursday")) {
                        thursdaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        AlarmSetter(itemList.get(position).getTime(),itemList.get(position).getDay(),87+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Friday")) {
                        fridaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        AlarmSetter(itemList.get(position).getTime(),itemList.get(position).getDay(),116+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Saturday")) {
                        saturdaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        AlarmSetter(itemList.get(position).getTime(),itemList.get(position).getDay(),145+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Sunday")) {
                        sundaydb.updatedata(itemList.get(position).getId(), true, itemList.get(position).getNotifyMe());
                        AlarmSetter(itemList.get(position).getTime(),itemList.get(position).getDay(),178+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Set" , Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    if(itemList.get(position).getDay().equals("Monday")) {
                       mondaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                     //   AlarmSetter("06:13 AM","Tuesday");
                        unSetAlarm(Integer.parseInt((itemList.get(position).getId())));
                       Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Tuesday")) {
                        tuesdaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                      //  AlarmSetter("06:14 AM","Tuesday");
                        unSetAlarm(29+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Wednesday")) {
                        wednesdaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        unSetAlarm(58+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Thursday")) {
                        thursdaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        unSetAlarm(87+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Friday")) {
                        fridaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        unSetAlarm(116+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Saturday")) {
                        saturdaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        unSetAlarm(145+Integer.parseInt((itemList.get(position).getId())));
                        Toast.makeText(mContext, "Alarm Removed", Toast.LENGTH_LONG).show();
                    }
                    if(itemList.get(position).getDay().equals("Sunday")) {
                        sundaydb.updatedata(itemList.get(position).getId(), false, itemList.get(position).getNotifyMe());
                        unSetAlarm(178+Integer.parseInt((itemList.get(position).getId())));
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



    public void AlarmSetter(String timeString,String dayString,int id)
    {

        hourInt=Integer.parseInt(Character.toString(timeString.charAt(0))+Character.toString(timeString.charAt(1)));



        if(timeString.charAt(6)=='P'&&hourInt!=12)
        {
            hourInt+=12;

        }
        Log.i("timmmmmmmmmmmmmmmmmm","                                hourInt = "+hourInt);
        minuteInt=Integer.parseInt(Character.toString(timeString.charAt(3))+Character.toString(timeString.charAt(4)));
        if((minuteInt-varMin)<0)
        {
            hourInt=hourInt-1;
            minuteInt=minuteInt-varMin+60;
        }

        else
        {
            minuteInt=minuteInt-varMin;
        }

        Log.i("timmmmmmmmmmmmmmmmmm","                                hourInt = "+minuteInt);
        if(dayString.equals("Sunday")){ dayOfWeek=1;}
        else if(dayString.equals("Monday")){ dayOfWeek=2;}
        else if(dayString.equals("Tuesday")){ dayOfWeek=3;}
        else if(dayString.equals("Wednesday")){ dayOfWeek=4;}
        else if(dayString.equals("Thursday")){ dayOfWeek=5;}
        else if(dayString.equals("Friday")){ dayOfWeek=6;}
        else if(dayString.equals("Saturday")){ dayOfWeek=7;}
        Log.i("timmmmmmmmmmmmmmmmmm","                                hourInt = "+dayOfWeek);
        alarmCalendar= Calendar.getInstance();

        setAlarm(hourInt,minuteInt,dayOfWeek,id);

    }

    public void setAlarm(int hourInt,int minuteInt,int dayOfWeek,int id) {
        // Add this day of the week line to your existing code


        int day = alarmCalendar.get(Calendar.DAY_OF_WEEK);
        if(day > dayOfWeek)
            alarmCalendar.add(Calendar.DATE, day - dayOfWeek);
        else
            alarmCalendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        alarmCalendar.set(Calendar.HOUR_OF_DAY, hourInt);
        alarmCalendar.set(Calendar.MINUTE, minuteInt);
        alarmCalendar.set(Calendar.SECOND, 0);
        //alarmCalendar.set(Calendar.AM_PM, amorpm);

        long alarmTime = alarmCalendar.getTimeInMillis();
        //Also change the time to 24 hours.
        AlarmManager alarmMgr = (AlarmManager) mContext.getSystemService(mContext.ALARM_SERVICE);
        Intent intent = new Intent(mContext, AlarmReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, id, intent, 0);
        // cal.add(Calendar.SECOND, 5);
        alarmMgr.setExact(AlarmManager.RTC_WAKEUP, alarmTime,  pendingIntent);
    }

    public void unSetAlarm(int id){
        AlarmManager alarmMgr = (AlarmManager) mContext.getSystemService(mContext.ALARM_SERVICE);
        Intent intent = new Intent(mContext, AlarmReciever.class);
        PendingIntent pending = PendingIntent.getBroadcast(mContext, id, intent, 0);
        alarmMgr.cancel(pending);
    }
}