package com.example.busspass;

public class TransactionInfo {

    private String orderid;
    private String date;
    private String time;
    private String amount;
    //private String ;


    public TransactionInfo(String date, String time, String amount) {
        this.date = date;
        this.time = time;
        this.amount = amount;

    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAmount() {
        return amount;
    }
}
