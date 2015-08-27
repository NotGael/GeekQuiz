package controller;

import model.GameModel;
import com.example.homework.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Window;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends Activity {
	
	// Variable
	private int qNumb = 0, userPoint = 0, difficulty, seconds, minutes, tapped = 0;
	private long startTime;
	private boolean booleanBonus = false;
	private Button btnQuit, btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4, btnValid;
	private TextView txtSelected, txtQuestion, txtDifficulty, txtPoint, timeLabel, timeLabel2, timeLabel3, txtBonus;
	private String selectedAnswer="0", difficultyLevel;
	private Timer t;
	private Handler handler, handler2;
	private Runnable runnable;
	private GestureDetector gestureDetector;
	
	// Gesture Detector
	OnGestureListener myGestureMethod = new OnGestureListener() {
		@Override
		public boolean onDown(MotionEvent e) {
			tapped++;
			if (tapped == 10) {
				txtBonus.setVisibility(View.VISIBLE);
				booleanBonus = true;
			}
			return true;
		}
		@Override
		public boolean onSingleTapUp(MotionEvent e){
			return false;
		}
		@Override
		public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
				float arg3) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void onLongPress(MotionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
				float arg3) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void onShowPress(MotionEvent arg0) {
			// TODO Auto-generated method stub
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// Link to layout game.xml
		setContentView(R.layout.game);
		
		// Gets the previously created intent
		Intent startGame = getIntent();
		
		// Will return Extra values
		difficultyLevel = startGame.getStringExtra("difficultyLevel");
		difficulty = Integer.parseInt(difficultyLevel);
		
		// Gesture Detector
		gestureDetector = new GestureDetector(this,myGestureMethod);

		// Gets the current system time
        startTime = System.currentTimeMillis();
        
        // Sets up some labels to store our times
        timeLabel = (TextView)findViewById(R.id.lblTime);
        timeLabel2 = (TextView)findViewById(R.id.lblTime2);
        timeLabel3 = (TextView)findViewById(R.id.lblTime3);
		timeLabel3.setVisibility(View.INVISIBLE);
		timeLabel.setVisibility(View.INVISIBLE);
		
		// Difficulty textField
		txtDifficulty = (TextView) findViewById(R.id.textDifficulty); 
		switch (difficulty) {
			case 0 : txtDifficulty.setText("Difficulty level is: NOOB");
			break;
			case 1 :txtDifficulty.setText("Difficulty level is: CASUAL");
			break;
			case 2 :txtDifficulty.setText("Difficulty level is: GEEK");
			break;
			case 3 :txtDifficulty.setText("Difficulty level is: NO-LIFE");
			break;
		}
		
		// Bonus textField
		txtBonus = (TextView) findViewById(R.id.textBonus);
		
		// Selected Answer textField
		txtSelected = (TextView) findViewById(R.id.textSelected);
		
		// Point textField
		txtPoint = (TextView) findViewById(R.id.textPoint);
		txtPoint.setText((Integer.toString(userPoint))+"/20");
		
		// Draw the question and the different answer available
		drawQuestion();
		
		// Quit Button
		btnQuit = (Button) findViewById(R.id.buttonQuit); 
		btnQuit.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent startQuit = new Intent(Game.this, MainActivity.class);
				startActivity(startQuit);
			}
		});	
		
		// Valid Button
		btnValid = (Button) findViewById(R.id.buttonValid);
		btnValid.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				validation();
			}
		});
		
		// Initializes the timer
        t = new Timer();
        //Schedules the timer to fire every 1 second
        t.schedule(new UpdateTimeTask(),0, 1000);
        
        
        // Creates a handler to deal wit the return from the timer
        handler = new Handler() {
            public void handleMessage(Message msg) {
            	//gets the string we set in the timer task (called time) and sets the text in our label
            	timeLabel.setText(msg.getData().getString("time"));
            }
         };
         
         // Creates a new handler
         handler2 = new Handler();
         // Creates a runner for the handler to execute
         runnable = new Runnable() {
             public void run() {
            	 // When the runnable is executed it runs our updateTime method
                 UpdateTime();
             }
         };
         // Gives out handler our runnable and tells it to run after 1000 milliseconds
         handler2.postDelayed(runnable, 1000);
    }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}
	
	// Our update time method
    // Gets the current time and compares this to the start time
    // Then creates a string based on the elapsed minutes and seconds
	private void UpdateTime(){
		// Sleeps the thread for 0.2 seconds
		// This simulates a long process happening here
		try {
			Thread.sleep(200);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	long millis = System.currentTimeMillis() - startTime;
    	int seconds = (int) (millis / 1000);	
    	int minutes = seconds / 60;
    	seconds = seconds % 60; 
    	timeLabel2.setText("Timer: "+minutes+":"+seconds);
    	handler2.postDelayed(runnable, 1000);
    }
	
    
    // Internal class only accessible within MainActivity
   	// Timer task class
    class UpdateTimeTask extends TimerTask {
    	// Executable code goes in the run method of our timerTask class
		public void run() {
			long millis = System.currentTimeMillis() - startTime;
			seconds = (int) (millis / 1000);
			minutes = seconds / 60;
			seconds = seconds % 60; 
			String timeString = minutes+":"+seconds;
			// Creates a message to send to our UI thread
			Message myMessage = new Message();
			// Creates the data for the message
			Bundle databundle = new Bundle();
			// Adds a string to the data bundle
			databundle.putString("time", "Timer Time :"+ timeString);
			myMessage.setData(databundle);
			// Sends the message to the handler
			handler.sendMessage(myMessage);
		}
    }	
	
    // Valid the question answer and give or remove point to the player
	public void validation () {
		if (selectedAnswer.equals(GameModel.getTableQuestion(qNumb,5)) || booleanBonus == true) {
			if (booleanBonus == true) {
				txtBonus.setVisibility(View.INVISIBLE);
				booleanBonus = false;
			}
			userPoint ++;
			txtPoint.setText((Integer.toString(userPoint))+"/20");
		}
		else
		{
			switch (difficulty) {
				case 1 : 
					if(userPoint>=1) {
						userPoint=userPoint-1;
					}
					else {
						userPoint=0;
					}
					break;
				case 2 :
					if(userPoint>=2) {
						userPoint=userPoint-2;
					}
					else {
						userPoint=0;
					}
					break;
				case 3 :
					if(userPoint>=3) {
						userPoint=userPoint-3;
					}
					else {
						userPoint=0;
					}
					break;
			}
			txtPoint.setText((Integer.toString(userPoint))+"/20");
		}
		qNumb++;
		if (qNumb == 20) {
			Intent startResult = new Intent(Game.this, Result.class);
			startResult.putExtra("userScore",Integer.toString(userPoint));
			startResult.putExtra("secondsScore",Integer.toString(seconds));
			startResult.putExtra("minutesScore",Integer.toString(minutes));
			startActivity(startResult);
		}
		else {
			drawQuestion();
		}
	}
	
	// Draw the next question and the different answers linked to this question
	public void drawQuestion () {
		txtSelected.setText("Please select an answer");
		
		// Question
		txtQuestion = (TextView) findViewById(R.id.textQuestion); 
		txtQuestion.setText("Question #"+(qNumb+1)+" :"+GameModel.getTableQuestion(qNumb,0));
		
		// Answer number 1
		btnAnswer1 = (Button) findViewById(R.id.buttonAnswer1); 
		btnAnswer1.setText(GameModel.getTableQuestion(qNumb,1));
		btnAnswer1.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				txtSelected.setText(GameModel.getTableQuestion(qNumb,1));
				selectedAnswer = "1";
			}
		});		
		
		// Answer number 2
		btnAnswer2 = (Button) findViewById(R.id.buttonAnswer2); 
		btnAnswer2.setText(GameModel.getTableQuestion(qNumb,2));
		btnAnswer2.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				txtSelected.setText(GameModel.getTableQuestion(qNumb,2));
				selectedAnswer = "2";
			}
		});
		
		// Answer number 3
		btnAnswer3 = (Button) findViewById(R.id.buttonAnswer3); 
		btnAnswer3.setText(GameModel.getTableQuestion(qNumb,3));
		btnAnswer3.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				txtSelected.setText(GameModel.getTableQuestion(qNumb,3));
				selectedAnswer = "3";
			}
		});
		
		// Answer number 4
		btnAnswer4 = (Button) findViewById(R.id.buttonAnswer4); 
		btnAnswer4.setText(GameModel.getTableQuestion(qNumb,4));
		btnAnswer4.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				txtSelected.setText(GameModel.getTableQuestion(qNumb,4));
				selectedAnswer = "4";
			}
		});
	}
}