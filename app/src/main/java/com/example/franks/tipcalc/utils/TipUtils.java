package com.example.franks.tipcalc.utils;

import java.text.SimpleDateFormat;

import com.example.franks.tipcalc.entity.TipRecord;

public class TipUtils {
    public static double getTip(TipRecord tipRecord) {
        return tipRecord.getBill() * (tipRecord.getTipPercentage()/100d);
    }

    public static String getDateFormated(TipRecord tipRecord) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd, yyyy HH:mm");
        return simpleDateFormat.format(tipRecord.getTimestamp());
    }
}