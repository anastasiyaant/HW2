import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

public class StreamsTest {

    @Test
    public void byteStream() {
        Streams n = new Streams();
        n.ByteStream("C:\\Users\\Анастасия\\IdeaProjects\\main.java", "C:\\Users\\Анастасия\\IdeaProjects\\result1.java");
        boolean condition = true;
        try (BufferedReader res = new BufferedReader(new FileReader("C:\\Users\\Анастасия\\IdeaProjects\\result1.java"));
             BufferedReader exp = new BufferedReader(new FileReader("C:\\Users\\Анастасия\\IdeaProjects\\expected1.java"))) {
            String sRes, sExp;
            while (((sRes = res.readLine()) != null) && ((sExp = exp.readLine()) != null)) {
                if (!sRes.equals(sExp)) condition = false;
            }
            Assert.assertTrue(condition);
        }
    catch(IOException e) {
        throw new RuntimeException(e);
    }
    }

    @Test
    public void textStream() {
        Streams n = new Streams();
        n.textStream("C:\\Users\\Анастасия\\IdeaProjects\\main.java", "C:\\Users\\Анастасия\\IdeaProjects\\result2.java");
        boolean condition = true;
        try (BufferedReader res = new BufferedReader(new FileReader("C:\\Users\\Анастасия\\IdeaProjects\\result2.java"));
             BufferedReader exp = new BufferedReader(new FileReader("C:\\Users\\Анастасия\\IdeaProjects\\expected2.java"))) {
            String sRes, sExp;
            while (((sRes = res.readLine()) != null) && ((sExp = exp.readLine()) != null)) {
                if (!sRes.equals(sExp)) condition = false;
            }
            Assert.assertTrue(condition);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}