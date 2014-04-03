package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class Email_Activity extends Activity {
	String to, content;
	EditText email_to, content_email;
	TextView tv_send, tv_cancle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		recive();
		setdata();
		tv_cancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void recive() {
		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			content = mBundle.getString("content");
			to = mBundle.getString("to");
		}
	}

	public void setdata() {
		email_to = (EditText) findViewById(R.id.email_to);
		content_email = (EditText) findViewById(R.id.email_content);
		tv_send = (TextView) findViewById(R.id.email_send);
		tv_cancle = (TextView) findViewById(R.id.email_cancle);
		email_to.setText(to);
		content_email.setText(content);
	}

}
