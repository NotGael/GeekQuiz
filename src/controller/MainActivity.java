package controller;

import com.example.homework.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnPlay;
	private Button btnCredit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// Link to layout activity_main.xml
		setContentView(R.layout.activity_main);
		
		// Button Play
		btnPlay = (Button)findViewById(R.id.buttonPlay);
		btnPlay.setOnClickListener ( new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent startDifficulty = new Intent(MainActivity.this, Difficulty.class);
				startActivity(startDifficulty);
			}
		});
		
		// Button Credit
		btnCredit = (Button)findViewById(R.id.buttonCredit);
		btnCredit.setOnClickListener ( new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent startCredit = new Intent(MainActivity.this, Credit.class);
				startActivity(startCredit);
			}
		});
	}
}