package com.example.wirelesspro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Wireless extends Activity {

	ImageButton ch,te,ref;
	private TextView textViewQuestion;
	private TextView textViewScore;
	private TextView textViewQuestionCount;
	private TextView textViewCountdown;
	private RadioGroup rbGroup;
	private RadioButton rb1;
	private RadioButton rb2;
	private RadioButton rb3;
	private Button buttonConfirmNext;
	
	
	//private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wireless);
        
        ch=(ImageButton)findViewById(R.id.ch);
        te=(ImageButton)findViewById(R.id.te);
        textViewQuestion=(TextView)findViewById(R.id.text_view_question);
        textViewScore=(TextView)findViewById(R.id.text_view_score);
        textViewQuestionCount=(TextView)findViewById(R.id.text_view_question_count);
        textViewCountdown=(TextView)findViewById(R.id.text_view_countdown);
        rbGroup=(RadioGroup)findViewById(R.id.radio_group);
        rb1=(RadioButton)findViewById(R.id.option1);
        rb2=(RadioButton)findViewById(R.id.option2);
        rb3=(RadioButton)findViewById(R.id.option3);
        buttonConfirmNext=(Button)findViewById(R.id.confirm);
        ref=(ImageButton)findViewById(R.id.ref);
        
        
        //QuizDbHelper dbHelper =new QuizDbHelper(this);
        //questionList=dbHelper.getAllQuestions();
     
        
        
        ch.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),chapters.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        ref.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				Intent second =new Intent(getApplicationContext (),Refrences.class);
				startActivity(second);
				
			}
        	
        	
        	
        });
        te.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				
				startQuiz();
				
			}
        	
        	
        	
        });
    }
        
    private void startQuiz(){
 	   
 	   Intent intent =new Intent (getApplicationContext (),MainActivity.class);
	    	startActivity(intent);
			
    }
        

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_wireless, menu);
        return true;
    }
    
}
