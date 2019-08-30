package com.example.keyaanpaymentvochers;

public class PaymentList {

    private String vocherno, date,time,amount,reciver_name;
    private int reciever_image;
    public PaymentList(String vocherno, String date, String time, String amount, String reciver_name, int reciever_image) {
        this.vocherno = vocherno;
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.reciver_name = reciver_name;
        this.reciever_image = reciever_image;
    }

    public String getVocherNo() {
        return vocherno;
    }
    public void setVocherno(String vocherno) {
        this.vocherno = vocherno;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getRecieved_Person() {
        return reciver_name;
    }
    public void setReciver_name(String reciver_name) {
        this.reciver_name = reciver_name;
    }
    public int getRecived_Person_Image() {
        return reciever_image;
    }
    public void setReciever_image(int reciever_image) {
        this.reciever_image = reciever_image;
    }
}
