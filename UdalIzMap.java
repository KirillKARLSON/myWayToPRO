import java.util.HashMap;
import java.util.Map;


public class UdalIzMap {


    public static void main (String[] args) {

        Map <String, String> map = createMap();

        for (Map.Entry <String, String> gol: map.entrySet()){
            System.out.println (gol);
        }

        removeTheFirstNameDuplicates(map);


        System.out.println (""+"");
        System.out.println("После превращения");
        System.out.println (""+"");
        for (Map.Entry <String, String> gol: map.entrySet()){
            System.out.println (gol);
        }



    }
    public static Map<String, String> createMap() {
        //напишите тут ваш код

        Map <String, String> map = new HashMap <String,String> ();

        map.put ("Иванов","Петр");
        map.put ("Петров", "Дмитрий");
        map.put ("Октябрев","Василий");
        map.put ("Колокольцев", "Юрий");
        map.put ("Румянцев", "Василий");
        map.put ("Сальдо", "Василий");
        map.put ("Максимов", "Леонид");
        map.put ("Тарковский", "Квантилион");
        map.put ("Дымов", "Василий");
        map.put ("Дацик", "Слава");


        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код

        for (Map.Entry<String, String> gol : map.entrySet()) {
            int count = 0;
            String value1 = gol.getValue();

            for (Map.Entry<String, String> sovp : map.entrySet()) {
                String value = sovp.getValue();

                if (value.equals(value1)) {count++;
            } if (count >1)  removeItemFromMapByValue (map, value1);
            }}
        }

   public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map <String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    }
