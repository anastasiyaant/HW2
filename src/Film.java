import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class Film implements java.io.Serializable{
    private String header;
    private Set<String> actors;

    public Film(String header, Set<String> actors) {
        this.header = header;
        this.actors = actors;
    }

    public Film(String header) {
        this.header = header;
        this.actors = new HashSet<>();
    }

    public void setHeader( String header) { this.header= header; }
    public void setActors(Set<String> actors)
    {
        this.actors=actors;
    }

    public void addActor(String actor){
        if (actors.contains(actor)) {
            System.out.println("Actor is already in this film");
        }else
        actors.add(actor);
    }

    public void deleteActor(String actor){
        if (actors.contains(actor)) {
            actors.remove(actor);
        }else
            System.out.println("Actor is not in this film");
    }

    public String getHeader() {
        return this.header;
    }

    public Set<String> getActors() {
        return this.actors;
    }

}
