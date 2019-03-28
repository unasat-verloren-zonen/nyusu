package sr.unasat.nyusu.dao;

import android.provider.BaseColumns;

public class NyusuContract {

    private  NyusuContract() {};

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
    }

    public static class CurrencyEntry implements BaseColumns {
        public static final String TABLE_NAME ="currency";
        public static final String COLUMN_ID ="id";
        public static final String COLUMN_NAME ="name";
        public static final String COLUMN_SYMBOL="symbol";
        public static final String COLUMN_BUY ="buy";
        public static final String COLUMN_SELL ="sell";
    }

    public static class MediumEntry implements BaseColumns {
        public static final String TABLE_NAME = "medium";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
    }

    public static class CompanyEntry implements BaseColumns {
        public static final String TABLE_NAME = "company";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_IMG_URL = "img_url";
        public static final String COLUMN_NAME = "name";
    }

    public static class NewsEntry implements BaseColumns {
        public static final String TABLE_NAME = "news";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_MEDIUM_ID = "medium_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_IMG_URL = "img_url";
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_DATE = "date";
    }

    public static class OilpriceEntry implements BaseColumns {
        public static final String TABLE_NAME = "oilprice";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_COMPANY_ID = "company_id";
        public static final String COLUMN_UNLEADED = "unleaded";
        public static final String COLUMN_DIESEL = "diesel";
    }
}
