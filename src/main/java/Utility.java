import java.io.File;
import java.io.FileWriter;

public class Utility {

    public static void writeToFile (String txt) {
        String file = System.getProperty("user.home") + File.separator + "log.txt";

        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(txt + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
