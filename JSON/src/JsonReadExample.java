//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReadExample {
    public JsonReadExample() {
    }

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\Tom Hudson\\cs280\\JSON\\test.json"));
            JSONObject jsonObject = (JSONObject)obj;
            String name = (String)jsonObject.get("name");
            System.out.println(name);
            long age = (Long)jsonObject.get("age");
            System.out.println(age);
            JSONArray msg = (JSONArray)jsonObject.get("messages");
            Iterator iterator = msg.iterator();

            while(iterator.hasNext()) {
                System.out.println((String)iterator.next());
            }
        } catch (FileNotFoundException var9) {
            var9.printStackTrace();
        } catch (IOException var10) {
            var10.printStackTrace();
        } catch (ParseException var11) {
            var11.printStackTrace();
        }

    }
}

