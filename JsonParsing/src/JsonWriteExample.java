//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriteExample {
    public JsonWriteExample() {
    }

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name", "Joe DePloy");
        obj.put("age", new Integer(39));
        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");
        obj.put("messages", list);

        try {
            FileWriter file = new FileWriter("C:\\Users\\Tom Hudson\\cs280\\JSON\\test.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        System.out.print(obj);
    }
}

