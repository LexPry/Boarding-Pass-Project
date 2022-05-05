import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Objects;

public class BoardingPass {


    public BoardingPass(User user) {
        Airport.setAirports();
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

    public static double getFemaleDiscountPercent() {
        return femaleDiscountPercent;
    }
    public static double getSeniorDiscountPercent() {
        return seniorDiscountPercent;
    }
    public static double getKidDiscountPercent() {
        return kidDiscountPercent;
    }

    protected static final double femaleDiscountPercent = .75;
    protected static final double seniorDiscountPercent = .4;
    protected static final double kidDiscountPercent = .5;


    private void generatePrice(User user) {
        double result = getBasePrice(user.getOrigin(), user.getDestination());

        if (Objects.equals(user.getGender(), User.Gender.F)) {
            result *= femaleDiscountPercent;
            femaleDiscount = true;
        } else {
            femaleDiscount = false;
        }


        if (user.getAge() <= 16) {
            result *= kidDiscountPercent;
            kidDiscount = true;
            seniorDiscount = false;
        } else if (user.getAge() >= 60) {
            result *= seniorDiscountPercent;
            seniorDiscount = true;
            kidDiscount = false;
        }
        finalTicketPrice = (int) (result);
    }

    private double getBasePrice(String origin, String dest) {
        var airport = Airport.getAirports().get(origin);
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

    private String getBoardingPassNumber() {
       //combine all information into a single String, then hash, then take use 20 digits of hash
        StringBuilder sb = new StringBuilder();

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






