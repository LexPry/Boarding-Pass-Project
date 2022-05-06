
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Scanner;

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
    void testGetDateAndTime(){
        String testInput = "12/23/2023\n2:01pm\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        var departureTime = Input.getDepartureTime(new Scanner(System.in));
        var result = String.format("%-33s", departureTime);
        System.out.println(result);



    }
}