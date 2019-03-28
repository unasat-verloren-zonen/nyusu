package sr.unasat.nyusu.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import sr.unasat.nyusu.entities.User;

public class UserDao {

    private Context context;
    NyusuDbHelper nyusuDbHelper;
    SQLiteDatabase db;

    public UserDao (Context context) {
        this.context = context;
        nyusuDbHelper = new NyusuDbHelper(context);
    }

    public boolean create (User user) {
        try {
            //Gets the data repository in write mode
            db = nyusuDbHelper.getWritableDatabase();

            //create a new map of values, whee, colum names are the keys
            ContentValues values = new ContentValues();
            values.put(NyusuContract.UserEntry.COLUMN_NAME, user.getName());

            //insert the new row , returning the primary key value of the new row
            long newRowId = db.insert(NyusuContract.UserEntry.TABLE_NAME,null,values);
            if (newRowId > 0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyusuDbHelper.close();
        }
        return false;
    }

    public boolean userExist(){

        try {
            db = nyusuDbHelper.getReadableDatabase();

            // Define a projection that specifies which columns from the database
            // you will actually use after this query.
            String[] projection = {
                    NyusuContract.UserEntry.COLUMN_NAME,
            };

            // Filter results WHERE "title" = 'My Title'
            String selection = NyusuContract.UserEntry.COLUMN_ID + " = ?";
            String[] selectionArgs = {"1"};

            Cursor cursor = db.query(
                    NyusuContract.UserEntry.TABLE_NAME,   // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    selection,              // The columns for the WHERE clause
                    selectionArgs,          // The values for the WHERE clause
                    null,          // don't group the rows
                    null,           // don't filter by row groups
                    null,              // The sort order
                    null                  //limit
            );

            if(cursor!=null && cursor.getCount() > 0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyusuDbHelper.close();
        }

        return false;
    }

    public User read(){

        try {
            db = nyusuDbHelper.getReadableDatabase();

            // Define a projection that specifies which columns from the database
            // you will actually use after this query.
            String[] projection = {
                    NyusuContract.UserEntry.COLUMN_ID,
                    NyusuContract.UserEntry.COLUMN_NAME,
            };

            // Filter results WHERE "title" = 'My Title'
            String selection = NyusuContract.UserEntry.COLUMN_ID + " = ?";
            String[] selectionArgs = {"1"};

            Cursor cursor = db.query(
                    NyusuContract.UserEntry.TABLE_NAME,   // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    selection,              // The columns for the WHERE clause
                    selectionArgs,          // The values for the WHERE clause
                    null,          // don't group the rows
                    null,           // don't filter by row groups
                    null,              // The sort order
                    null                  //limit
            );

            if(cursor!=null && cursor.getCount() > 0){
                User user = new User();

                while (cursor.moveToNext()){
                    user.setId((cursor.getInt(0)));
                    user.setName((cursor.getString(1)));
                    System.out.println(user.toString());
                }

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyusuDbHelper.close();
        }

        return null;
    }

    public User getUser(){

        //if user exist in db return user
        if (userExist()){
            return read();
        }

        //else return default user
        User user = new User(0, "User");
        return user;
    }


}
