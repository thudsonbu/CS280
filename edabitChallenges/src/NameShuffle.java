import java.util.ArrayList;

public class NameShuffle {
    public static String nameShuffle(String name) {
        String[] splitName = name.split(" ");
        String newName = splitName[1] + " " + splitName[0];
        return newName;
    }

    public static void main(String[] args){
        String newName = nameShuffle("Thomas Hudson");
        System.out.println(newName);
    }
}
