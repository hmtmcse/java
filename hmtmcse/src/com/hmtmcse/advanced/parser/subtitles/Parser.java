package com.hmtmcse.advanced.parser.subtitles;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hmtmc on 09/12/2016.
 */
public class Parser {


    public static Map<String,String> words = new HashMap<String, String>();
    public static String storeFile = "IELTS_OFFICIAL_1_8.ser";

    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\hmtmc\\Downloads\\srt\\2.srt");
        File file = new File("/home/hmtmcse/Downloads/srt/9.srt");
        if (!file.exists()) {
            System.out.println("File Not Exists");
        }

        words = pullFromStore();
        if (words == null){
            words = new HashMap<String, String>();
        }

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("") && !isNumeric(line) && !line.contains("-->")){
                    line = cleanSentence(line);
                    makeUniq(line);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception From File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception From IO Operation");
            e.printStackTrace();
        }

//        Map<String, String> treeMap = new TreeMap<String, String>(words);
        Map<String, String> treeMap = words;
        store(treeMap);
        Integer i = 1;
        for (Map.Entry<String, String> entry : treeMap.entrySet()){
//            System.out.println("|" + entry.getValue() + "|");
            System.out.println(entry.getValue());
            i++;
        }

        System.out.println("Total Words = " + i);

    }

    public static void makeUniq(String sentance){
      String []split = sentance.split(" ");
      String key,word;
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher;
      for (int i = 0; i < split.length; i++){
          word = split[i];
          matcher = pattern.matcher(word);
          if (matcher.matches()){
              key = hasKey(word);
              if (words.get(key) == null){
                  words.put(key,word.toLowerCase());
              }
          }
      }
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()){
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static String cleanSentence(String sentence){
        sentence = sentence.replaceAll("- |<i>|</i>","");
        return sentence.replaceAll("[!?,().\"=]", "");
    }

    public static String hasKey(String sentence){
        return sentence.replaceAll("[-':;\\$]", "").toLowerCase();
    }

    public static void store(Map<String, String> treeMap) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(storeFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.printf("Serialized HashMap data is saved in hashmap.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static Map<String, String>  pullFromStore() {
        Map<String, String> map = null;
        try {
            FileInputStream fis = new FileInputStream(storeFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (Map<String, String>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            return null;
        }
        return map;
    }

}
