import java.util.HashMap;

public class Airport {
    private static final HashMap<String,Airport> airports = new HashMap<>();

    Airport(String name, String dest1, int time1, int price1, String dest2, int time2, int price2, String dest3, int time3, int price3){
        this.name = name;
        estFlightTimes.put(dest1,time1);
        estFlightTimes.put(dest2,time2);
        estFlightTimes.put(dest3,time3);
        basePrices.put(dest1,price1);
        basePrices.put(dest2,price2);
        basePrices.put(dest3,price3);

    }
    String name;
    HashMap<String, Integer> estFlightTimes = new HashMap<>();
    HashMap<String, Integer> basePrices = new HashMap<>();

    static final Airport JFK = new Airport("JFK", "LAX", 390, 40900, "ORD",170, 25100,"ATL", 170,20500);
    static final Airport LAX = new Airport("LAX", "JFK", 337,60300, "ORD", 237, 38900,"ATL", 263, 50700);
    static final Airport ORD = new Airport("ORD", "JFK", 147, 32900, "LAX", 265, 62200, "ATL", 126, 39200);
    static final Airport ATL=  new Airport("ATL", "JFK",142,29900,"ORD",127,363,"LAX", 279,68600);

    protected static void setAirports(){
        if (airports.size() == 0){
            airports.put("JFK", JFK);
            airports.put("ORD", ORD);
            airports.put("LAX", LAX);
            airports.put("ATL", ATL);
        }
    }

    public static HashMap<String,Airport> getAirports(){
        if (airports.size() == 0){
            airports.put("JFK", JFK);
            airports.put("ORD", ORD);
            airports.put("LAX", LAX);
            airports.put("ATL", ATL);
        }
        return airports;
    }
}
