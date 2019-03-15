package sr.unasat.nyusu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import sr.unasat.nyusu.entities.Currency;

public class CurrencyDao {
    private Context context;
    NyusuDbHelper nyDbHelper;
    SQLiteDatabase db;

    public CurrencyDao(Context context) {
        this.context = context;
        nyDbHelper = new NyusuDbHelper(context);
    }

    /* Removed register currency
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

    private Currency getCurrency(int currencyId){
        try {
            db = nyDbHelper.getReadableDatabase();

            Cursor cursor = db.query(NyusuContract.CurrencyEntry.TABLE_NAME,// Selecting Table
                    new String[]{NyusuContract.CurrencyEntry.CALUMN_NAME_ID,
                            NyusuContract.CurrencyEntry.CALUMN_NAME_NAME,
                            NyusuContract.CurrencyEntry.CALUMN_NAME_SYMBOL,
                            NyusuContract.CurrencyEntry.CALUMN_NAME_BUY,
                            NyusuContract.CurrencyEntry.CALUMN_NAME_SELL, },
                    //Selecting columns want to query
                    NyusuContract.CurrencyEntry.CALUMN_NAME_ID + "= ?",
                    new String[]{String.valueOf(currencyId)},//Where clause
                    null, null, null);

            if (cursor != null && cursor.moveToFirst() && cursor.getCount()>0) {
                //if cursor has value then in currency database there is currency associated with this given currency name
                Currency currency = new Currency(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3),
                        cursor.getDouble(4));

                System.out.println(currency.toString());
                return currency;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            nyDbHelper.close();
        }

        //if there is no record with that currency name then return @false
        return null;
    }

    /* Removed update currency
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

    /* Removed delete currency
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
