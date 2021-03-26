package com.example.wirelesspro;


import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressLint("NewApi") public class MainActivity extends Activity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    public static final String EXTRA_CATEGORY_ID = "extraCategoryID";
    public static final String EXTRA_CATEGORY_NAME = "extraCategoryName"; 
   
	protected static final int REQUEST_CODE_QUIZ = 1;
	
 
    private TextView textViewHighscore;
    private Spinner spinnerDifficulty;
    private Spinner spinnerCategory;
 
    private int highscore;
	
	
	
	ImageButton b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textViewHighscore = (TextView) findViewById(R.id.text_view_highscore);
      
        spinnerCategory=(Spinner)findViewById(R.id.spinner_difficulty);
     loadCategories();
        
        loadHighscore();
        
        b=(ImageButton)findViewById(R.id.start);
        
        b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				startQuiz();
				
			}
        	 
        	
        	
        });
    }
        
   
    private void startQuiz(){
    	
    	Category selectedCategory=(Category)spinnerCategory.getSelectedItem();
    	int categoryID=selectedCategory.getId();
    	String categoryName= selectedCategory.getName();
 	   
 	   Intent intent =new Intent (MainActivity.this,QuizActivity.class);
 	   intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
 	  intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
 	  startActivityForResult(intent,REQUEST_CODE_QUIZ);
			
    }
     
  
     
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
  
         if (requestCode == REQUEST_CODE_QUIZ) {
             if (resultCode == RESULT_OK) {
                 int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                 if (score > highscore) {
                     updateHighscore1(score);
                 }
             }
         }
     }
  private void loadCategories(){
	  	QuizDbHelper dbHelper=QuizDbHelper.getInstance(this);
	  List<Category> categories=dbHelper.getAllCategories();
	  	ArrayAdapter<Category> adpaterCategories = new ArrayAdapter<Category> (this,android.R.layout.simple_spinner_item,categories);
	  	adpaterCategories.setDropDownViewResource(android.R.layout.simple_spinner_item);
	  	spinnerCategory.setAdapter(adpaterCategories);
  }
     
     private void updateHighscore1(int highscoreNew){
    	 
    	 highscore=highscoreNew;
    	 textViewHighscore.setText("HighScore :"+ highscore); 
    	 SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
    	 SharedPreferences.Editor editor=prefs.edit();
    	 editor.putInt(KEY_HIGHSCORE, highscore);
    	 editor.apply();
     }
      
     
     private void loadHighscore() {
         SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
         highscore = prefs.getInt(KEY_HIGHSCORE, 0);
         textViewHighscore.setText("Highscore: " + highscore);
     }
  
     @SuppressLint("NewApi") private void updateHighscore(int highscoreNew) {
         highscore = highscoreNew;
         textViewHighscore.setText("Highscore: " + highscore);
  
         SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
         SharedPreferences.Editor editor = prefs.edit();
         editor.putInt(KEY_HIGHSCORE, highscore);
         editor.apply();
     }
 
     
 
    



    

    //@Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
    
}
