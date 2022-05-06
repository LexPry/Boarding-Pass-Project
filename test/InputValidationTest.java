import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    @Test
    void testCheckNumber() {
        assertTrue(InputValidation.checkNumber("555-555-5555"));
        assertTrue(InputValidation.checkNumber("4444444444"));
        assertTrue(InputValidation.checkNumber("404 320 1234"));
        assertFalse(InputValidation.checkNumber("222"));
        assertFalse(InputValidation.checkNumber("(4043)2071234"));
        assertTrue(InputValidation.checkNumber("(443)201-9234"));
        assertTrue(InputValidation.checkNumber("(777)-231-8821"));
    }

    @Test
    void testTime(){
        assertTrue(InputValidation.timeRegexMatch("10:00 pm"));
        assertTrue(InputValidation.timeRegexMatch("12:00 Pm"));
        assertTrue(InputValidation.timeRegexMatch("12:00aM"));
        assertTrue(InputValidation.timeRegexMatch("2:59Pm"));
        assertFalse(InputValidation.timeRegexMatch("00:00 pm"));
        assertFalse(InputValidation.timeRegexMatch("13:00 am"));
        assertFalse(InputValidation.timeRegexMatch("00:00 am"));
        assertFalse(InputValidation.timeRegexMatch("2:60 pm"));

    }

}