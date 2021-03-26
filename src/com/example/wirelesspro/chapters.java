package com.example.wirelesspro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class chapters extends Activity {
Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapters);
        
        b1=(Button)findViewById(R.id.ch1);
        b2=(Button)findViewById(R.id.ch2);
        b3=(Button)findViewById(R.id.ch3);
        b4=(Button)findViewById(R.id.ch4);
        b5=(Button)findViewById(R.id.ch5);
        
        b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),ch1.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),ch2.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),ch3.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),ch4.class);
				startActivity(second);
				
			}
        });
        b5.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent second =new Intent(getApplicationContext (),ch5.class);
				startActivity(second);	
			}
        	
        	
        	
        });
        
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_wireless, menu);
        return true;
    }
    
}