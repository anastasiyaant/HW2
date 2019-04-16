import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FilmTest {

    @Test
    public void isSetHeaderTest() {
        FilmLibrary collection1 = new FilmLibrary();
        collection1.addFilm("Матрица");
        boolean isExist = false;
        for (Film f:collection1.films){
            if (f.getHeader().equals("Матрица")){
                isExist = true;
            }
        }
        Assert.assertTrue(isExist);
    }

    @Test
    public void isSetActorsTest() {
        FilmLibrary collection1 = new FilmLibrary();
        Set<String> actorsFilm1 = new HashSet<>();
        actorsFilm1.add("Джонни Депп");
        actorsFilm1.add("Анджелина Джолли");
        actorsFilm1.add("Пол Беттани");
        collection1.addFilm("Num2", actorsFilm1);
        Assert.assertTrue(actorsFilm1.equals(collection1.getActors("Num2")));
    }

    @Test
    public void isAddActorTest() {
        FilmLibrary collection1 = new FilmLibrary();
        collection1.addFilm("Матрица");
        collection1.addActor("Матрица", "Киану Ривз");
        Assert.assertTrue(collection1.getActors("Матрица").contains("Киану Ривз"));
    }

    @Test
    public void isDeletedActorTest() {
        FilmLibrary collection1 = new FilmLibrary();
        Set<String> actorsFilm1 = new HashSet<>();
        actorsFilm1.add("Киану Ривз");
        collection1.addFilm("Матрица", actorsFilm1);
        collection1.deleteActor("Матрица", "Киану Ривз");
        Assert.assertFalse(collection1.getActors("Матрица").contains("Киану Ривз"));
    }

}