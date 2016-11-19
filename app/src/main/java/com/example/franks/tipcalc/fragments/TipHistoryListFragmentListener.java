package com.example.franks.tipcalc.fragments;

import com.example.franks.tipcalc.entity.TipRecord;


public interface TipHistoryListFragmentListener {
    void initList();
    void addToList(TipRecord record);
    void clearList();
}
