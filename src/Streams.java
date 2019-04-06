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
    private static  List<String> keywordsList = new  ArrayList<>();
    public int keywordsNum = 0;

    public Streams(){
        keywordsList = Arrays.asList(keywords);
    }

    public void ByteStream(String input_filename, String output_filename){
        keywordsNum = 0;
        try (FileInputStream input = new FileInputStream(input_filename);
             FileOutputStream output = new FileOutputStream(output_filename)) {
        int data;
        while ((data=input.read())!=-1){
            String word = "";
            String punct = ".;()[]:!&|?&*^~/";
            while (data!=-1&&(char)data!=' '&&!punct.contains(Character.toString((char)data))){
                if (Character.isLetter((char)data)){
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
        throw new RuntimeException(e);
        }
    }


    public void textStream(String input_filename, String output_filename){
        keywordsNum = 0;
        String s;
        try (BufferedReader input = new BufferedReader(new FileReader(input_filename));
            BufferedWriter output = new BufferedWriter( new FileWriter(output_filename))){
            while ((s = input.readLine()) != null) {
                for (String key: keywordsList){
                    if (s.contains(key)){
                        output.write(key);
                        output.newLine();
                        keywordsNum++;
                    }
                }
            }
            output.write("Size is " +keywordsNum);
            output.flush();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        public static void main(String[] args) {
        Streams n = new Streams();
        n.ByteStream("C:\\Users\\Анастасия\\IdeaProjects\\main.java", "C:\\Users\\Анастасия\\IdeaProjects\\result1.java");
        n.textStream("C:\\Users\\Анастасия\\IdeaProjects\\main.java", "C:\\Users\\Анастасия\\IdeaProjects\\result2.java");
    }
}
