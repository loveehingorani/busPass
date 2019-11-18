package com.example.busspass;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

public class BusTimeList extends ArrayList<BusInfo> {
    ArrayList<BusInfo> mondayList = new ArrayList<BusInfo>();
    ArrayList<BusInfo> sundayList = new ArrayList<BusInfo>();
    ArrayList<BusInfo> saturdayList = new ArrayList<BusInfo>();



    public BusTimeList() {



//        mondayList.add(new BusInfo("7:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("8:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("1:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("5:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("8:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("9:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("11:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("3:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("6:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("8:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("6:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("7:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("7:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//        mondayList.add(new BusInfo("9:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//
//        mondayList.add(new BusInfo("7:00 AM", "Chomu Puliya", "LNMIIT", "Government Bus"));
//        mondayList.add(new BusInfo("11:15 AM", "Chomu Puliya", "LNMIIT", "Government Bus"));
//        mondayList.add(new BusInfo("3:30 PM", "Chomu Puliya", "LNMIIT", "Government Bus"));
//        mondayList.add(new BusInfo("9:15 AM", "LNMIIT", "Chomu Puliya", "Government Bus"));
//        mondayList.add(new BusInfo("1:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus"));
//        mondayList.add(new BusInfo("5:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus"));
//        mondayList.add(new BusInfo("8:00 AM", "Ajmeri Gate", "LNMIIT", "Government Bus"));
//        mondayList.add(new BusInfo("12:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus"));
//        mondayList.add(new BusInfo("4:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus"));
//        mondayList.add(new BusInfo("8:45 AM", "LNMIIT", "Nai Ki Thadi", "Government Bus"));
//        mondayList.add(new BusInfo("12:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus"));
//        mondayList.add(new BusInfo("4:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus"));
//        mondayList.add(new BusInfo("9:10 AM", "Nai Ki Thadi", "LNMIIT", "Government Bus"));
//        mondayList.add(new BusInfo("1:25 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus"));
//        mondayList.add(new BusInfo("5:20 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus"));
//
//
//        sundayList.add(new BusInfo("8:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("1:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("3:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("7:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("9:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("9:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("10:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("12:00 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("6:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("8:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("3:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("4:15 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("6:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("7:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("4:30 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("5:30 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("7:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//        sundayList.add(new BusInfo("9:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//
//
//        saturdayList.add(new BusInfo("8:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("1:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("3:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("7:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("9:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("9:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("10:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("12:00 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("6:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("8:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("3:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("4:15 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("6:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("7:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("4:30 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("5:30 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("7:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//        saturdayList.add(new BusInfo("9:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service"));
//
//        saturdayList.add(new BusInfo("7:00 AM", "Chomu Puliya", "LNMIIT", "Government Bus"));
//        saturdayList.add(new BusInfo("11:15 AM", "Chomu Puliya", "LNMIIT", "Government Bus"));
//        saturdayList.add(new BusInfo("3:30 PM", "Chomu Puliya", "LNMIIT", "Government Bus"));
//        saturdayList.add(new BusInfo("9:15 AM", "LNMIIT", "Chomu Puliya", "Government Bus"));
//        saturdayList.add(new BusInfo("1:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus"));
//        saturdayList.add(new BusInfo("5:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus"));
//        saturdayList.add(new BusInfo("8:00 AM", "Ajmeri Gate", "LNMIIT", "Government Bus"));
//        saturdayList.add(new BusInfo("12:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus"));
//        saturdayList.add(new BusInfo("4:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus"));
//        saturdayList.add(new BusInfo("8:45 AM", "LNMIIT", "Nai Ki Thadi", "Government Bus"));
//        saturdayList.add(new BusInfo("12:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus"));
//        saturdayList.add(new BusInfo("4:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus"));
//        saturdayList.add(new BusInfo("9:10 AM", "Nai Ki Thadi", "LNMIIT", "Government Bus"));
//        saturdayList.add(new BusInfo("1:25 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus"));
//        saturdayList.add(new BusInfo("5:20 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus"));
    }
    public ArrayList<BusInfo> getMondayList(){ return mondayList;}
    public ArrayList<BusInfo> getSundayList(){ return sundayList;}
    public ArrayList<BusInfo> getSaturdayList(){ return saturdayList;}
}
