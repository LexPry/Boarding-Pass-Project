
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class InputTest
    {

        @org.junit.jupiter.api.Test
        public void testGenerateUser() {
            User test = new User("Lex","jjj@null.com","M","555-555-5555",
                    new Date(),"Atlanta",new Date(12/20/1020),"MI",23);

            assertEquals(0202020, test.getBoardingPassNumber());
            assertEquals("Lex",test.getName());
            assertEquals("jjj@null.com",test.getEmail());
            assertEquals("M",test.getGender());
            assertEquals("555-555-5555",test.getPhoneNumber());
            assertEquals("Atlanta",test.getDestination());
            assertEquals("MI",test.getOrigin());
            assertEquals(23,test.getAge());
        }
    }