
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class InputTest {

    @org.junit.jupiter.api.Test
    public void testGetInformation() {
        User test = new User("Lex", "jjj@null.com", User.Gender.M, "555-555-5555",
                new Date(), "JFK", new Date(12 / 20 / 1020), "LAX", 23);

        assertEquals("Lex", test.getName());
        assertEquals("jjj@null.com", test.getEmail());
        assertEquals("M", String.valueOf(test.getGender()));
        assertEquals("555-555-5555", test.getPhoneNumber());
        assertEquals(String.valueOf(new Date(12 / 20 / 1020)), String.valueOf(test.getDepartureTime()));
        assertEquals("JFK", test.getDestination());
        assertEquals("LAX", test.getOrigin());
        assertEquals(23, test.getAge());
    }


    @Test
    void testCheckNumber() {
        Assertions.assertTrue(Input.checkNumber("555-555-5555"));
        Assertions.assertTrue(Input.checkNumber("4444444444"));
        Assertions.assertTrue(Input.checkNumber("404 320 1234"));
        Assertions.assertFalse(Input.checkNumber("222"));
        Assertions.assertFalse(Input.checkNumber("(4043)2071234"));
        Assertions.assertFalse(Input.checkNumber("(443)201-9234"));
        Assertions.assertTrue(Input.checkNumber("(777)-231-8821"));
    }
}