
package com.BeerDropper.www;

import static android.provider.BaseColumns._ID;
import static com.BeerDropper.www.Constants.TABLE_NAME;
import static com.BeerDropper.www.Constants.C_DISTRIBUTOR;
import static com.BeerDropper.www.Constants.C_NAME;
import static com.BeerDropper.www.Constants.C_ADDRESS ;
import static com.BeerDropper.www.Constants.C_DESCRIPTION;
import static com.BeerDropper.www.Constants.C_PHONE ;
import static com.BeerDropper.www.Constants.C_STATUS;
import static com.BeerDropper.www.Constants.C_COMPLETE;
import static com.BeerDropper.www.Constants.C_CANCEL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * This class creates a local database that will cache the current orders from the server
 * Data uploaded from the server will have all the Order information/details
 * *Order ID
 * *Name of customer,address,phone number
 * *Order Details/description
 * *Order status -received,pending,processing,delivered,cancelled,
 *
 *
 */
public class DbHelper extends SQLiteOpenHelper {
	
	public static final String DB_NAME = "beerdropper.db";
	public static final int DB_VERSION = 2;
	
	private static final String TAG = "BDDB";


	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+ TABLE_NAME + 
				" (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
				C_DISTRIBUTOR + " INTEGER, " + 
				C_NAME + " TEXT, " +
				C_ADDRESS + " TEXT, " + 
				C_DESCRIPTION + " ARRAY, " + 
				C_PHONE + " INTEGER, " + 
				C_STATUS + " BOOLEAN," + 
				C_COMPLETE + " BOOLEAN," +
				C_CANCEL + "BOOLEAN);");
		

	/*	String sql = String.format(
				"create table %s (%s int primary key, %s INT,%s TEXT, %s TEXT, %s INT,%s TEXT,%s TEXT)",
				TABLE, C_ID, C_DISTRIBUTOR,C_NAME, C_ADDRESS,C_PHONE, C_DESCRIPTION,C_STATUS);
		//sql = context.getString(R.string.sql);

		Log.d(TAG, "onCreate sql: "+sql);

		db.execSQL(sql);
*/	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Typically you do ALTER TABLE... here
		db.execSQL("drop table if exists " + TABLE_NAME);
		Log.d(TAG, "onUpdate dropped table "+TABLE_NAME);
		this.onCreate(db);
	}

}

