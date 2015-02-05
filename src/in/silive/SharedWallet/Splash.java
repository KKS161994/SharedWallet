package in.silive.SharedWallet;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle splashbackground) {
		// TODO Auto-generated method stub
		super.onCreate(splashbackground);
		setContentView(R.layout.splash);

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

					Intent openCounter;
					openCounter = new Intent(

					"com.example.bytepad.MAINACTIVITY");
					startActivity(openCounter);
					overridePendingTransition(R.anim.lr, R.anim.rl);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setContentView(R.layout.splash);

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

					Intent openCounter;
					openCounter = new Intent(

					"com.example.bytepad.MAINACTIVITY");
					startActivity(openCounter);
					overridePendingTransition(R.anim.lr, R.anim.rl);
				}
			}
		};
		timer.start();

	}

}