package main;

import bouquet.Bouquet;
import flowers.Flower;
import logging.MyLogger;
import сommand.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Menu {
    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    public static void choice() throws Exception {
        try {
            System.out.println("Choose how fill in data: 1-from file, 2-current data.");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                readFromFile();
                return;
            }
            if (choice == 2) {
                data();
                return;
          } else if ((choice != 1) && (choice != 2))
                throw new Exception();
        } catch (Exception o) {
            String mes = logger.getLevel()+" "+logger.getName()
                    +" method choice().";
           MyLogger.severeLog(logger, mes);
           choice();
       }
    }

    public static void menu(Client client) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\tChoose action on the bouquet:\n1. Add decoration.\n2. Calculate bouquet cost.\n3. " +
                "Sort by freshness.\n4. Show bouquet.\n5. Find by range of stem.\nExit - 0.");
        int choice = -1;
        while (choice != 0) {

            System.out.print("Enter command: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case (1):
                        client.addDecoration();
                        break;
                    case (2):
                        client.calculateBouquetCost();
                        break;
                    case (3):
                        client.sortByFreshness();
                        break;
                    case (4):
                        client.showBouquet();
                        break;
                    case (5):
                        client.findByStem();
                        break;
                    default:
                        choice = 0;
                        break;
                }
            } catch (Exception o) {
                String mes = logger.getLevel() +" "+ logger.getName()
                        +" method menu().";
                MyLogger.severeLog(logger, mes);
                menu(client);
            }
        }
    }

    public static void readFromFile() throws Exception {
        List<Flower> flowers = new ArrayList<>();
        File file = new File("test");
        FileReader fr= new FileReader("test");
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()) {
            String name = scan.next();
            String fresh = scan.next();
            String price = scan.next();
            String len = scan.next();
            Flower flw = new Flower(name, Integer.parseInt(fresh), Integer.parseInt(price), Integer.parseInt(len));
            flowers.add(flw);
        }
        fr.close();
        Bouquet bouquet = new Bouquet(flowers);
        service(bouquet);
}

    public static void data() throws Exception {
        List<Flower> flowers = new ArrayList<>();
        Flower flw1 = new Flower("LILY", 12, 60, 50);
        Flower flw2 = new Flower("ROSE", 5, 30, 60);
        Flower flw3 = new Flower("TULIP", 11, 20, 40);
        Flower flw4 = new Flower("CHAMOMILE", 9, 21, 37);
        Flower flw5 = new Flower("VIOLET", 3, 22, 30);
        flowers.add(flw1);
        flowers.add(flw2);
        flowers.add(flw3);
        flowers.add(flw4);
        flowers.add(flw5);
        Bouquet bouquet = new Bouquet(flowers);
        service(bouquet);
    }

    public static void service(Bouquet bouquet) throws Exception {
        Client client = new Client(new AddDecorationCommand(bouquet), new FindByStemCommand(bouquet),
                new CalculateBouquetCostCommand(bouquet), new ShowBouquetCommand(bouquet),
                new SortByFreshnessCommand(bouquet));
        menu(client);
    }
}
