package com.hmtmcse.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by touhid on 4/12/2016.
 */
public class E2BDateTime {

    private static String findReplaceMap(Map mp, String findReplace) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            findReplace = findReplace.replaceAll(pair.getKey().toString(), pair.getValue().toString());
            it.remove();
        }
        return findReplace;
    }

    public static String convert(String dateTime) {
        String toPattern = "dd-MM-yyyy HH:mm";
        return convert(dateTime, toPattern);
    }

    public static String convert(String dateTime, String toPattern) {
        String fromPattern = "dd MMM yyyy HH:mm";
        SimpleDateFormat format = new SimpleDateFormat(fromPattern);
        Date date = null;
        try {
            date = format.parse(dateTime);
        } catch (ParseException e) {
            return null;
        }
        String formatedDate = new SimpleDateFormat(toPattern).format(date);
        Map englishToBangla = new HashMap();
        englishToBangla.put("1","১");
        englishToBangla.put("2","২");
        englishToBangla.put("3","৩");
        englishToBangla.put("4","৪");
        englishToBangla.put("5","৫");
        englishToBangla.put("6","৬");
        englishToBangla.put("7","৭");
        englishToBangla.put("8","৮");
        englishToBangla.put("9","৯");
        englishToBangla.put("0","০");
        return findReplaceMap(englishToBangla,formatedDate);
    }

}
