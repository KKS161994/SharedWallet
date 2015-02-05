package in.silive.SharedWallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartNewWallet extends Activity{
	Button cae,sd,sr;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.startnew);
	Database db=new Database(this);
	db.open();
	db.delete();
	db.close();
	initialise();
	}
	private void initialise() {
		cae=(Button)findViewById(R.id.cae);
		sd=(Button)findViewById(R.id.sd);
		sr=(Button)findViewById(R.id.sr);
		cae.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent openCounter;
				openCounter = new Intent(

				"com.example.bytepad.CREATE_AN_ENTRY");
			startActivity(openCounter);

			}
		});

sd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openCounter;
				openCounter = new Intent(

				"com.example.bytepad.SHOWDATABASE");
			startActivity(openCounter);

			}
		});


		sr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("Share Result","Shared Result Clicked");
				Intent openCounter;
				openCounter = new Intent(

				"com.example.bytepad.SHOWRESULT");
			startActivity(openCounter);
					
			}
		});
	}
	
}
