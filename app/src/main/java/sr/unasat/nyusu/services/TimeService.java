package sr.unasat.nyusu.services;

import android.content.Context;

import java.util.Calendar;

import sr.unasat.nyusu.dao.UserDao;

public class TimeService {
    Context context;

    public TimeService(Context context) {
        this.context = context;
    }

    public String getTime(){
        String text = "Good morning";

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            text = "Good morning";
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            text = "Good afternoon";
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            text = "Good evening";
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            text = "Good night";
        }

        return text;
    }

    public String getTimeText(){
        UserDao userDao = new UserDao(context);
        return getTime() + ", " + userDao.getUser().getName();

    }
}
