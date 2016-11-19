package com.example.franks.tipcalc.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.franks.tipcalc.R;
import com.example.franks.tipcalc.activities.activity_detail;
import com.example.franks.tipcalc.adapters.OnItemClickListener;
import com.example.franks.tipcalc.adapters.TipAdapter;
import com.example.franks.tipcalc.entity.TipRecord;
import com.example.franks.tipcalc.utils.TipUtils;

public class TipHistoryListFragment extends Fragment implements TipHistoryListFragmentListener,OnItemClickListener {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    TipAdapter adapter;
    public TipHistoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tip_history_list, container, false);
        ButterKnife.bind(this,view);
        initAdapter();
        initRecyclerView();
        return view;
    }


    private void initAdapter() {
        if(adapter==null){
            adapter =new TipAdapter(getActivity().getApplicationContext(),this);
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initList() {
        adapter.init();
    }

    @Override
    public void addToList(TipRecord record) {
        adapter.add(record);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }

    @Override
    public void onItemClick(TipRecord tipRecord) {
        Intent intent = new Intent(getActivity(),activity_detail.class);
        intent.putExtra(activity_detail.TIP_KEY, TipUtils.getTip(tipRecord) );
        intent.putExtra(activity_detail.BILL_TOTAL_KEY, tipRecord.getBill());
        intent.putExtra(activity_detail.DATE_KEY, TipUtils.getDateFormated(tipRecord) );

        startActivity(intent);
    }
}
