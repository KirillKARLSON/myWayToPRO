
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;



public class DatePlay {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));


        //напишите тут ваш код
        map.put ("Ван Дамм", dateFormat.parse ("APRIL 18 2010"));
        map.put ("Шварценегер", dateFormat.parse ("JUNE 25 2011"));
        map.put ("Макконахи", dateFormat.parse ("JULY 11 2002"));
        map.put ("Норрис", dateFormat.parse ("AUGUST 05 2005"));
        map.put ("Блохин", dateFormat.parse ("SEPTEMBER 18 1999"));
        map.put ("Затевахин", dateFormat.parse ("OCTOBER 12 2003"));
        map.put ("Рандомлин", dateFormat.parse ("NOVEMBER 18 2007"));
        map.put ("Бундеров", dateFormat.parse ("DECEMBER 06 2003"));
        map.put ("Гордон", dateFormat.parse ("JANUARY 18 2010"));

        removeAllSummerPeople(map);
        return map;

    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map <String, Date> copy = new HashMap <String, Date> (map);

        for (Map.Entry <String, Date> prohod: copy.entrySet ()){
            String key = prohod. getKey ();
            String value = dateFormat.format (prohod.getValue ());


            if ((value.contains("Ju"))|| (value.contains("Aug"))) map.remove (key);
        }





    }

    public static void main(String[] args) throws ParseException {
        Map <String, Date> map= createMap();

        for (Map.Entry <String, Date> copy: map.entrySet()) System.out.println(copy);

    }


}
