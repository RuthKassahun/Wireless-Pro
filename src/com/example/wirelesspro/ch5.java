package com.example.wirelesspro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ch5 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch5);
        
        Button b1=(Button)findViewById(R.id.b51);
        Button b2=(Button)findViewById(R.id.b52);
        Button b3=(Button)findViewById(R.id.b53);
        Button b4=(Button)findViewById(R.id.b54);
        Button b5=(Button)findViewById(R.id.b55);
        b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp5.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
    
        
        b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp5_2.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp5_3.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp5_4.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        b5.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),examp5_5.class);
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
