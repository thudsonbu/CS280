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

public class JsonParseTest {
    private static final String filePath = "C:\\Users\\Tom Hudson\\cs280\\JSON\\test.json";

    public JsonParseTest() {
    }

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("C:\\Users\\Tom Hudson\\cs280\\JSON\\test.json");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);
            String firstName = (String)jsonObject.get("firstname");
            System.out.println("The first name is: " + firstName);
            long id = (Long)jsonObject.get("id");
            System.out.println("The id is: " + id);
            JSONArray lang = (JSONArray)jsonObject.get("languages");

            for(int i = 0; i < lang.size(); ++i) {
                System.out.println("The " + i + " element of the array: " + lang.get(i));
            }

            Iterator i = lang.iterator();

            JSONObject structure;
            while(i.hasNext()) {
                structure = (JSONObject)i.next();
                System.out.println("language " + structure.get("lang") + " with level " + structure.get("knowledge"));
            }

            structure = (JSONObject)jsonObject.get("job");
            System.out.println("job object name: " + structure.get("name"));
            System.out.println("job object site: " + structure.get("site"));
        } catch (FileNotFoundException var10) {
            var10.printStackTrace();
        } catch (IOException var11) {
            var11.printStackTrace();
        } catch (ParseException var12) {
            var12.printStackTrace();
        } catch (NullPointerException var13) {
            var13.printStackTrace();
        }

    }
}
