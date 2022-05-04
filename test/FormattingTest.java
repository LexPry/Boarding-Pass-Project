import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FormattingTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void format() {
        File inFile = new File("resource\\user_data.csv");
        File outFile = new File("resource\\FormattedTicket.txt");
        assertDoesNotThrow(Formatting::format);
        assertTrue(inFile.exists());
        assertTrue(outFile.exists());

    }
}