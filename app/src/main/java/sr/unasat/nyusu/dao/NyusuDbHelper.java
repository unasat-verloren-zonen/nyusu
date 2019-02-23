package sr.unasat.nyusu.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NyusuDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_USER_ENTRIES = "CREATE TABLE" + NyusuContract.UserEntry.TABLE_NAME
            +"("
            +NyusuContract.UserEntry.CALUMN_NAME_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.UserEntry.CALUMN_NAME_NAME +"TEXT"
            +")";
    private  static final String SQL_DELETE_USER_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.UserEntry.TABLE_NAME;


    private static final String SQL_CREATE_CURRENCY_ENTRIES = "CREATE TABLE" + NyusuContract.CurrencyEntry.TABLE_NAME
            +"("
            +NyusuContract.CurrencyEntry.CALUMN_NAME_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.CurrencyEntry.CALUMN_NAME_NAME +"TEXT"
            +NyusuContract.CurrencyEntry.CALUMN_NAME_SYMBOL +"TEXT"
            +NyusuContract.CurrencyEntry.CALUMN_NAME_BUY + "REAL"
            +NyusuContract.CurrencyEntry.CALUMN_NAME_SELL + "REAL"
            +")";
    private  static final String SQL_DELETE_CURRENCY_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.CurrencyEntry.TABLE_NAME;


    private static final String SQL_CREATE_MEDIUM_ENTRIES = "CREATE TABLE" + NyusuContract.MediumEntry.TABLE_NAME
            +"("
            +NyusuContract.MediumEntry.CALUMN_NAME_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.MediumEntry.CALUMN_NAME_NAME +"TEXT"
            +")";
    private  static final String SQL_DELETE_MEDIUM_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.MediumEntry.TABLE_NAME;

    private static final String SQL_CREATE_COMPANY_ENTRIES = "CREATE TABLE" + NyusuContract.CompanyEntry.TABLE_NAME
            +"("
            +NyusuContract.CompanyEntry.CALUMN_NAME_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.CompanyEntry.CALUMN_NAME_NAME +"TEXT"
            +")";
    private  static final String SQL_DELETE_COMPANY_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.CompanyEntry.TABLE_NAME;


    private static final String SQL_CREATE_NEWS_ENTRIES = "CREATE TABLE" + NyusuContract.NewsEntry.TABLE_NAME
            +"("
            +NyusuContract.NewsEntry.CALUMN_NAME_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.NewsEntry.CALUMN_NAME_MEDIUM_ID +"INTEGER FOREIGN KEY"
            +NyusuContract.NewsEntry.CALUMN_NAME_TITLE +"TEXT"
            +NyusuContract.NewsEntry.CALUMN_NAME_IMGURL + "TEXT"
            +NyusuContract.NewsEntry.CALUMN_NAME_TEXT + "REAL"
            +NyusuContract.NewsEntry.CALUMN_NAME_DATE + "INT"
            +")";
    private  static final String SQL_DELETE_NEWS_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.NewsEntry.TABLE_NAME;


    private static final String SQL_CREATE_OILPRICE_ENTRIES = "CREATE TABLE" + NyusuContract.OilpriceEntry.TABLE_NAME
            +"("
            +NyusuContract.OilpriceEntry.CALUMN_NAME_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.OilpriceEntry.CALUMN_NAME_COMPANY_ID +"INTEGER FOREIGN KEY"
            +NyusuContract.OilpriceEntry.CALUMN_NAME_UNLEADED +"REAL"
            +NyusuContract.OilpriceEntry.CALUMN_NAME_DIESEL + "REAL"
            +")";
    private  static final String SQL_DELETE_OILPRICE_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.OilpriceEntry.TABLE_NAME;

    //DATABASE NAME
    public static final String DATABASE_NAME = "nyusu_db";
    //DATABASE VERSION
    public static final int DATABASE_VERSION = 2;


    public NyusuDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Table when oncreate gets called
        db.execSQL(SQL_CREATE_USER_ENTRIES);
        db.execSQL(SQL_CREATE_CURRENCY_ENTRIES);
        db.execSQL(SQL_CREATE_MEDIUM_ENTRIES);
        db.execSQL(SQL_CREATE_OILPRICE_ENTRIES);
        db.execSQL(SQL_CREATE_COMPANY_ENTRIES);
        db.execSQL(SQL_CREATE_NEWS_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_COMPANY_ENTRIES);
        db.execSQL(SQL_DELETE_CURRENCY_ENTRIES);
        db.execSQL(SQL_DELETE_MEDIUM_ENTRIES);
        db.execSQL(SQL_DELETE_OILPRICE_ENTRIES);
        db.execSQL(SQL_DELETE_COMPANY_ENTRIES);
        db.execSQL(SQL_DELETE_NEWS_ENTRIES);

    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db,oldVersion, newVersion);
    }
}
