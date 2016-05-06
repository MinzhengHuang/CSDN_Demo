package com.csdn.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.csdn.R;
import com.csdn.view.BadgeView;

/**
 * Created by huangminzheng on 16/5/6.
 */
public class BadgeViewActivity extends Activity implements View.OnClickListener {
    private BadgeView backgroundDrawableBadge;
    private BadgeView backgroundShapeBadge;
    private BadgeView backgroundDefaultBadge;
    private BadgeView counterBadge;
    private BadgeView gravityBadge;
    private BadgeView textStyleBadge;
    private BadgeView visibilityBadgeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badgeview);
        initView();
    }

    private void initView() {
        Button backgroundDefaultView = (Button) findViewById(R.id.backgroundDefault);
        backgroundDefaultBadge = new BadgeView(this);
        backgroundDefaultBadge.setBadgeCount(42);
        backgroundDefaultBadge.setTargetView(backgroundDefaultView);

        Button backgroundDrawableView = (Button) findViewById(R.id.backgroundDrawable);
        backgroundDrawableBadge = new BadgeView(this);
        backgroundDrawableBadge.setBadgeCount(88);
        backgroundDrawableBadge.setBackgroundResource(R.drawable.badge_blue);
        backgroundDrawableBadge.setTargetView(backgroundDrawableView);

        Button backgroundShapeView = (Button) findViewById(R.id.backgroundShape);
        backgroundShapeBadge = new BadgeView(this);
        backgroundShapeBadge.setBadgeCount(47);
        backgroundShapeBadge.setBackground(12, Color.parseColor("#9b2eef"));
        backgroundShapeBadge.setTargetView(backgroundShapeView);

        Button counterView = (Button) findViewById(R.id.counter);
        counterView.setOnClickListener(this);
        counterBadge = new BadgeView(this);
        counterBadge.setBadgeCount(-2);
        counterBadge.setTargetView(counterView);

        Button gravityView = (Button) findViewById(R.id.gravity);
        gravityView.setOnClickListener(this);
        gravityBadge = new BadgeView(this);
        gravityBadge.setBadgeGravity(Gravity.LEFT | Gravity.BOTTOM);
        gravityBadge.setBadgeCount(4);
        gravityBadge.setTargetView(gravityView);

        Button textStyleView = (Button) findViewById(R.id.textStyle);
        textStyleView.setOnClickListener(this);
        textStyleBadge = new BadgeView(this);
        textStyleBadge.setBadgeCount(18);
        textStyleBadge.setTargetView(textStyleView);
        textStyleBadge.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.ITALIC));
        textStyleBadge.setShadowLayer(2, -1, -1, Color.GREEN);

        Button visibilityView = (Button) findViewById(R.id.visibility);
        visibilityView.setOnClickListener(this);
        visibilityBadgeView = new BadgeView(this);
        visibilityBadgeView.setBadgeCount(1);
        visibilityBadgeView.setTargetView(visibilityView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.counter: {
                counterBadge.incrementBadgeCount(1);
                break;
            }

            case R.id.gravity: {
                gravityBadge.incrementBadgeCount(1);
                Log.d(getClass().getName(), String.valueOf(gravityBadge.getBadgeCount() % 9));
                if (gravityBadge.getBadgeCount() % 9 == 0) {
                    gravityBadge.setBadgeGravity(Gravity.LEFT | Gravity.TOP);
                } else if (gravityBadge.getBadgeCount() % 9 == 1) {
                    gravityBadge.setBadgeGravity(Gravity.RIGHT | Gravity.BOTTOM);
                } else if (gravityBadge.getBadgeCount() % 9 == 2) {
                    gravityBadge.setBadgeGravity(Gravity.LEFT | Gravity.BOTTOM);
                } else if (gravityBadge.getBadgeCount() % 9 == 3) {
                    gravityBadge.setBadgeGravity(Gravity.RIGHT | Gravity.TOP);
                } else if (gravityBadge.getBadgeCount() % 9 == 4) {
                    gravityBadge.setBadgeGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                } else if (gravityBadge.getBadgeCount() % 9 == 5) {
                    gravityBadge.setBadgeGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                } else if (gravityBadge.getBadgeCount() % 9 == 6) {
                    gravityBadge.setBadgeGravity(Gravity.CENTER);
                } else if (gravityBadge.getBadgeCount() % 9 == 7) {
                    gravityBadge.setBadgeGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
                } else if (gravityBadge.getBadgeCount() % 9 == 8) {
                    gravityBadge.setBadgeGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
                }
                break;
            }
            case R.id.visibility: {
                visibilityBadgeView.setVisibility(visibilityBadgeView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                break;
            }

            default:
                break;
        }
    }
}
