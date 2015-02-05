package in.silive.SharedWallet;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowResult extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showfinaldistribution);
		// TextView tv = (TextView) findViewById(R.id.fdtv);
		Database db = new Database(this);
		ListView list = (ListView) findViewById(android.R.id.list);
		db.open();
		String s = " ";
		String id[] = new String[1000];
		int amount[] = new int[1000];
		String finalArray[];
		String idnew[] = new String[1000];
		int amountnew[] = new int[1000];
		String data = db.getData();
		int i = 1, j = 0, k = 0, l;
		l = data.length();
		// Log.d("data and length","data is "+data+"length="+l+"0  "+data.charAt(1));
		outer: while (i < l) {

			if (Character.isLetter(data.charAt(i))) {
				// if (((m <= 91) && (m >= 65)) || ((m <= 122) && (m >= 65))) {
				while (data.charAt(i) != ' ') {
					s = s + data.charAt(i);
					i++;
					/*
					 * if (i == l) break outer;
					 */}
				if (!Character.isLetter(data.charAt(i + 1))) {
					id[j++] = s;
					s = " ";
				} else
					s += " ";
				i++;
			} else {

				amount[k] = 0;
				while (data.charAt(i) != ' ') {
					amount[k] = amount[k] * 10 + ((int) (data.charAt(i) - 48));
					i++;
					if (i == l) {
						k++;
						break outer;
					}
				}
				i++;
				k++;
			}
		}

		String visited[] = new String[100];
		visited[0] = id[0];
		int n = 1;
		for (i = 1; i < j; i++) {
			if (check(visited, n, id[i]) == 0) {
				visited[n] = id[i];
				n++;
			}
		}

		for (i = 0; i < n; i++) {
			amountnew[i] = 0;
		}
		for (i = 0; i < n; i++) {

			idnew[i] = visited[i];
			amountnew[i] = 0;
			for (int u = 0; u < j; u++) {

				if (id[u].contentEquals(visited[i])) {
					amountnew[i] += amount[u];
				}
			}
		}
		calculation ob = new calculation();
		try {
			finalArray = ob.get(amountnew, n, idnew);
			Log.d("Getting length of final array", " " + l);
			i = 0;
			while (finalArray[i] != null) {
				Log.d("Getting final array", " " + finalArray[i]);
				i++;
			}

			String lis[] = new String[i];
			i = 0;
			while (finalArray[i] != null) {
				Log.d("Getting final array", " " + finalArray[i]);
				lis[i] = finalArray[i];
				i++;
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, lis);

			list.setAdapter(adapter);
			list.setVisibility(View.VISIBLE);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
	}

	int check(String visited[], int n, String data) {
		int i = 0;
		for (i = 0; i < n; i++) {
			if (visited[i].contentEquals(data))
				return 1;
		}
		return 0;
	}
}
