package ro.springmongo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {


    // display in list
    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        if(date != null) {
            return dateFormat.format(date);
        } else {
            return "";
        }
    }

    // transform from add to date
    public static Date stringToDate(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = new Date();
        try {
            date = dateFormat.parse(dateStr);

        } catch (ParseException e) {
            //date = new Date(System.currentTimeMillis());
            System.out.println("Formatul pentru data este incorect");
        }
        return date;
    }
}
