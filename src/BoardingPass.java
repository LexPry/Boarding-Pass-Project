import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class BoardingPass {


    public BoardingPass(User user) {
        BoardingPass.setAirports();
        this.user = user;
        generatePrice(user);
        boardingNumber = getBoardingPassNumber();
    }
    public User getUser() {
        return user;
    }
    public String getBoardingNumber() {
        return boardingNumber;
    }
    public boolean isFemaleDiscount() {
        return femaleDiscount;
    }
    public boolean isKidDiscount() {
        return kidDiscount;
    }
    public boolean isSeniorDiscount() {
        return seniorDiscount;
    }
    public int getBaseTicketPrice() {
        return baseTicketPrice;
    }
    public int getFinalTicketPrice() {
        return finalTicketPrice;
    }
    public Date getETA() {
        return ETA;
    }



    private static final HashMap<String,Airport> airports = new HashMap<>();
    protected static void setAirports(){
        if (airports.size() == 0){
            airports.put("JFK", Airport.JFK);
            airports.put("ORD", Airport.ORD);
            airports.put("LAX", Airport.LAX);
            airports.put("ATL", Airport.ATL);
        }
    }

    protected static HashMap<String,Airport> getAirports(){
        if (airports.size() == 0){
            airports.put("JFK", Airport.JFK);
            airports.put("ORD", Airport.ORD);
            airports.put("LAX", Airport.LAX);
            airports.put("ATL", Airport.ATL);
        }
        return airports;
    }
    private void generatePrice(User user) {
        double result = 0;
        double basePrice = getBasePrice(user.getOrigin(), user.getDestination());
        baseTicketPrice = (int) (basePrice * 100);

        if (Objects.equals(user.getGender(), "f")) {
            result -= basePrice / 4.;
            femaleDiscount = true;
        } else {
            femaleDiscount = false;
        }


        if (user.getAge() <= 16) {
            result -= result / 2;
            kidDiscount = true;
            seniorDiscount = false;
        } else if (user.getAge() >= 60) {
            result -= result * (3. / 5.);
            seniorDiscount = true;
            kidDiscount = false;
        }
        finalTicketPrice = (int) (result * 100.);
    }

    private double getBasePrice(String origin, String dest) {
        var airport = airports.get(origin);
        baseTicketPrice = airport.basePrices.get(dest);
        var etaLong = (airport.estFlightTimes.get(dest) * 1000* 60)+ user.getDepartureTime().getTime();
        ETA.setTime(etaLong);
        return baseTicketPrice;
    }

    private boolean femaleDiscount;
    private boolean kidDiscount;
    private boolean seniorDiscount;
    private int baseTicketPrice;
    private int finalTicketPrice;
    private final User user;
    private final Date ETA = new Date();

    private final String boardingNumber;

    protected String getBoardingPassNumber() {
        Date now = Date.from(Instant.EPOCH);
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(now.getTime()));

        sb.append(user.getName());

        if (kidDiscount) {
            sb.append(3);
        } else if (seniorDiscount) {
            sb.append(7);
        } else {
            sb.append(4);
        }

        sb.append(user.getAge());
        sb.append(user.getPhoneNumber());

        if (femaleDiscount) {
            sb.append(8);
        } else {
            sb.append(2);
        }
        sb.append(baseTicketPrice * 4 / 2.45);
        sb.append(finalTicketPrice * 6 / 3.78);
        sb.append(user.getOrigin());
        sb.append(user.getDepartureTime());
        sb.append(user.getDestination());
        sb.append((user.getEmail()));
        sb.append(user.getAge());

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (Exception e) {
            System.err.println("SHA-512 algorithm missing");
            e.printStackTrace();
            System.exit(-1);
        }
        assert md != null;
        byte[] messageDigest = md.digest(sb.toString().getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String out = no.toString(10);
        return out.substring(0,20);

    }
}






