import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {

    @Test

    public void testParseDataOneItem() throws Exception {
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main main = new Main();
        main.parseData(rawData);

        String expectedOutput = "Name: milk\nPrice: 3.23\nType: food\nExpiration: 1/25/2016\n";
        assertEquals(expectedOutput, outContent.toString());
    }



}