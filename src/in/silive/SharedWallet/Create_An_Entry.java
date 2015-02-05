package in.silive.SharedWallet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_An_Entry extends Activity {
	Button addentry;
	Database db = new Database(this);
	EditText et1, et2;
	int i = 0;
	String id[] = new String[100];

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addentry);
		initialise();

	}

	private void initialise() {
		// TODO Auto-generated method stub
		addentry = (Button) findViewById(R.id.addentry);
		et1 = (EditText) findViewById(R.id.edentry);
		et2 = (EditText) findViewById(R.id.edentry2);
	}

	public void clicked(View view) {
		// TODO Auto-generated method stub
		Log.d("Getting i", "  " + i);
		if ((et1.getText().toString().matches(""))
				|| (et2.getText().toString().matches(""))||(!Character.isLetter(et1.getText().toString().charAt(0)))) {
			Toast.makeText(this, "Entry Not Correct", Toast.LENGTH_SHORT)
					.show();
		} else {
			db.open();
			db.createEntry(et1.getText().toString(), et2.getText().toString());
			db.close();
			et1.setText("");
			et2.setText("");
			Toast.makeText(this, "Entry Created", Toast.LENGTH_SHORT)
			.show();

		}
	}

}