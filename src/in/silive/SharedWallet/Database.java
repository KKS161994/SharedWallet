package in.silive.SharedWallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database{
public static int j=0;
int iacc[]=new int[100];

	public static final String KEY_ROWID = "_id";
	public static final String KEY_ID = "id";
	public static final String KEY_AMOUNT = "amt";
	public static String result=" ";
	private static final String DATABASE_NAME = "Wallet";
	private static final String DATABASE_TABLE = "AMOUNTS";
	private static final int DATABASE_VERSION = 1;

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub//
		}
		

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ROWID
					+ " INTEGER PRIMARY KEY, " + KEY_ID
					+ " DOUBLE NOT NULL, " + KEY_AMOUNT
					+ " DOUBLE NOT NULL);");
			
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}

	}

	public Database(Context c) {
		ourContext = c;
		
	}


	public Database open() throws SQLException {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
public void delete(){
	ourDatabase.execSQL("DROP TABLE IF EXISTS AMOUNTS" );
	ourDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ROWID
			+ " INTEGER PRIMARY KEY, " + KEY_ID
			+ " DOUBLE NOT NULL, " + KEY_AMOUNT
			+ " DOUBLE NOT NULL);");

	Log.d("delete()","Deleting database");
}
	public void close() {
		ourHelper.close();
	}
	

	public long createEntry(String id, String amount) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, id);
		cv.put(KEY_AMOUNT,amount);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);

	}
	public int[] getDataIA() {
		return iacc;
	}
	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ROWID, KEY_ID,
				KEY_AMOUNT };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null,
				null, null);
		int l=0;

		String result = "";
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
		l++;
		}
		Log.d("Got I","I value is="+l);
		int ids = c.getColumnIndex(KEY_ID);
		int amount = c.getColumnIndex(KEY_AMOUNT);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result = result +" " + c.getString(ids)+ " " + c.getString(amount);
					//+ "	" + c.getString(amount) ;
	
		}
		return result;
	}


}
