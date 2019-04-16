import java.util.*;
import java.io.*;

public class FilmLibrary implements java.io.Serializable {
    ArrayList<Film> films = new ArrayList<>();

    public void addActor(String film, String actor){
        for (Film findFilm:films)
            if (findFilm.getHeader().equals(film)) {
                findFilm.addActor(actor);
                return;
            }
        System.out.println("Film doesn't exist. Firstly add it in collection");
    }


    public void deleteActor(String film, String actor){
        for (Film findFilm:films){
            if (findFilm.getHeader().equals(film)){
                findFilm.deleteActor(actor);
                return;
            }
        }
        System.out.println("Film doesn't exist. Firstly add it in collection");
    }

    public void delFilm(String film){
        for (Film findFilm:films){
            if (findFilm.getHeader().equals(film)){
                films.remove(findFilm);
                return;
            }
        }
        System.out.println("Film doesn't exist. Firstly add it in collection");
    }

    public void addFilm(String film, Set<String> actors){
        if (!films.add(new Film(film, actors))){
            System.out.println("Film is already exist");
        }
    }

    public void addFilm(String film){
        if (!films.add(new Film(film))){
            System.out.println("Film is already exist");
        }
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
        for (Film f:films){
            System.out.println(f.getHeader() + " : " + f.getActors());
        }
    }

}
