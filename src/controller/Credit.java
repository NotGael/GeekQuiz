package controller;

import com.example.homework.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import model.CreditModel;

public class Credit extends Activity {
	private Button btnBack;
	private TextView txtCredit;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// Link to layout credit.xml
		setContentView(R.layout.credit); 
		
		// Text Credit
		txtCredit = (TextView)findViewById(R.id.textCredit);		
		txtCredit.setText(CreditModel.getCreditString());
		
		// Button Back
		btnBack=(Button)findViewById(R.id.buttonBack);
		btnBack.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent startBack = new Intent(Credit.this, MainActivity.class);
				startActivity(startBack);
				// Go back to the main screen
			}
		});
	}
}