import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollectionTest {

    @Test
    public void changeActor() {
        Collection collection1 = new Collection();
        collection1.addFilm("Гладиатор", "Рассел Кроу");
        collection1.changeActor("Гладиатор", "Хоакин Феникс");
        String result = collection1.getActor("Гладиатор");
        String expected = "Хоакин Феникс";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void delFilm() {
        Collection collection1 = new Collection();
        collection1.addFilm("Гладиатор", "Рассел Кроу");
        collection1.delFilm("Гладиатор");
        Assert.assertFalse(collection1.getFilm("Гладиатор"));
    }

    @Test
    public void addFilm() {
        Collection collection1 = new Collection();
        collection1.addFilm("Гладиатор", "Рассел Кроу");
        Assert.assertTrue(collection1.getFilm("Гладиатор"));
    }

    @Test
    public void getActor() {
        Collection collection1 = new Collection();
        collection1.addFilm("Гладиатор", "Рассел Кроу");
        String result = collection1.getActor("Гладиатор");
        String expected = "Рассел Кроу";
        Assert.assertEquals(result, expected);
    }

}