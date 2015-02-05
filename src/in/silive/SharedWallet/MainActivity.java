package in.silive.SharedWallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
Button btn1,btn2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.firstlayout);
	Log.d("Reached main Activity","Main Activity");
	initialise();
	}
	private void initialise() {
		// TODO Auto-generated method stub
	btn1=(Button)findViewById(R.id.button1);
	btn1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Thread timer = new Thread() {
				public void run() {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {

						Intent openCounter;
							openCounter = new Intent(

							"com.example.bytepad.SHOWRESULT");
						startActivity(openCounter);
						overridePendingTransition(R.anim.lr, R.anim.rl);
					}
				}
			};
			timer.start();
			
		}
	});
		btn2=(Button)findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread timer = new Thread() {
					public void run() {
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						} finally {

							Intent openCounter;
								openCounter = new Intent(

								"com.example.bytepad.STARTNEWWALLET");
							startActivity(openCounter);
							overridePendingTransition(R.anim.lr, R.anim.rl);
						}
					}
				};
				timer.start();
			}
		});
	}
}
