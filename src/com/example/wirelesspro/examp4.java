package com.example.wirelesspro;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class examp4 extends Activity {
	WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examp1_2);
  mWebView = (WebView) findViewById(R.id.exampl2);
        
        
        mWebView.loadUrl("file:///android_asset/introwlan.html");
        mWebView.getSettings().setBuiltInZoomControls(true);
    }
}