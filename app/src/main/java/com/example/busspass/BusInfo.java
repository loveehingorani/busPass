package com.example.busspass;

public class BusInfo {

    private String time;
    private String start;
    private String end;
    private String bus;
    private boolean setReminder;
    private boolean notifyMe;

    public BusInfo(String time, String start, String end,String bus) {
        this.time= time;
        this.start =start;
        this.end = end;
        this.bus = bus;
    }

    public String getTime() {
        return time;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
    public String getBus() {
        return bus;
    }
    public boolean getSetReminder() {return setReminder;}
    public boolean getNotifyMe() {return notifyMe;}

}
