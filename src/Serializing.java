import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Serializing {
    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("filmCollection.dat"));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("filmCollection2.dat")))
        {
            //deserializing
            FilmLibrary collection1=(FilmLibrary) ois.readObject();
            collection1.printFilmLibrary();
            Set<String> actorsFilm1 = new HashSet<>();
            actorsFilm1.add("Джонни Депп");
            collection1.addFilm("Пираты карибского моря 1", actorsFilm1);
            collection1.addActor("Пираты карибского моря 1", "Кира Найтли");
            collection1.addActor("Пираты карибского моря 1", "Кира Найтли");
            System.out.println(collection1.getActors("Пираты карибского моря 1"));
            collection1.deleteActor("Пираты карибского моря 1", "Кира Найтли");
            System.out.println(collection1.getActors("Пираты карибского моря 1"));
            collection1.delFilm("Пираты карибского моря 1");
            collection1.printFilmLibrary();

            //serializing
            oos.writeObject(collection1);

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        }
}
