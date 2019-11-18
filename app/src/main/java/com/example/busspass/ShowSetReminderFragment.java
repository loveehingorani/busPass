package com.example.busspass;


import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.paytm.pgsdk.easypay.utils.Log;

import java.util.ArrayList;

import static java.util.Calendar.AM;

public class ShowSetReminderFragment extends Fragment {

private Switch setReminder,notifyMe;
MondayDatabaseHelper mondaydb;
    TuesdayDatabaseHelper tuesdaydb;
    WednesdayDatabaseHelper wednesdaydb;
    ThursdayDatabaseHelper thursdaydb;
    FridayDatabaseHelper fridaydb;
    SaturdayDatabaseHelper saturdaydb;
    SundayDatabaseHelper sundaydb;
public ArrayList<BusInfo> selectedList;
private String getInfo[]=new String[3];
private String day="Saturday",start="Ajmeri Gate",end="LNMIIT";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_show_set_reminder, container, false);
        mondaydb=new MondayDatabaseHelper(getContext());
        tuesdaydb=new TuesdayDatabaseHelper(getContext());
        wednesdaydb=new WednesdayDatabaseHelper(getContext());
        thursdaydb=new ThursdayDatabaseHelper(getContext());
        fridaydb=new FridayDatabaseHelper(getContext());
        saturdaydb=new SaturdayDatabaseHelper(getContext());
        sundaydb=new SundayDatabaseHelper(getContext());

//        ArrayList<BusInfo> mondayList=new ArrayList<BusInfo>();
//        mondayList.add(new BusInfo("7:00 AM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("1:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("5:00 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("8:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("11:00 AM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("3:05 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("6:15 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("8:05 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("6:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("7:00 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("7:15 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("9:45 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//
//        mondayList.add(new BusInfo("7:00 AM","Chomu Puliya","LNMIIT","Government Bus"));
//        mondayList.add(new BusInfo("11:15 AM","Chomu Puliya","LNMIIT","Government Bus"));
//        mondayList.add(new BusInfo("3:30 PM","Chomu Puliya","LNMIIT","Government Bus"));
//        mondayList.add(new BusInfo("9:15 AM","LNMIIT","Chomu Puliya","Government Bus"));
//        mondayList.add(new BusInfo("1:30 PM","LNMIIT","Chomu Puliya","Government Bus"));
//        mondayList.add(new BusInfo("5:30 PM","LNMIIT","Chomu Puliya","Government Bus"));
//        mondayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","Government Bus"));
//        mondayList.add(new BusInfo("12:00 PM","Ajmeri Gate","LNMIIT","Government Bus"));
//        mondayList.add(new BusInfo("4:00 PM","Ajmeri Gate","LNMIIT","Government Bus"));
//        mondayList.add(new BusInfo("8:45 AM","LNMIIT","Nai Ki Thadi","Government Bus"));
//        mondayList.add(new BusInfo("12:45 PM","LNMIIT","Nai Ki Thadi","Government Bus"));
//        mondayList.add(new BusInfo("4:45 PM","LNMIIT","Nai Ki Thadi","Government Bus"));
//        mondayList.add(new BusInfo("9:10 AM","Nai Ki Thadi","LNMIIT","Government Bus"));
//        mondayList.add(new BusInfo("1:25 PM","Nai Ki Thadi","LNMIIT","Government Bus"));
//        mondayList.add(new BusInfo("5:20 PM","Nai Ki Thadi","LNMIIT","Government Bus"));
//

        ArrayList<BusInfo> sundayList=new ArrayList<BusInfo>();

//        sundayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("1:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("3:00 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("7:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT",    "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("10:00 AM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("12:00 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("6:15 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("8:05 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("3:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("4:15 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("6:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("7:00 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("4:30 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("5:30 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("7:15 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("9:45 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//
//        ArrayList<BusInfo> saturdayList=new ArrayList<BusInfo>();
//        saturdayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("1:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("3:00 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("7:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("10:00 AM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("12:00 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("6:15 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("8:05 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("3:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("4:15 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("6:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("7:00 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("4:30 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("5:30 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("7:15 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("9:45 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
//
//        saturdayList.add(new BusInfo("7:00 AM","Chomu Puliya","LNMIIT","Government Bus"));
//        saturdayList.add(new BusInfo("11:15 AM","Chomu Puliya","LNMIIT","Government Bus"));
//        saturdayList.add(new BusInfo("3:30 PM","Chomu Puliya","LNMIIT","Government Bus"));
//        saturdayList.add(new BusInfo("9:15 AM","LNMIIT","Chomu Puliya","Government Bus"));
//        saturdayList.add(new BusInfo("1:30 PM","LNMIIT","Chomu Puliya","Government Bus"));
//        saturdayList.add(new BusInfo("5:30 PM","LNMIIT","Chomu Puliya","Government Bus"));
//        saturdayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","Government Bus"));
//        saturdayList.add(new BusInfo("12:00 PM","Ajmeri Gate","LNMIIT","Government Bus"));
//        saturdayList.add(new BusInfo("4:00 PM","Ajmeri Gate","LNMIIT","Government Bus"));
//        saturdayList.add(new BusInfo("8:45 AM","LNMIIT","Nai Ki Thadi","Government Bus"));
//        saturdayList.add(new BusInfo("12:45 PM","LNMIIT","Nai Ki Thadi","Government Bus"));
//        saturdayList.add(new BusInfo("4:45 PM","LNMIIT","Nai Ki Thadi","Government Bus"));
//        saturdayList.add(new BusInfo("9:10 AM","Nai Ki Thadi","LNMIIT","Government Bus"));
//        saturdayList.add(new BusInfo("1:25 PM","Nai Ki Thadi","LNMIIT","Government Bus"));
//        saturdayList.add(new BusInfo("5:20 PM","Nai Ki Thadi","LNMIIT","Government Bus"));
//


    getInfo=getArguments().getStringArray("key");
    day=getInfo[0];
    start=getInfo[1];
    end=getInfo[2];
        selectedList=new ArrayList<BusInfo>();
        if(day=="Monday")
        {
            Cursor  mondayCursor=mondaydb.getAllData();
            while(mondayCursor.moveToNext()) {
                if (mondayCursor.getString(2).equals(start) && mondayCursor.getString(3).equals(end)) {
                    String id = mondayCursor.getString(0);
                    String alarm = mondayCursor.getString(5);
                    String notify = mondayCursor.getString(6);
                    Boolean notifyBool, alarmBool;
                    if (notify.equals("0")) {
                        notifyBool = false;
                    } else {
                        notifyBool = true;
                    }
                    if (alarm.equals("1")) {
                        alarmBool = true;
                    } else {
                        alarmBool = false;
                    }

                    // Log.i("Helllcsmcnsmvnmsnvmsnvmsnsmvs cscsdmcksmcksmcksmdcjsdncso","dsfbhsbjhbsfbsh                                                                                                                                         bfjshbfhsbbjbcsdbchjsbchsbcjsbchjbsjcbsdjvbsdbvsvbsjv"+alarmBool);

                    selectedList.add(new BusInfo(id, mondayCursor.getString(1), mondayCursor.getString(2), mondayCursor.getString(3), mondayCursor.getString(4), day, alarmBool, notifyBool));
                }
            }
        }
        if(day=="Tuesday")
        {
            Cursor  tuesdayCursor=tuesdaydb.getAllData();
            while(tuesdayCursor.moveToNext()) {
                if (tuesdayCursor.getString(2).equals(start) && tuesdayCursor.getString(3).equals(end)) {
                    String id = tuesdayCursor.getString(0);
                    String alarm = tuesdayCursor.getString(5);
                    String notify = tuesdayCursor.getString(6);
                    Boolean notifyBool, alarmBool;
                    if (notify.equals("0")) {
                        notifyBool = false;
                    } else {
                        notifyBool = true;
                    }
                    if (alarm.equals("1")) {
                        alarmBool = true;
                    } else {
                        alarmBool = false;
                    }

                    // Log.i("Helllcsmcnsmvnmsnvmsnvmsnsmvs cscsdmcksmcksmcksmdcjsdncso","dsfbhsbjhbsfbsh                                                                                                                                         bfjshbfhsbbjbcsdbchjsbchsbcjsbchjbsjcbsdjvbsdbvsvbsjv"+alarmBool);

                    selectedList.add(new BusInfo(id, tuesdayCursor.getString(1), tuesdayCursor.getString(2), tuesdayCursor.getString(3), tuesdayCursor.getString(4), day, alarmBool, notifyBool));
                }
            }
        }
        if(day=="Wednesday")
        {
            Cursor  wednesdayCursor=wednesdaydb.getAllData();
            while(wednesdayCursor.moveToNext()) {
                if (wednesdayCursor.getString(2).equals(start) && wednesdayCursor.getString(3).equals(end)) {
                    String id = wednesdayCursor.getString(0);
                    String alarm = wednesdayCursor.getString(5);
                    String notify = wednesdayCursor.getString(6);
                    Boolean notifyBool, alarmBool;
                    if (notify.equals("0")) {
                        notifyBool = false;
                    } else {
                        notifyBool = true;
                    }
                    if (alarm.equals("1")) {
                        alarmBool = true;
                    } else {
                        alarmBool = false;
                    }

                    // Log.i("Helllcsmcnsmvnmsnvmsnvmsnsmvs cscsdmcksmcksmcksmdcjsdncso","dsfbhsbjhbsfbsh                                                                                                                                         bfjshbfhsbbjbcsdbchjsbchsbcjsbchjbsjcbsdjvbsdbvsvbsjv"+alarmBool);

                    selectedList.add(new BusInfo(id, wednesdayCursor.getString(1), wednesdayCursor.getString(2), wednesdayCursor.getString(3), wednesdayCursor.getString(4), day, alarmBool, notifyBool));
                }
            }
        }
        if(day=="Thursday")
        {
            Cursor  thursdayCursor=thursdaydb.getAllData();
            while(thursdayCursor.moveToNext()) {
                if (thursdayCursor.getString(2).equals(start) && thursdayCursor.getString(3).equals(end)) {
                    String id = thursdayCursor.getString(0);
                    String alarm = thursdayCursor.getString(5);
                    String notify = thursdayCursor.getString(6);
                    Boolean notifyBool, alarmBool;
                    if (notify.equals("0")) {
                        notifyBool = false;
                    } else {
                        notifyBool = true;
                    }
                    if (alarm.equals("1")) {
                        alarmBool = true;
                    } else {
                        alarmBool = false;
                    }

                    // Log.i("Helllcsmcnsmvnmsnvmsnvmsnsmvs cscsdmcksmcksmcksmdcjsdncso","dsfbhsbjhbsfbsh                                                                                                                                         bfjshbfhsbbjbcsdbchjsbchsbcjsbchjbsjcbsdjvbsdbvsvbsjv"+alarmBool);

                    selectedList.add(new BusInfo(id, thursdayCursor.getString(1), thursdayCursor.getString(2), thursdayCursor.getString(3), thursdayCursor.getString(4), day, alarmBool, notifyBool));
                }
            }
        }
        if(day=="Friday")
        {
            Cursor  fridayCursor=fridaydb.getAllData();
            while(fridayCursor.moveToNext()) {
                if (fridayCursor.getString(2).equals(start) && fridayCursor.getString(3).equals(end)) {
                    String id = fridayCursor.getString(0);
                    String alarm = fridayCursor.getString(5);
                    String notify = fridayCursor.getString(6);
                    Boolean notifyBool, alarmBool;
                    if (notify.equals("0")) {
                        notifyBool = false;
                    } else {
                        notifyBool = true;
                    }
                    if (alarm.equals("1")) {
                        alarmBool = true;
                    } else {
                        alarmBool = false;
                    }

                    // Log.i("Helllcsmcnsmvnmsnvmsnvmsnsmvs cscsdmcksmcksmcksmdcjsdncso","dsfbhsbjhbsfbsh                                                                                                                                         bfjshbfhsbbjbcsdbchjsbchsbcjsbchjbsjcbsdjvbsdbvsvbsjv"+alarmBool);

                    selectedList.add(new BusInfo(id, fridayCursor.getString(1), fridayCursor.getString(2), fridayCursor.getString(3), fridayCursor.getString(4), day, alarmBool, notifyBool));
                }
            }
        }
        if(day=="Saturday")
        {
            Cursor  saturdayCursor=saturdaydb.getAllData();
            while(saturdayCursor.moveToNext()) {
                if (saturdayCursor.getString(2).equals(start) && saturdayCursor.getString(3).equals(end)) {
                    String id = saturdayCursor.getString(0);
                    String alarm = saturdayCursor.getString(5);
                    String notify = saturdayCursor.getString(6);
                    Boolean notifyBool, alarmBool;
                    if (notify.equals("0")) {
                        notifyBool = false;
                    } else {
                        notifyBool = true;
                    }
                    if (alarm.equals("1")) {
                        alarmBool = true;
                    } else {
                        alarmBool = false;
                    }
                    selectedList.add(new BusInfo(id, saturdayCursor.getString(1), saturdayCursor.getString(2), saturdayCursor.getString(3), saturdayCursor.getString(4), day, alarmBool, notifyBool));
                }
            }
        }
        if(day=="Sunday")
        {
            Cursor  sundayCursor=sundaydb.getAllData();
            while(sundayCursor.moveToNext()) {
                if (sundayCursor.getString(2).equals(start) && sundayCursor.getString(3).equals(end)) {
                    String id = sundayCursor.getString(0);
                    String alarm = sundayCursor.getString(5);
                    String notify = sundayCursor.getString(6);
                    Boolean notifyBool, alarmBool;
                    if (notify.equals("0")) {
                        notifyBool = false;
                    } else {
                        notifyBool = true;
                    }
                    if (alarm.equals("1")) {
                        alarmBool = true;
                    } else {
                        alarmBool = false;
                    }

                    // Log.i("Helllcsmcnsmvnmsnvmsnvmsnsmvs cscsdmcksmcksmcksmdcjsdncso","dsfbhsbjhbsfbsh                                                                                                                                         bfjshbfhsbbjbcsdbchjsbchsbcjsbchjbsjcbsdjvbsdbvsvbsjv"+alarmBool);

                    selectedList.add(new BusInfo(id, sundayCursor.getString(1), sundayCursor.getString(2), sundayCursor.getString(3), sundayCursor.getString(4), day, alarmBool, notifyBool));
                }
            }
        }

        RecyclerView recyclerView=(RecyclerView) v.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(getContext(),selectedList));
//        BusInfoAdapter businfo1=new BusInfoAdapter(getContext(),selectedList);
//        ListView list1=(ListView) v.findViewById(R.id.list);
//        list1.setAdapter(businfo1);
        //selectedList.clear();
 /*
        });*/
        return v;
    }
}
