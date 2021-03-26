package com.example.wirelesspro;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class Refrences extends Activity  {

	WebView wview;
	ProgressBar pbar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        
        wview=(WebView)findViewById(R.id.web_id);
        pbar=(ProgressBar)findViewById(R.id.progress_id);
        
        wview.getSettings().setJavaScriptEnabled(true);
        wview.setWebChromeClient(new WebChromeClient(){
        	public boolean shouldOverrideUrlLoading(WebView view,String url){
        	return false;	
        		
        	}
        });
        
        wview.setWebChromeClient(new WebChromeClient(){
        	
        	public void onProgressChanged(WebView v,int progress){
        	
        	if(progress==100){
        		pbar.setVisibility(View.GONE);
        	}
        	else
        	{
        		pbar.setVisibility(View.VISIBLE);
        	}
        	}
        });
    
    wview.loadUrl("http://www.wirelesscommunication.nl/refrences.com");
    }

       
}

