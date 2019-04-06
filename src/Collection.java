import java.util.*;
import java.io.*;

public class Collection implements java.io.Serializable {
    Map<String, String> hashMap = new HashMap<String, String>();

    public Collection(){
        putCollection();
    }

    public void changeActor(String film, String actor){
        if (hashMap.containsKey(film))
        hashMap.replace(film, actor);
        else System.out.println("Film doesn't exist. Firstly add it in collection");
    }

    public void delFilm(String film){
        if (hashMap.containsKey(film))
        hashMap.remove(film);
        else System.out.println("Film doesn't exist.");
    }

    public void addFilm(String film, String actor){
        if (hashMap.containsKey(film))
            System.out.println("Film is already exist. You can change it");
        else hashMap.put(film, actor);
    }

    public String getActor(String film){
        if (hashMap.containsKey(film))
        return hashMap.get(film);
        else {
            System.out.println("Film doesn't exist.");
            return null;
        }
    }

    public void printCollection(){
        for (String k:hashMap.keySet()){
            System.out.println(k + " : " + hashMap.get(k));
        }
    }
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("filmCollection.dat")))
        {
            Collection collection1 = new Collection();
            oos.writeObject(collection1);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void putCollection(){
        hashMap.put( "Красотка", "Джулия Робертс");
        hashMap.put( "Турист", "Джонни Депп");
        hashMap.put( "Джонни Д.", "Джонни Депп");
        hashMap.put( "Матрица", "Киану Ривз");
        hashMap.put( "Сладкий ноябрь", "Киану Ривз");
        hashMap.put( "Богемская рапсодия", "Рами Малек");
    }


}
