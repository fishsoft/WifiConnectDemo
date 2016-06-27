package com.example.testwifi;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	WifiAdmin wifiAdmin;
	private EditText mSsid, mPwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		wifiAdmin = new WifiAdmin(this);
		wifiAdmin.openWifi();
		Button button4 = (Button) findViewById(R.id.btn_connect);
		button4.setOnClickListener(this);
		mSsid = (EditText) findViewById(R.id.et_ssid);
		mPwd = (EditText) findViewById(R.id.et_pwd);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			MainActivity.this.finish();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.btn_connect:
			String ssid = mSsid.getText().toString().trim();
			String pwd = mPwd.getText().toString().trim();
			if (!TextUtils.isEmpty(ssid)) {
				if (!TextUtils.isEmpty(pwd)) {
					wifiAdmin.addNetwork(wifiAdmin.CreateWifiInfo(ssid, pwd, 3));
				} else {
					wifiAdmin.connectSpecificAP(ssid);
				}
			}
			break;
		default:
			break;
		}

	}

}
