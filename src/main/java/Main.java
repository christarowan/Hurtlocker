import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
        String regexPattern = "(?i)naMe:(.*?);price:(.*?);type:(.*?);expiration:(.*?)[##^%*;]";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(rawData);

        int exceptionCount = 0;

        while (matcher.find()) {
            try {
            String name = matcher.group(1);
            String price = matcher.group(2);
            String type = matcher.group(3);
            String expiration = matcher.group(4);

            name = name.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
            price = price.replaceAll("[^\\d.]", "").toLowerCase();
            type = type.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
            expiration = expiration.replaceAll("[^\\d/\\s]", "");

            String formattedOutput = String.format("Name: %s, Price: %s, Type: %s, Expiration: %s",
                    name, price, type, expiration);
            System.out.println(formattedOutput);


            } catch (IndexOutOfBoundsException e) {
                exceptionCount++;
            }
        }
      //  System.out.println(exceptionCount);
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
        Main main = new Main();
        main.parseData(output);


    }
}
