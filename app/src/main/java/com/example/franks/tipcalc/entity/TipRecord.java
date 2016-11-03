package com.example.franks.tipcalc.entity;

import com.example.franks.tipcalc.db.TipsDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

@Table(database = TipsDatabase.class)

public class TipRecord {

    @PrimaryKey(autoincrement = true)
    private int id;

    @Column
    private double bill;

    @Column
    private int tipPercentage;

    @Column
    private Date timestamp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public int getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(int tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getTip(){
        return bill*(tipPercentage/100d);
    }
    public String getTipFormated(){
        double b = bill*(tipPercentage/100d);
        return String.valueOf(b);
    }
    public String getBillFormated(){

        return String.valueOf(bill);
    }
    public String getDateFormated(){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("MM dd, yyyy HH:mm");
        return simpleDateFormat.format(timestamp);
    }


}
