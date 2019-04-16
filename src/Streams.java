import java.io.*;
import java.util.*;


public class Streams {
    private static final String keywords[] = { "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while" };
    private static  List<String> keywordsList = Arrays.asList(keywords);
    public static int keywordsNum = 0;


    public static void byteStream(String inputFilename, String outputFilename){
        keywordsNum = 0;
        try (FileInputStream input = new FileInputStream(inputFilename);
             FileOutputStream output = new FileOutputStream(outputFilename)) {
        int data;
        while ((data=input.read())!=-1){
            String word = "";
            String punct = ".;()[]:!&|?&*^~/";
            while (data!=-1&&(char)data!=' '&&!punct.contains(Character.toString((char)data))){
                if (Character.isLetter((char)data)||Character.isDigit((char)data)){
                    word=word+(char)data;
                }
                data=input.read();
            }
            if (keywordsList.contains(word)){
                byte[] text = word.getBytes();
                output.write(text, 0, text.length);
                String lineSeparator = System.getProperty("line.separator");
                output.write(lineSeparator.getBytes());
                keywordsNum++;
            }
        }
        byte[] size = ("Size is " + Integer.toString(keywordsNum)).getBytes();
        output.write(size, 0, size.length);
        output.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void textStream(String inputFilename, String outputFilename){
        keywordsNum = 0;
        String s;
        try (BufferedReader input = new BufferedReader(new FileReader(inputFilename));
            BufferedWriter output = new BufferedWriter( new FileWriter(outputFilename))){
            while ((s = input.readLine()) != null) {
                String[] stringParts = s.split("[\\s\\,\\(\\)\\.]");
                for (String part: stringParts){
                    if (keywordsList.contains(part)){
                        output.write(part);
                        output.newLine();
                        keywordsNum++;
                    }
                }
            }
            output.write("Size is " +keywordsNum);
            output.flush();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
