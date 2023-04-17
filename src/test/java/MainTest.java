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

        String expectedOutput = "Name: milk\nPrice: 3.23\nType: food\nExpiration: 1/25/2016\n";
        assertEquals(expectedOutput, outContent.toString());
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


}




