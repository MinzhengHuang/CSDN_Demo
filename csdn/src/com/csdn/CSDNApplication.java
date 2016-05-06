package com.csdn;

import android.app.Application;

import com.csdn.utils.LockPatternUtils;

/**
 * Created by huangminzheng on 15/11/26.
 */
public class CSDNApplication extends Application {

    private static CSDNApplication mInstance;
    private LockPatternUtils mLockPatternUtils;

    public static CSDNApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mLockPatternUtils = new LockPatternUtils(this);
    }

    public LockPatternUtils getLockPatternUtils() {
        return mLockPatternUtils;
    }

}
