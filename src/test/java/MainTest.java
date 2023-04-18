import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testParseDataOneItem() throws Exception {
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main main = new Main();
        main.parseData(rawData);

        String expectedOutput = "Name: milk, Price: 3.23, Type: food, Expiration: 1/25/2016";
        assertEquals(expectedOutput, outContent.toString().trim());
    }


    @Test
    public void testPutItems() {

        Map<String, String> keyValuePairs = new HashMap<>();

        keyValuePairs.put("name", "milk");
        keyValuePairs.put("price", "3.23");
        keyValuePairs.put("type", "food");
        keyValuePairs.put("expiration", "1/25/2016");

        assertEquals("milk", keyValuePairs.get("name"));
        assertEquals("3.23", keyValuePairs.get("price"));
        assertEquals("food", keyValuePairs.get("type"));
        assertEquals("1/25/2016", keyValuePairs.get("expiration"));


        }
    @Test
    public void testSample() {
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main main = new Main();
        main.parseData(rawData);

        String expectedOutput = "";
        assertEquals(expectedOutput, outContent.toString().trim());
    }


}




