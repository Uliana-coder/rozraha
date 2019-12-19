package bouquet;
import flowers.Flower;
import logging.MyLogger;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class Bouquet implements Decoration{
    private List<Flower> bouquet;
    private int fullCost = 0;
    private String decoration;
    private int decorPrice;
    private int maxStem = 0;
    private int minStem = 0;

    Logger logger=Logger.getLogger(String.valueOf(Bouquet.class));

    public Bouquet(){}
    public Bouquet(List<Flower> bouquet) {
        this.bouquet = bouquet;
    }


    public void setDecoration(String decor) {
        decoration = decor;
    }

    public List<Flower> getFlowersList() {
        return bouquet;
    }

    /**
     * add flower to bouquet
     *
     * @param flw contains a flower that we add to the bouquet
     */
    public void addFlower(Flower flw) {
        bouquet.add(flw);
    }

    /**
     * removes a flower from the list
     *
     * @param indexFlower contains the index value of the object in the list to be deleted
     */
    public void removeFlower(int indexFlower) {
        bouquet.remove(indexFlower);
    }

    /**
     * The method returns the flower object from the bouquet by index in the list
     *
     * @param itemIndex contains the index value in the list
     * @return returns a flower object
     */
    public Flower getFlowerByItemIndex(int itemIndex) {
        return bouquet.get(itemIndex);
    }

    /**
     * The method returns the number of flowers in the bouquet
     *
     * @return the number of flowers in the bouquet
     */
    public int getFlowersBouquetCount() {
        return this.bouquet.size();
    }

    public int getFullCost() {
        return fullCost;
    }
    public List<Flower> getBouquet(){
        return bouquet;
    }

    String getWrapper() {
        return wrapper;
    }

    String getRibbon() {
        return ribbon;
    }
    public void setMinStem(int minStem) {
        this.minStem = minStem;
    }

    public void setMaxStem(int maxStem) {
        this.maxStem = maxStem;
    }

    public void addDecoration() throws Exception {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("What decoration would you like to add?");
            MyLogger.infoLog(logger);
            logger.info("(1 - wrapper, 2 - ribbon)");
            int in = sc.nextInt();
            if (in == 1) {
                setDecoration(this.wrapper);
                decorPrice = wrapperPrice;
                System.out.println("The wrapped is added./n");
                return;
            } else if (in == 2) {
                setDecoration(this.ribbon);
                decorPrice = ribbonPrice;
                System.out.println("The ribbon is added./n");
                return;
            } else if((in!=1)&&(in!=2)){
                throw new Exception();
            }
        }catch (Exception o){
            String mes = "You enter wrong data. Name of class: "+logger.getName()
                    +" method addDecoration().";
            MyLogger.severeLog(logger, mes);
            addDecoration();
        }
    }

    public void calculateBouquetCost() {
        int tmpCost =  0;

        if (bouquet.size() > 0) {
            for (Flower flower : bouquet) {
                tmpCost += flower.getPrice();
            }
        }
        this.fullCost = tmpCost + decorPrice;
        System.out.println("Price of your bouquet: " + fullCost + "$");
    }

    public void inputMinMaxLenOfStem() throws Exception {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter range of stem:");
            minStem = in.nextInt();
            maxStem = in.nextInt();
         if ((minStem < 0) || (maxStem < 0)) {
        throw new Exception();
        }
        } catch(Exception o){
            String mes = logger.getLevel()+" "+logger.getName()
                    +" method addDecoration().";
            MyLogger.severeLog(logger, mes);
            inputMinMaxLenOfStem();
        }
    }

    //search flowers for range of length of stem
    public void findByStem() throws Exception {
        inputMinMaxLenOfStem();
        System.out.println("Your range [" + minStem + ";" + maxStem + "]");
        for (Flower flw : bouquet) {
            if (flw.getLengthOfTheStem() >= minStem && flw.getLengthOfTheStem() <= maxStem) {
                System.out.println(flw.getName() + " " + flw.getLengthOfTheStem() + " sm");
            }
        }
    }

    public void sortByFreshness() throws IOException {
        Collections.sort(bouquet);
        logger.info("Flowers is sorted.");
        MyLogger.infoLog(logger);
    }

    public void showBouquet() {
        int i = 1;
        for (Flower flw : bouquet) {
            System.out.println(++i + ". " + flw.getName()
                    + "   freshness: " + flw.getFreshness() + " hours"
                    + "   price of one flower: " + flw.getPrice()
                    + "   length of stem: " + flw.getLengthOfTheStem()+" sm");
        }
    }

}
