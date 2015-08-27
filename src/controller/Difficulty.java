package controller;

import com.example.homework.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Difficulty extends Activity {
	private Button btnNoob;
	private Button btnCasual;
	private Button btnGeek;
	private Button btnNoLife;
	private Button btnBack;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// Link to layout difficulty.xml
		setContentView(R.layout.difficulty); 
		
		// Button Noob
		btnNoob=(Button)findViewById(R.id.buttonNoob);
		btnNoob.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent startGame = new Intent(Difficulty.this, Game.class);
				startGame.putExtra("difficultyLevel","0");
				startActivity(startGame);
			}
		});
		
		// Button Casual
		btnCasual=(Button)findViewById(R.id.buttonCasual);
		btnCasual.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent startGame = new Intent(Difficulty.this, Game.class);
				startGame.putExtra("difficultyLevel","1");
				startActivity(startGame);
			}
		});
		
		// Button Geek
		btnGeek=(Button)findViewById(R.id.buttonGeek);
		btnGeek.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent startGame = new Intent(Difficulty.this, Game.class);
				startGame.putExtra("difficultyLevel","2");
				startActivity(startGame);
			}
		});
		
		// Button No-Life
		btnNoLife=(Button)findViewById(R.id.buttonNoLife);
		btnNoLife.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent startGame = new Intent(Difficulty.this, Game.class);
				startGame.putExtra("difficultyLevel","3");
				startActivity(startGame);
			}
		});
		
		// Button Back
		btnBack=(Button)findViewById(R.id.buttonBack);
		btnBack.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent startBack = new Intent(Difficulty.this, MainActivity.class);
				startActivity(startBack);
			}
		});
	}
}