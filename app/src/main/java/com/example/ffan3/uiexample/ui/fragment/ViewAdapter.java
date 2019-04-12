package com.example.ffan3.uiexample.ui.fragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ffan3.uiexample.R;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter {
    private Activity mActivity;
    private List<Logs> mLogs;
    private boolean isChangeType;

    public ViewAdapter(Activity activity, List<Logs> logs) {
        mActivity = activity;
        mLogs = logs;
    }

    public void isJudgeType(boolean judgeType){
        this.isChangeType = judgeType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (isChangeType){
            if (i == 1){
                view = LayoutInflater.from(mActivity).inflate(R.layout.item_one);
                return new MissedHolder(view);
            }else if (i == 2){
                view = LayoutInflater.from(mActivity).inflate(R.layout.item_two);
                return new LatestHolder(view);
            }
        }else {
            view = LayoutInflater.from(mActivity).inflate(R.layout.item_two);
            return new LatestHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mLogs.get(position).getType() == 1){
            return 1;
        }else {
            return 2;
        }
    }

    class MissedHolder extends RecyclerView.ViewHolder {
        TextView name;
        public MissedHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class LatestHolder extends RecyclerView.ViewHolder {
        TextView name;

        public LatestHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
