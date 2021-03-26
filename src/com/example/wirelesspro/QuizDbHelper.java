package com.example.wirelesspro;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.wirelesspro.QuizContract.CategoriesTable;
import com.example.wirelesspro.QuizContract.QuestionsTable;
	  
	 
	public class QuizDbHelper extends SQLiteOpenHelper {
	    private static final String DATABASE_NAME = "MyAwesome.db";
	    private static final int DATABASE_VERSION = 1;
	 
	    private static QuizDbHelper instance;
	    
	    private SQLiteDatabase db;
	 
	    private QuizDbHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }
	 
	    public static synchronized QuizDbHelper getInstance(Context context) {
	        if (instance == null) {
	            instance = new QuizDbHelper(context.getApplicationContext());
	        }
	        return instance;
	    }
	 
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        this.db = db;
	 
	        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
	                CategoriesTable.TABLE_NAME + "( " +
	                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
	                CategoriesTable.COLUMN_NAME + " TEXT " +
	                ")";
	 
	        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
	                QuestionsTable.TABLE_NAME + " ( " +
	                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
	                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
	                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
	                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
	                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
	                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
	                //QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
	                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
	                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
	                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
	                ")";
	 
	        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
	        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
	        fillCategoriesTable();
	        fillQuestionsTable();
	    }
	 
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
	        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
	        onCreate(db);
	    }
	    	    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) @SuppressLint("NewApi")
	    	    @Override
	    	    public void onConfigure(SQLiteDatabase db) {
	    	        super.onConfigure(db);
	    	        db.setForeignKeyConstraintsEnabled(true);
	    	    }
	    
	    
	    private void fillCategoriesTable(){
	    
	    	Category c1 =new  Category ("chapter1");
	    	addCategory(c1);
	    	Category c2 =new  Category ("chapter2");
	    	addCategory(c2);
	    	Category c3 =new  Category ("chapter3");
	    	addCategory(c3);
	    	Category c4 =new  Category ("chapter4");
	    	addCategory(c4);
	    	Category c5 =new  Category ("chapter5");
	    	addCategory(c5);
	    	
	    	
	    }
	    
	    
	    private void addCategory(Category category) {
	        ContentValues cv = new ContentValues();
	        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
	        db.insert(CategoriesTable.TABLE_NAME, null, cv);
	    }
	 
	    private void fillQuestionsTable() {
	        Question q1 = new Question("Which of the following is a protocol used for cordless telephone system ?", "PACS", "ERMES", "IS-95", 1,Category.chapter1);
	        addQuestion(q1);
	        Question q2 = new Question("Which of the following is the drawback for cordless telephones?", "Wireless technology", "Limited coverage area", "Security", 2,Category.chapter1);
	        addQuestion(q2);
	        Question q3 = new Question("Which of the following is not a characteristic of cellular telephone system?", "Large frequency spectrum", "Large geographic area", "Accommodate large number of users", 1,Category.chapter1);
	        addQuestion(q3);
	        Question q4 = new Question("What is the responsibility of MSC in cellular telephone system?", "Connection of mobile to base stations", "Connection of mobile to PSTN", "Connection of base station to PSTN", 2,Category.chapter1);
	        addQuestion(q4);
	        Question q5 = new Question("Who has the responsibility of billing and system maintenance function in cellular system?", "Base Station", "PSTN", "MSC", 3,Category.chapter1);
	        addQuestion(q5);
	        Question q6 = new Question("What is the function of FVC (Forward Voice Channel)?", "Voice transmission from base station to mobiles", "Voice transmission from mobile to base station", "Initiating mobile calls", 1,Category.chapter1);
	        addQuestion(q6);
	        Question q7 = new Question("Which two channels are responsible for initiating mobile calls?", "FVC and FCC", "FVC and RVC", "FCC and RCC", 3,Category.chapter1);
	        addQuestion(q7);
	        Question q8 = new Question("Of the total channels present in the cellular system, what is the percentage of voice and control channels?", "95% voice channels, 5% control channels", "5% voice channels, 95% control channels", "50% voice channels, 50% control channels", 1,Category.chapter1);
	        addQuestion(q8);
	        Question q9 = new Question("The information sent by paging system is known as a:", "Page", "Message", "Line", 1,Category.chapter1);
	        addQuestion(q9);
	        Question q10 = new Question("Which type of message cannot be sent with the help of paging system?", "Alphanumeric message", "Video message", "Voice message", 2,Category.chapter1);
	        addQuestion(q10);
	        
	        Question q11 = new Question("Which of the following has no backward compatibility with 3G Cdma2000?", "IS-95", "GPRS", " IS-95A", 2,Category.chapter2);
	        addQuestion(q11);
	        Question q12 = new Question("Which of the following the first 3G CDMA air interface?", "Cdma2000 1xRTT", "IS-95B", " IS-95", 1,Category.chapter2);
	        addQuestion(q12);
	        Question q13 = new Question("Which of the following multiple access techniques are used by second generation cellular systems?", "FDMA/FDD and TDMA/FDD", "TDMA/FDD and CDMA/FDD", "FDMA/FDD and CDMA/FDD", 2,Category.chapter2);
	        addQuestion(q13);
	        Question q14 = new Question("Which one is not a TDMA standard of second generation networks?", "GSM", "IS-136", "AMPS", 3,Category.chapter2);
	        addQuestion(q14);
	        Question q15 = new Question("Which of the following is a CDMA standard of second generation network?", "IS-95", " IS-136", "ETACS", 1,Category.chapter2);
	        addQuestion(q15);
	        Question q16 = new Question("Popular 2G CDMA standard IS-95 is also known as ______", "CdmaOne", " CdmaTwo", "IS-136", 1,Category.chapter2);
	        addQuestion(q16);
	        Question q17 = new Question("How many voice channels are supported for each 30 KHz radio channel in IS-136?", "Eight", "Thirty", "Three", 3,Category.chapter2);
	        addQuestion(q17);
	        Question q18 = new Question("How many users are supported in IS-95 for each 1.25 MHz?", "Eight", "Sixty four", "Sixteen", 2,Category.chapter2);
	        addQuestion(q18);
	        Question q19 = new Question("Which modulation technique is used by GSM?", "GMSK", "BPSK", " QPSK", 1,Category.chapter2);
	        addQuestion(q19);
	        Question q20= new Question(" IS-95 uses which modulation technique?", " GMSK", " BPSK", " QAM", 2,Category.chapter2);
	        addQuestion(q20);
	        
	        
	        Question q21 = new Question("Which of the following has no backward compatibility with 3G Cdma2000?", "IS-95", "GPRS", " IS-95A", 2,Category.chapter3);
	        addQuestion(q21);
	        Question q22 = new Question("Which of the following the first 3G CDMA air interface?", "Cdma2000 1xRTT", "IS-95B", " IS-95", 1,Category.chapter3);
	        addQuestion(q22);
	        Question q23 = new Question("Which of the following multiple access techniques are used by second generation cellular systems?", "FDMA/FDD and TDMA/FDD", "TDMA/FDD and CDMA/FDD", "FDMA/FDD and CDMA/FDD", 2,Category.chapter3);
	        addQuestion(q23);
	        Question q24 = new Question("Which one is not a TDMA standard of second generation networks?", "GSM", "IS-136", "AMPS", 3,Category.chapter3);
	        addQuestion(q24);
	        Question q25 = new Question("Which of the following is a CDMA standard of second generation network?", "IS-95", " IS-136", "ETACS", 1,Category.chapter3);
	        addQuestion(q25);
	        Question q26 = new Question("Popular 2G CDMA standard IS-95 is also known as ______", "CdmaOne", " CdmaTwo", "IS-136", 1,Category.chapter3);
	        addQuestion(q26);
	        Question q27 = new Question("How many voice channels are supported for each 30 KHz radio channel in IS-136?", "Eight", "Thirty", "Three", 3,Category.chapter3);
	        addQuestion(q27);
	        Question q28 = new Question("How many users are supported in IS-95 for each 1.25 MHz?", "Eight", "Sixty four", "Sixteen", 2,Category.chapter3);
	        addQuestion(q28);
	        Question q29 = new Question("Which modulation technique is used by GSM?", "GMSK", "BPSK", " QPSK", 1,Category.chapter3);
	        addQuestion(q29);
	        Question q30= new Question(" IS-95 uses which modulation technique?", " GMSK", " BPSK", " QAM", 2,Category.chapter3);
	        addQuestion(q30);
	        
	        Question q31 = new Question(" What is the full form of WLAN?", "Wide Local Area Network", "Wireless Local Area Network", "Wireless Land Access Network", 2,Category.chapter4);
	        addQuestion(q31);
	        Question q32 = new Question("What is the name of 300 MHz of unlicensed spectrum allocated by FCC in ISM band?", "UNII", "Unlicensed PCS", "Millimetre wave", 1,Category.chapter4);
	        addQuestion(q32);
	        Question q33 = new Question("Which of the following specifies a set of media access control (MAC) and physical layer specifications for implementing WLANs?", "IEEE 802.16", " IEEE 802.3", "IEEE 802.11", 3,Category.chapter4);
	        addQuestion(q33);
	        Question q34 = new Question("Which of the following is not a standard of WLAN?", "HIPER-LAN", "HIPERLAN/2", "AMPS", 3,Category.chapter4);
	        addQuestion(q34);
	        Question q35 = new Question("Which of the following is the 802.11 High Rate Standard?", "IEEE 802.15", "IEEE 802.11b", "IEEE 802.11g", 2,Category.chapter4);
	        addQuestion(q35);
	        Question q36 = new Question("Which of the following WLAN standard has been named Wi-Fi?", "IEEE 802.6", "IEEE 802.15.4", "DSSS IEEE 802.11b", 3,Category.chapter4);
	        addQuestion(q36);
	        Question q37 = new Question("What is the range of asynchronous user data rates provided by HIPER-LAN?", "1-100 Mbps", "50-100 Mbps", "1-20 Mbps", 3,Category.chapter4);
	        addQuestion(q37);
	        Question q38 = new Question("Which of the following spread spectrum techniques were used in the original IEEE 802.11 standard?", "FHSS and DSSS", "THSS and FHSS", "THSS and DSSS", 1,Category.chapter4);
	        addQuestion(q38);
	        Question q39 = new Question("Which of the following is developing CCK-OFDM?", "IEEE 802.11a", " IEEE 802.11b", "IEEE 802.11g", 3,Category.chapter4);
	        addQuestion(q39);
	        Question q40 = new Question("HIPER-LAN stands for ______", "High Precision Radio Local Area Network", "High Performance Radio Local Area Network", "High Precision Radio Land Area Network", 2,Category.chapter4);
	        addQuestion(q40);
	        
	        Question q41 = new Question("_________ operates in the transport mode or the tunnel mode.", "IPSec ", " SSL ", "PGP ", 1,Category.chapter5);
	        addQuestion(q41);
	        Question q42 = new Question("______ provides either authentication or encryption, or both, for packets at the IP level.", "AH ", "ESP ", "PGP ", 2,Category.chapter5);
	        addQuestion(q42);
	        Question q43 = new Question("One security protocol for the e-mail system is _________.", "IPSec", "SSL", "PGP", 3,Category.chapter5);
	        addQuestion(q43);
	        Question q44 = new Question("Typically, ______ can receive application data from any application layer protocol, but the protocol is normally HTTP.", "SSL ", "TLS ", "both (a) and (b) ", 3,Category.chapter5);
	        addQuestion(q44);
	        Question q45 = new Question("IKE is a complex protocol based on ______ other protocols.", "two ", "three ", "four", 2,Category.chapter5);
	        addQuestion(q45);
	        Question q46 = new Question("IPSec defines two protocols: _______ and ________.", "AH; SSL ", "PGP; ESP ", "AH; ESP ", 3,Category.chapter5);
	        addQuestion(q46);
	        Question q47 = new Question("______ is the protocol designed to create security associations, both inbound and outbound.", "IKE ", "KDC ", "CA ", 1,Category.chapter5);
	        addQuestion(q47);
	        Question q48 = new Question("A _______network is used inside an organization.", "private ", " public ", "semi-private ", 1,Category.chapter5);
	        addQuestion(q48);
	        Question q49 = new Question("SSL provides _________.", "message integrity ", "confidentiality ", "all of the above ", 3,Category.chapter5);
	        addQuestion(q49);
	        Question q50 = new Question("The Internet authorities have reserved addresses for _______.", "intranets ", "internets ", "none of the above ", 3,Category.chapter5);
	        addQuestion(q50);
	       
	    }
	 
	    private void addQuestion(Question question) {
	        ContentValues cv = new ContentValues();
	        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
	        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
	        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
	        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
	        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
	        //cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
	        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
	        db.insert(QuestionsTable.TABLE_NAME, null, cv);
	    }
	    
	    
	    public List<Category> getAllCategories() {
	        List<Category> categoryList = new ArrayList<Category>();
	        db = getReadableDatabase();
	        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);
	 
	        if (c.moveToFirst()) {
	            do {
	                Category category = new Category();
	                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
	                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
	                categoryList.add(category);
	            } while (c.moveToNext());
	        }
	 
	        c.close();
	        return categoryList;
	    }
	    public ArrayList<Question> getAllQuestions() {
	        ArrayList<Question> questionList = new ArrayList<Question>();
	        db = getReadableDatabase();
	        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
	 
	        if (c.moveToFirst()) {
	            do {
	                Question question = new Question();
	                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
	                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
	                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
	                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
	                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
	                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
	                //question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
	                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
	                questionList.add(question);
	            } while (c.moveToNext());
	        }
	 
	        c.close();
	        return questionList;
	    }
	 
	    
	    public ArrayList<Question> getQuestions(int categoryID) {
	        ArrayList<Question> questionList = new ArrayList<Question>();
	        db = getReadableDatabase();
	 
	        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? " ;
	                
	        String[] selectionArgs = new String[]{String.valueOf(categoryID)};
	 
	        Cursor c = db.query(
	                QuestionsTable.TABLE_NAME,
	                null,
	                selection,
	                selectionArgs,
	                null,
	                null,
	                null
	        );
	 
	        if (c.moveToFirst()) {
	            do {
	                Question question = new Question();
	                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
	                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
	                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
	                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
	                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
	                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
	                //question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
	                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
	                questionList.add(question);
	            } while (c.moveToNext());
	        }
	 
	        c.close();
	        return questionList;
	    }
	}
	    
	    
	    
	
	
	

