import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class MainFilmLibrary {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("filmCollection.dat")))
        {
            FilmLibrary collection1 = new FilmLibrary();
            Set<String> actorsFilm1 = new HashSet<>();
            actorsFilm1.add("Джонни Депп");
            actorsFilm1.add("Анджелина Джолли");
            actorsFilm1.add("Пол Беттани");
            collection1.addFilm("Турист", actorsFilm1);
            Set<String> actorsFilm2 = new HashSet<>();
            actorsFilm2.add("Рами Малек");
            actorsFilm2.add("Бен Харди");
            collection1.addFilm("Богемская рапсодия", actorsFilm2);
            collection1.addFilm("Красотка");
            collection1.printFilmLibrary();
            oos.writeObject(collection1);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
