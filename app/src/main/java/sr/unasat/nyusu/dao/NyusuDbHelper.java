package sr.unasat.nyusu.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NyusuDbHelper extends SQLiteOpenHelper {

    //DATABASE NAME
    public static final String DATABASE_NAME = "nyusu_db";

    //DATABASE VERSION
    public static final int DATABASE_VERSION = 2;

    //USER TABLE
    private static final String SQL_CREATE_USER_ENTRIES = "CREATE TABLE " + NyusuContract.UserEntry.TABLE_NAME
            +"("
            +NyusuContract.UserEntry.COLUMN_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.UserEntry.COLUMN_NAME +"TEXT"
            +")";
    private  static final String SQL_DELETE_USER_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.UserEntry.TABLE_NAME;


    //CURRENCY TABLE
    private static final String SQL_CREATE_CURRENCY_ENTRIES = "CREATE TABLE " + NyusuContract.CurrencyEntry.TABLE_NAME
            +"("
            +NyusuContract.CurrencyEntry.COLUMN_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.CurrencyEntry.COLUMN_NAME +"TEXT,"
            +NyusuContract.CurrencyEntry.COLUMN_SYMBOL +"TEXT,"
            +NyusuContract.CurrencyEntry.COLUMN_BUY + "REAL,"
            +NyusuContract.CurrencyEntry.COLUMN_SELL + "REAL"
            +")";
    private  static final String SQL_DELETE_CURRENCY_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.CurrencyEntry.TABLE_NAME;


    //MEDIUM TABLE
    private static final String SQL_CREATE_MEDIUM_ENTRIES = "CREATE TABLE " + NyusuContract.MediumEntry.TABLE_NAME
            +"("
            +NyusuContract.MediumEntry.COLUMN_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.MediumEntry.COLUMN_NAME +"TEXT"
            +")";
    private  static final String SQL_DELETE_MEDIUM_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.MediumEntry.TABLE_NAME;


    //COMPANY TABLE
    private static final String SQL_CREATE_COMPANY_ENTRIES = "CREATE TABLE " + NyusuContract.CompanyEntry.TABLE_NAME
            +"("
            +NyusuContract.CompanyEntry.COLUMN_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.CompanyEntry.COLUMN_NAME +"TEXT"
            +")";
    private  static final String SQL_DELETE_COMPANY_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.CompanyEntry.TABLE_NAME;


    //NEWS TABLE
    private static final String SQL_CREATE_NEWS_ENTRIES = "CREATE TABLE " + NyusuContract.NewsEntry.TABLE_NAME
            +"("
            +NyusuContract.NewsEntry.COLUMN_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.NewsEntry.COLUMN_MEDIUM_ID +"INTEGER,"
            +NyusuContract.NewsEntry.COLUMN_TITLE +"TEXT,"
            +NyusuContract.NewsEntry.COLUMN_IMG_URL + "TEXT,"
            +NyusuContract.NewsEntry.COLUMN_TEXT + "REAL,"
            +NyusuContract.NewsEntry.COLUMN_DATE + "INT,"
            +" FOREIGN KEY (" + NyusuContract.NewsEntry.COLUMN_MEDIUM_ID + ") REFERENCES "
            + NyusuContract.MediumEntry.TABLE_NAME + "(" + NyusuContract.MediumEntry.COLUMN_ID + "));";
    private  static final String SQL_DELETE_NEWS_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.NewsEntry.TABLE_NAME;


    //OILPRICE TABLE
    private static final String SQL_CREATE_OILPRICE_ENTRIES = "CREATE TABLE " + NyusuContract.OilpriceEntry.TABLE_NAME
            +"("
            +NyusuContract.OilpriceEntry.COLUMN_ID + "INTEGER PRIMARY KEY,"
            +NyusuContract.OilpriceEntry.COLUMN_COMPANY_ID +"INTEGER,"
            +NyusuContract.OilpriceEntry.COLUMN_UNLEADED +"REAL,"
            +NyusuContract.OilpriceEntry.COLUMN_DIESEL + "REAL,"
            +" FOREIGN KEY (" + NyusuContract.OilpriceEntry.COLUMN_COMPANY_ID + ") REFERENCES "
            + NyusuContract.CompanyEntry.TABLE_NAME + "(" + NyusuContract.CompanyEntry.COLUMN_ID + "));";
    private  static final String SQL_DELETE_OILPRICE_ENTRIES = " DROP TABLE IF EXISTS " + NyusuContract.OilpriceEntry.TABLE_NAME;


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
