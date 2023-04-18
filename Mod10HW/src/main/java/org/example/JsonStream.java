package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
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
    public static String searchJson(String user) throws IOException, ClassNotFoundException {
        Pattern pattern = Pattern.compile("\\w{3,5}\\s\\d{2}");
        String[]textSearch = user.split( "\r\n",user.length());
        StringBuilder json = new StringBuilder(new String());

        for (int i = 0; i < textSearch.length; i++) {
            Matcher matcher = pattern.matcher(textSearch[i]);

            if(matcher.matches()){
                String[] users = textSearch[i].split("\\s",textSearch[i].length());
                user1 = new User(users[0], users[1]);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                json.append(gson.toJson(user1));

            }

        }
        
//        try (PrintWriter out = new PrintWriter(new FileWriter("user.json"))) {
//            Gson gson = new Gson();
//            String jsonString = gson.toJson(json);
//            out.write(jsonString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        OutputStream os = new FileOutputStream("user.json");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(json.toString());
        oos.flush();
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.json"));
        Object o = ois.readObject();


        return o.toString();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        System.out.println(searchJson(user));
    }


}
