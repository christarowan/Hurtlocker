import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
;


public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public void parseData(String rawData) {
        String regexPattern = "(?i)naMe:(.*?);price:(\\d+\\.\\d+);type:(.*?);expiration:(\\d{1,2}/\\d{1,2}/\\d{4})[##^%*;]";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(rawData);

        Map<String, String> keyValuePairs = new HashMap<>();


        while (matcher.find()) {
            String name = matcher.group(1);
            String price = matcher.group(2);
            String type = matcher.group(3);
            String expiration = matcher.group(4);

            name = name.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
            price = price.replaceAll("[^\\d.]", "").toLowerCase();
            type = type.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
            expiration = expiration.replaceAll("[^\\d/\\s]", "");

            keyValuePairs.put("name", name);
            keyValuePairs.put("price", price);
            keyValuePairs.put("type", type);
            keyValuePairs.put("expiration", expiration);


            System.out.println("Name: " +  name);
            System.out.println("Price: " + price);
            System.out.println("Type: " + type);
            System.out.println("Expiration: " + expiration);
        }
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);




    }
}
