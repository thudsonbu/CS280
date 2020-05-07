//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParseMenu {
    private static final String filePath = "C:\\Users\\Tom Hudson\\cs280\\JSON\\menu.json";

    public JsonParseMenu() {
    }

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("C:\\Users\\Tom Hudson\\cs280\\JSON\\menu.json");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);
            JSONObject menu = (JSONObject)jsonObject.get("menu");
            String header = (String)menu.get("header");
            System.out.println(header);
            JSONArray items = (JSONArray)menu.get("items");

            for(int i = 0; i < items.size(); ++i) {
                JSONObject element = (JSONObject)items.get(i);
                String id = (String)element.get("id");
                String label = (String)element.get("label");
                if (label == null) {
                    label = id;
                }

                System.out.printf("%5d.     %-15s %-25s%n", i + 1, id, label);
            }
        } catch (FileNotFoundException var11) {
            var11.printStackTrace();
        } catch (IOException var12) {
            var12.printStackTrace();
        } catch (ParseException var13) {
            var13.printStackTrace();
        } catch (NullPointerException var14) {
            var14.printStackTrace();
        }

    }
}