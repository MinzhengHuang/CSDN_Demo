package com.example.androidverification;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	VerificationActivity ver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText text = (EditText) findViewById(R.id.editText1);
		Button button1 = (Button) findViewById(R.id.button1);
		ver = new VerificationActivity();

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String textvalue = text.getText().toString().trim();
				Boolean flag = ver.checkChinese(textvalue);

				if (!flag)
					Toast.makeText(MainActivity.this, "«Î ‰»Î÷–Œƒ!", 2000).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
