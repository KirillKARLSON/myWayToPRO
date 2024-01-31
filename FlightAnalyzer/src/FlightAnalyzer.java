import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FlightAnalyzer {
    public static Map<String, Integer> minFlightTimesOfCarrier = new HashMap<>();
    public static List<Integer> allPrices = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Чтение файла tickets.json
            File file = new File("tickets.json");
            FileInputStream fis = new FileInputStream(file);
            JSONTokener tokener = new JSONTokener(fis);
            JSONObject jsonObject = new JSONObject(tokener);
            JSONArray ticketsArray = jsonObject.getJSONArray("tickets");

            // Обход каждого билета
            for (int i = 0; i < ticketsArray.length(); i++) {
                JSONObject ticket = ticketsArray.getJSONObject(i);
                String cityFrom = ticket.getString("origin_name");
                String cityTo = ticket.getString("destination_name");
                String carrier = ticket.getString("carrier");
                String departureTime = ticket.getString("departure_time");
                String arrivalTime = ticket.getString("arrival_time");

                // Добавление цены в список для расчета средней цены и медианы
                if (cityFrom.equals("Владивосток") && cityTo.equals("Тель-Авив")) {
                    allPrices.add(ticket.getInt("price"));

                    int flightTime = calculateFlightTime(departureTime, arrivalTime);
                    calculateMinFlightTimePerCarrier(flightTime, carrier);
                }
            }

            double averagePrice = calcAveragePrice();
            double medianPrice = calcMedianPrice();

            System.out.println("Минимальное время полета между городами Владивосток и Тель-Авив:");
            for (Map.Entry<String, Integer> entry : minFlightTimesOfCarrier.entrySet()) {
                System.out.println("Авиаперевозчик: " + entry.getKey() + ", Время полета: " + entry.getValue() + " мин");
            }

            System.out.println("Разница между средней ценой и медианой для полета между городами Владивосток и Тель-Авив: " +
                    (averagePrice - medianPrice));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int calculateFlightTime(String departureTime, String arrivalTime){
        int departureHour = Integer.parseInt(departureTime.split(":")[0]);
        int departureMinute = Integer.parseInt(departureTime.split(":")[1]);
        int arrivalHour = Integer.parseInt(arrivalTime.split(":")[0]);
        int arrivalMinute = Integer.parseInt(arrivalTime.split(":")[1]);

        return (arrivalHour - departureHour) * 60 + (arrivalMinute - departureMinute);
    }

    public static void calculateMinFlightTimePerCarrier(int flightTime, String carrier){
        if (!minFlightTimesOfCarrier.containsKey(carrier) || flightTime < minFlightTimesOfCarrier.get(carrier)) {
            minFlightTimesOfCarrier.put(carrier, flightTime);
        }
    }

    public static double calcAveragePrice(){
        return allPrices.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static double calcMedianPrice(){
        Collections.sort(allPrices);
        int medianIndex = allPrices.size() / 2;
        return allPrices.size() % 2 == 0 ? (allPrices.get(medianIndex - 1) + allPrices.get(medianIndex)) / 2.0 : allPrices.get(medianIndex);
    }
}