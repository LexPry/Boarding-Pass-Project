import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getBoardingNumber() {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");

        Date date = assertDoesNotThrow(()-> format.parse("05/03/2022 11:01 am"));
        User testUserMale = new User("Crash Test Dummy", "crashtest@airplanesRsafe.com", User.Gender.M, "555-555-5555",
                date, "LAX", date, "JFK", 50);
        User testUserSeniorFemale = new User("Crash Test Dummette", "areufosreal@airplanesRsafe.com", User.Gender.F, "555-555-5556",
                date, "ORD", date, "JFK", 70);
        User testUserKidMale = new User("Crash Test Timmy", "iamtooyoungtohaveanemail@airplanesRsafe.com", User.Gender.M, "555-555-5556",
                date, "ORD", date, "JFK", 3);

        BoardingPass male = assertDoesNotThrow(()->  new BoardingPass(testUserMale));
        BoardingPass female = assertDoesNotThrow(()->  new BoardingPass(testUserSeniorFemale));
        BoardingPass kid = assertDoesNotThrow(()->  new BoardingPass(testUserKidMale));

        assertEquals( (int) Airport.getAirports().get("JFK").basePrices.get("LAX"), male.getFinalTicketPrice());
        assertEquals( (int)(BoardingPass.getFemaleDiscountPercent()* BoardingPass.getSeniorDiscountPercent()
                * Airport.getAirports().get("JFK").basePrices.get("ORD")), female.getFinalTicketPrice());
        assertEquals( (int)(BoardingPass.getKidDiscountPercent()
                * Airport.getAirports().get("JFK").basePrices.get("ORD")), kid.getFinalTicketPrice());

        assertEquals( 20, male.getBoardingNumber().length());
        var e =kid.getETA().getTime() - date.getTime();
        var f = Airport.getAirports().get("JFK").estFlightTimes.get("ORD") * 60 * 1000; //convert minutes to milliseconds
        assertEquals(f, e);

        assertFalse(kid.isFemaleDiscount());
        assertTrue(kid.isKidDiscount());
        assertFalse(kid.isSeniorDiscount());
        assertTrue(female.isSeniorDiscount());
        assertFalse(female.isKidDiscount());
        assertTrue(female.isFemaleDiscount());
        assertFalse(male.isSeniorDiscount());
        assertFalse(male.isKidDiscount());
        assertFalse(male.isFemaleDiscount());
    }
}