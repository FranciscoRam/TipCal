package com.example.franks.tipcalc.fragments;

import com.example.franks.tipcalc.models.TipRecord;


public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}
