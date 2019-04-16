import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FilmLibraryTest {

    @Test
    public void isDeletedFilmTest() {
        FilmLibrary collection1 = new FilmLibrary();
        Set<String> actorsFilm1 = new HashSet<>();
        actorsFilm1.add("Джонни Депп");
        actorsFilm1.add("Анджелина Джолли");
        actorsFilm1.add("Пол Беттани");
        collection1.addFilm("Турист", actorsFilm1);
        collection1.delFilm("Турист");
        boolean isExist = false;
        for (Film f:collection1.films){
            if (f.getHeader().equals("Турист 1")){
                isExist = true;
            }
        }
        Assert.assertFalse(isExist);
    }

    @Test
    public void isAddedFilmTest() {
        FilmLibrary collection1 = new FilmLibrary();
        Set<String> actorsFilm1 = new HashSet<>();
        actorsFilm1.add("Джонни Депп");
        actorsFilm1.add("Анджелина Джолли");
        actorsFilm1.add("Пол Беттани");
        collection1.addFilm("Турист 1", actorsFilm1);
        boolean isAdded = false;
        for (Film f:collection1.films){
            if (f.getHeader().equals("Турист 1")){
                isAdded = true;
            }
        }
        Assert.assertTrue(isAdded);
    }

}