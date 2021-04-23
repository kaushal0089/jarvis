package in.kkd.collectionconcept;
import com.google.gson.*;

import java.io.File;
import java.io.*;
import java.util.Map;
import java.util.Set;

public class JsonParsing {

    public JsonParsing() throws FileNotFoundException {
    }

    public static void main(String[] str) throws FileNotFoundException {

        File f = new File("C:\\Users\\kaushal.kanjariya\\IdeaProjects\\newtest\\jarvis\\src\\main\\java\\in\\kkd\\collectionconcept\\data.json");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        JsonParser jsonParser = new JsonParser();
        JsonObject element = (JsonObject) jsonParser.parse(br);
        //	    	result.addCommand(defaultcommand);
//        JsonObject obj = element.getAsJsonObject(); //since you know it's a JsonObject
//    Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();
        System.out.println(element.toString());
    }

    File f = new File("C:\\Users\\kaushal.kanjariya\\IdeaProjects\\newtest\\jarvis\\src\\main\\java\\in\\kkd\\collectionconcept\\data.json");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    JsonParser jsonParser = new JsonParser();
//    JsonObject element = (JsonObject) JsonParser.parse(br);

}
