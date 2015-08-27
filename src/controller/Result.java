package controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.homework.R;

public class Result extends Activity {
	
	private TextView txtScore, txtTime, txtScorePoint;
	private int score;
	private Button btnMenu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// Link to layout result.xml
		setContentView(R.layout.result);
		
		// Gets the previously created intent
		Intent startResult = getIntent();
		
		// Will return Extra values
		String userScore = startResult.getStringExtra("userScore");
		String timeSecScore = startResult.getStringExtra("secondsScore");
		String timeMinScore = startResult.getStringExtra("minutesScore");
		
		// Score Calculation
		txtScore = (TextView) findViewById(R.id.textScore); 
		txtScore.setText(userScore+"/20");
		txtTime = (TextView) findViewById(R.id.textTimeScore); 
		txtTime.setText(timeMinScore+" minutes "+timeSecScore+" seconds ");
		score = ((10000-(((Integer.parseInt(timeMinScore))*60)+(Integer.parseInt(timeSecScore))))*(Integer.parseInt(userScore)));
		txtScorePoint = (TextView) findViewById(R.id.textScorePoint); 
		if ((Integer.parseInt(timeMinScore)) <= 166)
		{
			txtScorePoint.setText((Integer.toString(score))+" points");
		}
		else
		{
			txtScorePoint.setText("You took to much time dude\ntry again!");
		}
		
		// Back Button
		btnMenu = (Button) findViewById(R.id.buttonMenu); 
		btnMenu.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent startMenu = new Intent(Result.this, MainActivity.class);
				startActivity(startMenu);
			}
		});
	}
}
