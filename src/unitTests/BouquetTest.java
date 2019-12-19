package unitTests;
import  bouquet.Bouquet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import flowers.Flower;
import org.junit.Assert;
import org.junit.Test;

public class BouquetTest {
    @Test
    public void calculateBouquetCost() {
        List<Flower> flowers = new ArrayList<>();
        Flower flw1 = new Flower("LILY", 12, 60, 50);
        Flower flw2 = new Flower("ROSE", 5, 30, 60);
        Flower flw3 = new Flower("TULIP", 11, 20, 40);
        flowers.add(flw1);
        flowers.add(flw2);
        flowers.add(flw3);
        Bouquet bouquet=new Bouquet(flowers);
        bouquet.calculateBouquetCost();
        int expected=bouquet.getFullCost();
        int actual=110;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortByFreshness() throws IOException {
        List<Flower> flowers = new ArrayList<>();
        Flower flw1 = new Flower("LILY", 12, 60, 50);
        Flower flw2 = new Flower("ROSE", 5, 30, 60);
        Flower flw3 = new Flower("TULIP", 11, 20, 40);
        flowers.add(flw1);
        flowers.add(flw2);
        flowers.add(flw3);
        Bouquet bouquet=new Bouquet(flowers);
        bouquet.sortByFreshness();
        List<Flower> expected =bouquet.getFlowersList() ;
        List<Flower> actual = new ArrayList<>();
        actual.add(flw2);
        actual.add(flw3);
        actual.add(flw1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addFlower() {
        List<Flower> flowers = new ArrayList<>();
        Flower flw1 = new Flower("LILY", 12, 60, 50);
        Flower flw2 = new Flower("ROSE", 5, 30, 60);
        Flower flw3 = new Flower("TULIP", 11, 20, 40);
        Bouquet bouquet=new Bouquet(flowers);
        bouquet.addFlower(flw1);
        bouquet.addFlower(flw2);
        bouquet.addFlower(flw3);
        List<Flower> expected=bouquet.getBouquet();
        List<Flower> actual=new ArrayList<>();
        actual.add(flw1);
        actual.add(flw2);
        actual.add(flw3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeFlower() {
        List<Flower> flowers = new ArrayList<>();
        Flower flw1 = new Flower("LILY", 12, 60, 50);
        Flower flw2 = new Flower("ROSE", 5, 30, 60);
        Flower flw3 = new Flower("TULIP", 11, 20, 40);
        flowers.add(flw1);
        flowers.add(flw2);
        flowers.add(flw3);
        Bouquet bouquet=new Bouquet(flowers);
        bouquet.removeFlower(2);
        List<Flower> expected=bouquet.getBouquet();
        List<Flower> actual=new ArrayList<>();
        actual.add(flw1);
        actual.add(flw2);
        actual.add(flw3);
        actual.remove(2);
        Assert.assertEquals(expected,actual);
    }
}
