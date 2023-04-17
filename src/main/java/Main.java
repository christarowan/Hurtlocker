import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
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

        while (matcher.find()) {
            String name = matcher.group(1);
            String price = matcher.group(2);
            String type = matcher.group(3);
            String expiration = matcher.group(4);

            System.out.println("Name: " + name);
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
