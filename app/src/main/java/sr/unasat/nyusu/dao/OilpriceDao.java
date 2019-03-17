package sr.unasat.nyusu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import sr.unasat.nyusu.entities.OilPrice;

public class OilpriceDao {

    private Context context;
    NyusuDbHelper nyDbHelper;
    SQLiteDatabase db;

    public OilpriceDao(Context context) {
        this.context = context;
        nyDbHelper = new NyusuDbHelper(context);
    }

    /* Removed register oilprice
    public boolean registerUser(User user){
        try {
            // Gets the data repository in write mode
            db = nyDbHelper.getWritableDatabase();

            // Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(NyusuContract.UserEntry.COLUMN_NAME_USER_NAME, user.getUsername());
            values.put(NyusuContract.UserEntry.COLUMN_NAME_EMAIL, user.getEmail());
            //values.put(ComfiContract.UserEntry.COLUMN_NAME_PASSWORD, user.getPassword());

            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(NyusuContract.UserEntry.TABLE_NAME,
                    null, values);

            if(newRowId > 0){
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyDbHelper.close();
        }

        return false;
    }
    */

    private OilPrice getOilPrice(int oilpriceId){
        try {
            db = nyDbHelper.getReadableDatabase();

            Cursor cursor = db.query(NyusuContract.OilpriceEntry.TABLE_NAME,// Selecting Table
                    new String[]{NyusuContract.OilpriceEntry.CALUMN_NAME_ID,
                            NyusuContract.OilpriceEntry.CALUMN_NAME_UNLEADED,
                            NyusuContract.OilpriceEntry.CALUMN_NAME_DIESEL,
                            NyusuContract.OilpriceEntry.CALUMN_NAME_COMPANY_ID},//Selecting columns want to query
                    NyusuContract.OilpriceEntry.CALUMN_NAME_ID + "= ?",
                    new String[]{String.valueOf(oilpriceId)},//Where clause
                    null, null, null);

            if (cursor != null && cursor.moveToFirst() && cursor.getCount()>0) {
                //if cursor has value then in oilprice database there is oilprice associated with this given ??currency name
                OilPrice oilprice = new OilPrice(
                        cursor.getInt(0),
                        cursor.getDouble(1),
                        cursor.getDouble(2));

                System.out.println(oilprice.toString());
                return oilprice;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyDbHelper.close();
        }

        //if there is no record with that ??currency name then return @false
        return null;
    }

    /* Removed update oilprice
    public boolean updateUser(User user){
        try {
            // Gets the data repository in write mode
            db = nyDbHelper.getWritableDatabase();

            // Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(NyusuContract.UserEntry.COLUMN_NAME_USER_NAME, user.getUsername());
            values.put(NyusuContract.UserEntry.COLUMN_NAME_EMAIL, user.getEmail());

            // Insert the new row, returning the primary key value of the new row
            int status = db.update(NyusuContract.UserEntry.TABLE_NAME, values, NyusuContract.UserEntry.COLUMN_NAME_ID + " = ?",
                    new String[] { String.valueOf(user.getId()) });

            if(status > 0){
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyDbHelper.close();
        }

        return false;
    }
    */

    /* Removed delete oilprice
    public boolean deleteUser(int id) {
        try {
            // Gets the data repository in write mode
            db = nyDbHelper.getWritableDatabase();

            return db.delete(NyusuContract.UserEntry.TABLE_NAME, NyusuContract.UserEntry.COLUMN_NAME_ID + "= ?", new String[] { String.valueOf(id) }) > 0;

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyDbHelper.close();
        }

        return false;
    }
    */

    
}
