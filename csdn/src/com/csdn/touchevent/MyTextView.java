package com.csdn.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("d", "【农民】任务<" + Util.actionToString(ev.getAction()) + "> : 需要分派，我下面没人了，怎么办？自己干吧");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean bo = true;
        Log.d("d", "【农民】任务<" + Util.actionToString(ev.getAction()) + "> : 自己动手，埋头苦干。能解决？" + bo);
        return bo;
    }
}
