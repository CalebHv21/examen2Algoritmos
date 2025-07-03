package util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;


public class Utility {

    private static final Random random;

    static {
        long seed = System.currentTimeMillis();
        random = new Random(seed);
    }


    public static int random(int bound) {
        return random.nextInt(bound);
    }


    public static int random(int low, int high) {
        return low + random.nextInt(high - low + 1);
    }


    public static String format(long n) {
        return new DecimalFormat("###,###,###.##").format(n);
    }


    public static String format(double n) {
        return new DecimalFormat("###,###,###.##").format(n);
    }


    public static int compare(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "Integer":
                Integer int1 = (Integer) a;
                Integer int2 = (Integer) b;
                return int1 < int2 ? -1 : int1 > int2 ? 1 : 0;
            case "String":
                String st1 = (String) a;
                String st2 = (String) b;
                return st1.compareTo(st2) < 0 ? -1 : st1.compareTo(st2) > 0 ? 1 : 0;
            case "Character":
                Character c1 = (Character) a;
                Character c2 = (Character) b;
                return c1.compareTo(c2) < 0 ? -1 : c1.compareTo(c2) > 0 ? 1 : 0;
        }
        return 2;
    }


    private static String instanceOf(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) return "Integer";
        if (a instanceof String && b instanceof String) return "String";
        if (a instanceof Character && b instanceof Character) return "Character";
        return "Unknown";
    }


    public static String dateFormat(Date value) {
        return new SimpleDateFormat("dd/MM/yyyy").format(value);
    }


    public static Date parseDate(String dateStr) {
        SimpleDateFormat fechaFormateada = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return fechaFormateada.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static int getAge(Date date) {
        Calendar calendarBD = Calendar.getInstance();
        calendarBD.setTime(date);

        Calendar calendarToday = Calendar.getInstance();

        int age = calendarToday.get(Calendar.YEAR) - calendarBD.get(Calendar.YEAR);

        if (calendarToday.get(Calendar.DAY_OF_YEAR) < calendarBD.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }
}