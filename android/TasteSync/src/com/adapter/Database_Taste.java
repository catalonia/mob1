package com.adapter;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Database_Taste {

	private static String DB_PATH = "/data/data/com.tastesync/databases/";
	private static String DB_NAME = "database.sqlite";
	private static final int DB_VERSION = 1;
	private DatabaseHelper db;

	private final Context myContext;

	public Database_Taste(Context context) {
		myContext = context;
		db = new DatabaseHelper(context);
		try {
			db.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
	}

	private void openDb() {
		try {
			db.openDataBase();
		} catch (SQLException sqle) {
			db.close();
			throw sqle;
		}
	}

	// lấy all ds
	public ArrayList<restaurant> getnamelist() {
		ArrayList<restaurant> list = new ArrayList<restaurant>();

		openDb();
		SQLiteDatabase data = db.getReadableDatabase();
		Cursor contro = data.rawQuery("select * from tb_db", null);
		contro.moveToFirst();
		while (!contro.isAfterLast()) {
			restaurant mShop = new restaurant(null, null, 0);
			String ten = contro.getString(1);
			String gia = contro.getString(2);
			Integer ratting = contro.getInt(3);
			if (ratting == 1) {
				mShop.setRatting(1);
			}
			if (ratting == 2) {
				mShop.setRatting(2);
			}
			if (ratting == 3) {
				mShop.setRatting(3);
			}
			if (ratting == 4) {
				mShop.setRatting(4);
			}
			if (ratting == 5) {
				mShop.setRatting(5);
			}
			
			mShop.setName(ten);
			mShop.setPrice(gia);
			list.add(mShop);

			contro.moveToNext();
		}

		data.close();
		db.close();
		return list;
	}

}
