import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonStream {
    static String user;
    static {
        try {
            user = Files.readString(Paths.get("user.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static User user1 ;
    public static String searchJson(String user){
        Pattern pattern = Pattern.compile("\\w{3,5}\\s\\d{2}");
        String[]textSearch = user.split( "\r\n",user.length());
        StringBuilder json = new StringBuilder();

        for (int i = 0; i < textSearch.length; i++) {
            Matcher matcher = pattern.matcher(textSearch[i]);

            if(matcher.matches()){
                String[] users = textSearch[i].split("\\s",textSearch[i].length());
                 user1 = new User(users[0], users[1]);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                 json.append(gson.toJson(user1)).append(",\n");
            }

        }

        return json.toString();

    }

    public static void main(String[] args) {

        System.out.println(searchJson(user));
    }


}
