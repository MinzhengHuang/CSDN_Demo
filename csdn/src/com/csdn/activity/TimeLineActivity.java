package com.csdn.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;

import com.csdn.R;
import com.csdn.adapter.StatusExpandAdapter;
import com.csdn.bean.ChildStatusEntity;
import com.csdn.bean.GroupStatusEntity;

import java.util.ArrayList;
import java.util.List;

public class TimeLineActivity extends Activity {

    private ExpandableListView melv;
    private StatusExpandAdapter statusAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        context = this;
        melv = (ExpandableListView) findViewById(R.id.elv_time);
        initExpandListView();
    }

    /**
     * 初始化可拓展列表
     */
    private void initExpandListView() {
        statusAdapter = new StatusExpandAdapter(context, getListData());
        melv.setAdapter(statusAdapter);
        melv.setGroupIndicator(null); // 去掉默认带的箭头
        melv.setSelection(0);// 设置默认选中项

        // 遍历所有group,将所有项设置成默认展开
        int groupCount = melv.getCount();
        for (int i = 0; i < groupCount; i++) {
            melv.expandGroup(i);
        }

        melv.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO Auto-generated method stub
                return true;
            }
        });
    }

    private List<GroupStatusEntity> getListData() {
        List<GroupStatusEntity> groupList;
        String[] strArray = new String[]{"10月22日", "10月23日", "10月25日"};
        String[][] childTimeArray = new String[][]{
                {"俯卧撑十次", "仰卧起坐二十次", "大喊我爱紫豪二十次", "每日赞紫豪一次"},
                {"亲，快快滴点赞哦~"}, {"没有赞的，赶紧去赞哦~"}};
        groupList = new ArrayList<GroupStatusEntity>();
        for (int i = 0; i < strArray.length; i++) {
            GroupStatusEntity groupStatusEntity = new GroupStatusEntity();
            groupStatusEntity.setGroupName(strArray[i]);

            List<ChildStatusEntity> childList = new ArrayList<ChildStatusEntity>();

            for (int j = 0; j < childTimeArray[i].length; j++) {
                ChildStatusEntity childStatusEntity = new ChildStatusEntity();
                childStatusEntity.setCompleteTime(childTimeArray[i][j]);
                childStatusEntity.setIsfinished(true);
                childList.add(childStatusEntity);
            }

            groupStatusEntity.setChildList(childList);
            groupList.add(groupStatusEntity);
        }
        return groupList;
    }
}