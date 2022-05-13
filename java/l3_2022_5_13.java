import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class l3_2022_5_13 {
    public static void main(String[] args) {
        String sourceFileDir = "C:\\Users\\Qiacr\\Documents\\temp.txt";
        File f = new File(sourceFileDir);
        Reader reader = null;
        int tempChar;
        String result = "";
        FileOutputStream fsOut = null;
        try {
            reader = new InputStreamReader(new FileInputStream((f)), "UTF-8");
            while ((tempChar = reader.read()) != -1) {
                result += (char) tempChar;
            }
            File newFile = new File("D:\\a.txt");
            fsOut = new FileOutputStream(newFile);
            fsOut.write(result.getBytes());
            reader.close();
            fsOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
