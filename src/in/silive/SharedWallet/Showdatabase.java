package in.silive.SharedWallet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Showdatabase extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showdb);
		Log.d("Reached show db", "  Reached show db");
		TextView tv = (TextView) findViewById(R.id.dbtv);
		Database db = new Database(this);
		db.open();
		String data = db.getData(),s="   ";
		int i = 1, l, m;
		l = data.length();
		outer: while (i < l) {
			m = (int) (data.charAt(i));

			if (((m <= 91) && (m >= 65)) || ((m <= 122) && (m >= 65))) {
				while (data.charAt(i) != ' ') {
					s=s+data.charAt(i);
					i++;
					if(i==l)
						break outer;
				}
				i++;
				s=s+"   ";
				if(i==l)
					break outer;
			
			} else {
				while (data.charAt(i) != ' ')
				{	s=s+data.charAt(i);
					i++;
				
				if(i==l)
					break outer;
			
				}
				s=s+"\n   ";
			i++;
			if(i==l)
				break outer;
		
			}
		}
		tv.setText(s);
		db.close();
	}
}
