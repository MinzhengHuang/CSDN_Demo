package com.csdn.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.csdn.R;
import com.csdn.swipemenulistview.DifferentMenuActivity;
import com.csdn.swipemenulistview.SimpleActivity;

public class SwipeMenuListViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipemenu_listview);

	}
	
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.btn_simple:
			startActivity(new Intent(this, SimpleActivity.class));
			break;
		case R.id.btn_different:
			startActivity(new Intent(this, DifferentMenuActivity.class));
			break;
		}
	}
}
