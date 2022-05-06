import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    @Test
    void testCheckNumber() {
        Assertions.assertTrue(InputValidation.checkNumber("555-555-5555"));
        Assertions.assertTrue(InputValidation.checkNumber("4444444444"));
        Assertions.assertTrue(InputValidation.checkNumber("404 320 1234"));
        Assertions.assertFalse(InputValidation.checkNumber("222"));
        Assertions.assertFalse(InputValidation.checkNumber("(4043)2071234"));
        Assertions.assertTrue(InputValidation.checkNumber("(443)201-9234"));
        Assertions.assertTrue(InputValidation.checkNumber("(777)-231-8821"));
    }

}