import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LiquidNumber {
    static String text;
    static {
        try {
            text = Files.readString(Paths.get("nomber.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object search(String text){
        Pattern pattern = Pattern.compile("\\S\\d{3}\\S\\s\\d{3}-\\d{4}");
        Pattern pattern1 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

        String[]textSearch = text.split( "\r\n",text.length());

        String n = "";
        for (int i = 0; i < textSearch.length; i++) {
            Matcher matcher = pattern.matcher(textSearch[i]);
            Matcher matcher1 = pattern1.matcher(textSearch[i]);
            if(matcher.matches() || matcher1.matches()){
                n += textSearch[i] +"\n";
            }
        }
        return n;
    }
    public static void main(String[] args)  {
        System.out.println(search(text));
    }

}