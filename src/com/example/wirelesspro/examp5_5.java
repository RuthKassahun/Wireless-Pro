package com.example.wirelesspro;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class examp5_5 extends Activity {
	WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examp);
  mWebView = (WebView) findViewById(R.id.exampl1);
        
        
        mWebView.loadUrl("file:///android_asset/securing WLAN.html");
        mWebView.getSettings().setBuiltInZoomControls(true);
    }
}