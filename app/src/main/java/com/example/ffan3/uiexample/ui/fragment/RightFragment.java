package com.example.ffan3.uiexample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ffan3.uiexample.R;

public class RightFragment extends Fragment {
    private RecyclerView mRightList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =LayoutInflater.from(getActivity()).inflate(R.layout.fragment_right,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRightList = view.findViewById(R.id.rl_right);
        mRightList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mRightList.setAdapter(new );
    }
}
