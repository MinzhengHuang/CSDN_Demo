package com.csdn.touchevent;

import android.view.MotionEvent;

public class Util {
    public static String actionToString(int action) {
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";
            case MotionEvent.ACTION_OUTSIDE:
                return "ACTION_OUTSIDE";
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";
        }
        return "";
    }
}
