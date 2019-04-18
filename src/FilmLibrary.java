import java.util.*;
import java.io.*;

public class FilmLibrary implements java.io.Serializable {
    List<Film> films = new ArrayList<>();

    public boolean addActor(String film, String actor){
        for (Film findFilm:films)
            if (findFilm.getHeader().equals(film)) {
                return findFilm.addActor(actor);
            }

        System.out.println("Film doesn't exist. Firstly add it in collection");
            return false;
    }


    public boolean deleteActor(String film, String actor){
        for (Film findFilm:films){
            if (findFilm.getHeader().equals(film)){
                return findFilm.deleteActor(actor);
            }
        }
        System.out.println("Film doesn't exist. Firstly add it in collection");
        return false;
    }

    public boolean delFilm(String film){
        for (Film findFilm:films){
            if (findFilm.getHeader().equals(film)){
                return films.remove(findFilm);
            }
        }
        System.out.println("Film doesn't exist. Firstly add it in collection");
        return false;
    }

    public boolean addFilm(String film, Set<String> actors){
        if (!films.add(new Film(film, actors))){
            System.out.println("Film is already exist");
            return false;
        }
        return true;
    }

    public boolean  addFilm(String film){
        if (!films.add(new Film(film))){
            System.out.println("Film is already exist");
            return false;
        }
        return true;
    }

    public Set getActors(String film){
        for (Film findFilm:films){
            if (findFilm.getHeader().equals(film)){
                return findFilm.getActors();
            }
        }
        System.out.println("Film doesn't exist.");
        return null;
    }

    public void printFilmLibrary(){
        for (Film film:films){
            System.out.println(film.getHeader() + " : " + film.getActors());
        }
    }

}
