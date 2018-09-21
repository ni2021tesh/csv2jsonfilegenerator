package com.niteshjha.info.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateConverterUtility {

    private static final String DATE_FORMAT = "mm/dd/yy HH:mm";
    private static final String DATE_FORMAT_1 = "mm-dd-yyyy HH:mm";

    /**
     * @param date it is the date object which needs to be formatted  according to DATE_FORMAT or DATE_FORMAT_1
     * @return java.sql.Date object
     * @apiNote this method is used to format the string date received from FileReader
     */
    public static Date getDate(String date) {
        Date parse = null;
        try {
            parse = new Date(new SimpleDateFormat(DATE_FORMAT).parse(date).getTime());
        } catch (ParseException e) {
            try {
                parse = new Date(new SimpleDateFormat(DATE_FORMAT_1).parse(date).getTime());
            } catch (ParseException e1) {
                System.out.println("error occurred while parsing the date");
            }
        }
        return parse;
    }

    /**
     * @param line represent single transaction from the file
     * @return String
     * @apiNote this method is used to remove '"' double quote from the string object
     */
    public static String getString(String line) {
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher m = pattern.matcher(line);
        while (m.find()) {
            line = line.replaceFirst(m.group(1), m.group(1).replace(",", ""));
            line = line.replace("\"", "");
        }
        return line;
    }
}
