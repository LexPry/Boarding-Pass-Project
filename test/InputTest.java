
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class InputTest
    {

        @org.junit.jupiter.api.Test
        public void testGenerateUser() {
            User test = new User("Lex","jjj@null.com", User.Gender.M,"555-555-5555",
                    new Date(),"JFK",new Date(12/20/1020),"LAX",23);

            assertEquals("Lex",test.getName());
            assertEquals("jjj@null.com",test.getEmail());
            assertEquals("M", String.valueOf(test.getGender()));
            assertEquals("555-555-5555",test.getPhoneNumber());
            assertEquals("JFK",test.getDestination());
            assertEquals("LAX",test.getOrigin());
            assertEquals(23,test.getAge());
        }
    }