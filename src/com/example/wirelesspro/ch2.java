package com.example.wirelesspro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ch2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch2);
        
        Button b1=(Button)findViewById(R.id.b21);
        Button b2=(Button)findViewById(R.id.b22);
        Button b3=(Button)findViewById(R.id.b23);
        b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp2.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
    
        
        b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp2_2.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp2_3.class);
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