package com.example.wirelesspro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ch4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch4);
        
        
        Button b1=(Button)findViewById(R.id.b41);
        Button b2=(Button)findViewById(R.id.b42);
        Button b3=(Button)findViewById(R.id.b43);
        Button b4=(Button)findViewById(R.id.b44);
        Button b5=(Button)findViewById(R.id.b45);
        b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp4.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
    
        
        b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp4_2.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp4_3.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp4_4.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b5.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp4_5.class);
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