package com.example.busspass;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Calendar.AM;

public class ShowSetReminderFragment extends Fragment {

private Switch setReminder,notifyMe;
private String day="Saturday",start="Ajmeri Gate",end="LNMIIT";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_show_set_reminder, container, false);

        ArrayList<BusInfo> mondayList=new ArrayList<BusInfo>();
        mondayList.add(new BusInfo("7:00 AM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("1:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("5:00 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("8:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("11:00 AM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("3:05 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("6:15 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("8:05 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("6:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("7:00 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("7:15 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
        mondayList.add(new BusInfo("9:45 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));

        mondayList.add(new BusInfo("7:00 AM","Chomu Puliya","LNMIIT","Government Bus"));
        mondayList.add(new BusInfo("11:15 AM","Chomu Puliya","LNMIIT","Government Bus"));
        mondayList.add(new BusInfo("3:30 PM","Chomu Puliya","LNMIIT","Government Bus"));
        mondayList.add(new BusInfo("9:15 AM","LNMIIT","Chomu Puliya","Government Bus"));
        mondayList.add(new BusInfo("1:30 PM","LNMIIT","Chomu Puliya","Government Bus"));
        mondayList.add(new BusInfo("5:30 PM","LNMIIT","Chomu Puliya","Government Bus"));
        mondayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","Government Bus"));
        mondayList.add(new BusInfo("12:00 PM","Ajmeri Gate","LNMIIT","Government Bus"));
        mondayList.add(new BusInfo("4:00 PM","Ajmeri Gate","LNMIIT","Government Bus"));
        mondayList.add(new BusInfo("8:45 AM","LNMIIT","Nai Ki Thadi","Government Bus"));
        mondayList.add(new BusInfo("12:45 PM","LNMIIT","Nai Ki Thadi","Government Bus"));
        mondayList.add(new BusInfo("4:45 PM","LNMIIT","Nai Ki Thadi","Government Bus"));
        mondayList.add(new BusInfo("9:10 AM","Nai Ki Thadi","LNMIIT","Government Bus"));
        mondayList.add(new BusInfo("1:25 PM","Nai Ki Thadi","LNMIIT","Government Bus"));
        mondayList.add(new BusInfo("5:20 PM","Nai Ki Thadi","LNMIIT","Government Bus"));


        ArrayList<BusInfo> sundayList=new ArrayList<BusInfo>();

        sundayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("1:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("3:00 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("7:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("10:00 AM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("12:00 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("6:15 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("8:05 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("3:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("4:15 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("6:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("7:00 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("4:30 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("5:30 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("7:15 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
        sundayList.add(new BusInfo("9:45 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));

        ArrayList<BusInfo> saturdayList=new ArrayList<BusInfo>();
        saturdayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("1:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("3:00 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("7:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("9:30 PM","Ajmeri Gate","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("10:00 AM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("12:00 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("6:15 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("8:05 PM","LNMIIT","Ajmeri Gate","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("3:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("4:15 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("6:30 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("7:00 PM","LNMIIT","Raja Park","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("4:30 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("5:30 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("7:15 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));
        saturdayList.add(new BusInfo("9:45 PM","Raja Park","LNMIIT","LNMIIT Bus Service"));

        saturdayList.add(new BusInfo("7:00 AM","Chomu Puliya","LNMIIT","Government Bus"));
        saturdayList.add(new BusInfo("11:15 AM","Chomu Puliya","LNMIIT","Government Bus"));
        saturdayList.add(new BusInfo("3:30 PM","Chomu Puliya","LNMIIT","Government Bus"));
        saturdayList.add(new BusInfo("9:15 AM","LNMIIT","Chomu Puliya","Government Bus"));
        saturdayList.add(new BusInfo("1:30 PM","LNMIIT","Chomu Puliya","Government Bus"));
        saturdayList.add(new BusInfo("5:30 PM","LNMIIT","Chomu Puliya","Government Bus"));
        saturdayList.add(new BusInfo("8:00 AM","Ajmeri Gate","LNMIIT","Government Bus"));
        saturdayList.add(new BusInfo("12:00 PM","Ajmeri Gate","LNMIIT","Government Bus"));
        saturdayList.add(new BusInfo("4:00 PM","Ajmeri Gate","LNMIIT","Government Bus"));
        saturdayList.add(new BusInfo("8:45 AM","LNMIIT","Nai Ki Thadi","Government Bus"));
        saturdayList.add(new BusInfo("12:45 PM","LNMIIT","Nai Ki Thadi","Government Bus"));
        saturdayList.add(new BusInfo("4:45 PM","LNMIIT","Nai Ki Thadi","Government Bus"));
        saturdayList.add(new BusInfo("9:10 AM","Nai Ki Thadi","LNMIIT","Government Bus"));
        saturdayList.add(new BusInfo("1:25 PM","Nai Ki Thadi","LNMIIT","Government Bus"));
        saturdayList.add(new BusInfo("5:20 PM","Nai Ki Thadi","LNMIIT","Government Bus"));


        ArrayList<BusInfo> selectedList=new ArrayList<BusInfo>();
        if(day=="Monday"||day=="Tuesday"||day=="Wednesday"||day=="Thursday"||day=="Friday")
        {
            for(int i=0;i<29;i++)
                if(mondayList.get(i).getStart()==start&&mondayList.get(i).getEnd()==end)
                    selectedList.add(mondayList.get(i));
        }
        else if (day=="Sunday")
        {
            for(int i=0;i<18;i++)
                if(sundayList.get(i).getStart()==start&&sundayList.get(i).getEnd()==end)
                    selectedList.add(sundayList.get(i));
        }
        else
        {
            for(int i=0;i<33;i++)
                if(saturdayList.get(i).getStart()==start&&saturdayList.get(i).getEnd()==end)
                    selectedList.add(saturdayList.get(i));
        }

        BusInfoAdapter businfo1=new BusInfoAdapter(getContext(),selectedList);
        ListView list1=(ListView) v.findViewById(R.id.list);
        list1.setAdapter(businfo1);

        //selectedList.clear();


        setReminder=(Switch) v.findViewById(R.id.setReminder);
        notifyMe=(Switch) v.findViewById(R.id.notifyMe);
/*        setReminder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    Toast.makeText(getContext(),"On()",Toast.LENGTH_LONG).show();
                }
            }
        });
        notifyMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    Toast.makeText(getContext(),"On()",Toast.LENGTH_LONG).show();
                }
            }
        });*/

        return v;
    }

}
