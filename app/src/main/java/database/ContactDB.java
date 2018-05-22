package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import enbities.Contact;

/**
 * Created by DoanTrang on 5/21/2018.
 */

public class ContactDB extends SQLiteOpenHelper {
    private static String dbName = "ContactDB";
    private static String ykienColumn = "ykien";
    private static String idColumn = "id";
    private static String tableYkien = "contact";
    private Context context;

    public ContactDB(Context context) {
        super(context, dbName, null, 1);
        context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table" + tableYkien + "(" +
                idColumn + "interger primary key autoincrement," +
                ykienColumn + "text");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exits" + tableYkien);
        onCreate(sqLiteDatabase);

    }

    public List<Contact> findAll() {
        try {
            List<Contact> contacts = new ArrayList<Contact>();
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select*from" +
                    tableYkien, null);
            if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(cursor.getInt(0));
                contact.setYkien(cursor.getString(1));
                contacts.add(contact);
            } while (cursor.moveToNext());
        }
            sqLiteDatabase.close();
            return contacts;

        } catch (Exception e) {
            return null;

        }
    }


    public boolean create(Contact contact) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ykienColumn, contact.getYkien());
            long rows = sqLiteDatabase.insert(tableYkien, null, contentValues);
            sqLiteDatabase.close();
            return rows > 0;


        } catch (Exception e) {
            return false;
        }

    }
}
