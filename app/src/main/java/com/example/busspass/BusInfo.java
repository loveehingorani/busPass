package com.example.busspass;

public class BusInfo {


    private String id;
    private String day;
    private String time;
    private String start;
    private String end;
    private String bus;
    private Boolean setReminder;
    private Boolean notifyMe;

    public BusInfo(String id, String time, String start, String end,String bus,String day,Boolean setReminder,Boolean notifyMe) {
        this.id=id;
        this.time= time;
        this.start =start;
        this.end = end;
        this.bus = bus;
        this.day=day;
        this.setReminder=setReminder;
        this.notifyMe=notifyMe;
    }

    public String getId() {
        return id;
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
    public String getDay() {
        return day;
    }
    public Boolean getSetReminder() {return setReminder;}
    public Boolean getNotifyMe() {return notifyMe;}

}
