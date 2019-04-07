import java.io.*;

public class Serializing {
    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("filmCollection.dat"));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("filmCollection2.dat")))
        {
            //deserializing
            Collection collection1=(Collection) ois.readObject();
            collection1.printCollection();
            collection1.addFilm("Пираты карибского моря 1", "Джонни Депп");
            collection1.addFilm("Пираты карибского моря 1", "Джонни Депп");
            collection1.changeActor("Турист", "Анджелина Джоли");
            collection1.changeActor("Турист2", "Анджелина Джоли");
            collection1.delFilm("Пираты карибского моря 1");
            collection1.delFilm("Пираты карибского моря 1");
            System.out.println("\n");
            collection1.printCollection();

            //serializing
            oos.writeObject(collection1);

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        }
}
