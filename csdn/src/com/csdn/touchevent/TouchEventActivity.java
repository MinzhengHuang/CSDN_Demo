package com.csdn.touchevent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.csdn.R;

/**
 * http://blog.csdn.net/morgan_xww/article/details/9372285
 *
 * Android TouchEvent事件传递机制
 *
 * 跟touch事件相关的3个方法：
 * public boolean dispatchTouchEvent(MotionEvent ev);    //用来分派event
 * public boolean onInterceptTouchEvent(MotionEvent ev); //用来拦截event
 * public boolean onTouchEvent(MotionEvent ev);          //用来处理event
 *
 * 总统 --> MyActivity
 * 省长 --> MyFrameLayout
 * 市长 --> MyLinearLayout
 * 农民 --> MyTextView
 *
 * （1）这一系列的传递流程都是dispatchTouchEvent()方法来控制的，如果不人为地干预，事件将由上自下依次传递（因为默认是返回false不会拦截的），
 * 传递到最底层的View，就由它的onTouchEvent()方法来处理事件，若处理成功返回true，若处理失败返回false，事件依次向上传递，每个View都调用自己
 * 的onTouchEvent()方法来处理事件，若处理成功就终止传递，若处理失败就继续向上传递。
 * （2）经过人为的干预，若在向下传递的过程中被拦截了，即onInterceptTouchEvent()方法返回true，则事件将停止向下传递，直接由当前的onTouchEvent()
 * 方法来处理，若处理成功则OK，若处理不成功，则事件会向上传递。
 * （3）另外，dispatchTouchEvent()方法中还有“记忆”的功能，如果第一次事件向下传递到某View，它把事件继续传递交给它的子View，它会记录该事件是否被
 * 它下面的View给处理成功了，（怎么能知道呢？如果该事件会再次被向上传递到我这里来由我的onTouchEvent()来处理，那就说明下面的View都没能成功处理该
 * 事件）；当第二次事件向下传递到该View，该View的dispatchTouchEvent()方法机会判断，若上次的事件由下面的view成功处理了，那么这次的事件就继续交
 * 给下面的来处理，若上次的事件没有被下面的处理成功，那么这次的事件就不会向下传递了，该View直接调用自己的onTouchEvent()方法来处理该事件。
 * （4）“记忆”功能的信息只在一系列事件完成之前有效，如从ACTION_DOWN事件开始，直到后续事件ACTION_MOVE，ACTION_UP结束后，“记忆”的信息就会清除。
 * 也就是说如果某View处理ACTION_DOWN事件失败了（onTouchEvent()返回false），那么后续的ACTION_MOVE,ACTION_UP等事件就不会再传递到该View了，由
 * 其父View自己来处理。在下一次发生ACTION_DOWN事件的时候，还是会传递到该View的.
 */
public class TouchEventActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchevent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("d", "【总统】任务<" + Util.actionToString(ev.getAction()) + "> : 需要分派");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean bo = false;
        Log.d("d", "【总统】任务<" + Util.actionToString(ev.getAction()) + "> : 下面都解决不了，下次再也不能靠你们了，哼⋯只能自己尝试一下啦。能解决？" + bo);
        return bo;
    }
}