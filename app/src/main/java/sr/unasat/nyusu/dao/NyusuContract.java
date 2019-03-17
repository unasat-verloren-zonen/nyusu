package sr.unasat.nyusu.dao;

import android.provider.BaseColumns;

public class NyusuContract {

    private  NyusuContract() {};

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String CALUMN_NAME_ID = "user_id";
        public static final String CALUMN_NAME_NAME = "name";

    }

    public static class CurrencyEntry implements BaseColumns {
        public static final String TABLE_NAME ="currency";
        public static final String CALUMN_NAME_ID ="currency_id";
        public static final String CALUMN_NAME_NAME ="name";
        public static final String CALUMN_NAME_SYMBOL="symbole";
        public static final String CALUMN_NAME_BUY ="buy";
        public static final String CALUMN_NAME_SELL ="sell";

    }

    public static class MediumEntry implements BaseColumns {
        public static final String TABLE_NAME = "medium";
        public static final String CALUMN_NAME_ID = "medium_id";
        public static final String CALUMN_NAME_NAME = "name";

    }

    public static class CompanyEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String CALUMN_NAME_ID = "Company_id";
        public static final String CALUMN_NAME_NAME = "name";

    }

    public static class NewsEntry implements BaseColumns {
        public static final String TABLE_NAME = "news";
        public static final String CALUMN_NAME_ID = "news_id";
        public static final String CALUMN_NAME_MEDIUM_ID = "medium_id";
        public static final String CALUMN_NAME_TITLE = "title";
        public static final String CALUMN_NAME_IMGURL = "imgurl";
        public static final String CALUMN_NAME_TEXT = "text";
        public static final String CALUMN_NAME_DATE = "date";

    }
    public static class OilpriceEntry implements BaseColumns {
        public static final String TABLE_NAME = "oilprice";
        public static final String CALUMN_NAME_ID = "oilprice_id";
        public static final String CALUMN_NAME_COMPANY_ID = "medium_id";
        public static final String CALUMN_NAME_UNLEADED = "unleaded";
        public static final String CALUMN_NAME_DIESEL = "diesel";
    }

}
