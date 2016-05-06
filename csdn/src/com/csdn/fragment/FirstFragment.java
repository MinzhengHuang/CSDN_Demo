package com.csdn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.csdn.R;
import com.csdn.activity.BadgeViewActivity;
import com.csdn.activity.HorizontalListViewActivity;
import com.csdn.activity.IndexableListViewActivity;
import com.csdn.activity.RiseNumberActivity;
import com.csdn.activity.TimeLineActivity;
import com.csdn.pattern.UnlockGesturePasswordActivity;
import com.csdn.touchevent.TouchEventActivity;

public class FirstFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        view.findViewById(R.id.btn_TouchEvent).setOnClickListener(this);
        view.findViewById(R.id.btn_RiseNumber).setOnClickListener(this);
        view.findViewById(R.id.btn_TimeLine).setOnClickListener(this);
        view.findViewById(R.id.btn_BadgeView).setOnClickListener(this);
        view.findViewById(R.id.btn_HorizontalListView).setOnClickListener(this);
        view.findViewById(R.id.btn_IndexableListView).setOnClickListener(this);
        view.findViewById(R.id.btn_LockPatternView).setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_TouchEvent:
                intent = new Intent(getActivity(), TouchEventActivity.class);
                break;
            case R.id.btn_RiseNumber:
                intent = new Intent(getActivity(), RiseNumberActivity.class);
                break;
            case R.id.btn_TimeLine:
                intent = new Intent(getActivity(), TimeLineActivity.class);
                break;
            case R.id.btn_BadgeView:
                intent = new Intent(getActivity(), BadgeViewActivity.class);
                break;
            case R.id.btn_HorizontalListView:
                intent = new Intent(getActivity(), HorizontalListViewActivity.class);
                break;
            case R.id.btn_IndexableListView:
                intent = new Intent(getActivity(), IndexableListViewActivity.class);
                break;
            case R.id.btn_LockPatternView:
                intent = new Intent(getActivity(), UnlockGesturePasswordActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
