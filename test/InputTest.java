import junit.framework.TestCase;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

public class InputTest extends TestCase
    {

        @Test
        public void testGenerateUser() {
            User test = new User("Lex","jjj@null.com","M","555-555-5555",
                    new Date(String.valueOf(Instant.EPOCH)),"Atlanta",new Date(12/20/1020),"MI",23);

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