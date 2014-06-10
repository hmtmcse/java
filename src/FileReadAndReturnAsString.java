import java.io.*;

/**
 * Created by H.M.Touhid Mia on 6/10/2014.
 */
public class FileReadAndReturnAsString {


    public static void main(String[] args) {
        FileReadAndReturnAsString fileReadAndReturnAsString = new FileReadAndReturnAsString();
        String file = fileReadAndReturnAsString.readAndReturnString("C:\\x.txt");
        System.out.println(file);
    }


    public String readAndReturnString(String location) {

        /** Is File Exists */
        File file = new File(location);
        if (!file.exists()) {
            System.out.println("File Not Exists");
            return null;
        }


        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception From File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception From IO Operation");
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
