package sr.unasat.nyusu.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import sr.unasat.nyusu.entities.User;

public class UserDao {

    private Context context;
    NyusuDbHelper nyusuDbHelper;
    SQLiteDatabase db;

    public UserDao (Context context) {
        this.context = context;
        nyusuDbHelper = new NyusuDbHelper(context);
    }

    public boolean registerUser (User user) {
        try {
            //Gets the data repository in write mode
            db = nyusuDbHelper.getWritableDatabase();

            //create a new map of values, whee, colum names are  the keys

            ContentValues values = new ContentValues();
            values.put(NyusuContract.UserEntry.CALUMN_NAME_NAME, user.getName());

            //insert the new row , returning the primary key value of the new row
            long newRowId = db.insert(NyusuContract.UserEntry.TABLE_NAME,null,values);
            if (newRowId >0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyusuDbHelper.close();
        }
        return false;
    }


}
