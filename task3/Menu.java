package task3;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Menu implements Serializable{
    HashMap<String, TouristPlaces> map = new HashMap<>();

    public Menu(){
    }

    private int showMenuAndGetChoice() {
        System.out.println("------MENU-------");
        System.out.println("1. Add a new Place ");
        System.out.println("2. Find a Place ");
        System.out.println("3. Rate a Place");
        System.out.println("4. Remove  a Place");
        System.out.println("5. Chek if place is open By giving its Name :");
        System.out.println("Enter your choice\n");

        return new Scanner(System.in).nextInt();

    }
    private void writeMap() throws Exception {
        String path = "C:\\Users\\shree\\IdeaProjects\\Streamliners\\src\\task3\\tour.txt"; //My file path
        FileOutputStream fileOut = new FileOutputStream(path);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(map);
        objOut.close();
        fileOut.close();
    }
    private void readMap() {
        try {
        String path = "C:\\Users\\shree\\IdeaProjects\\Streamliners\\src\\task3\\tour.txt"; //My file path
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
         HashMap<String,TouristPlaces> hashMap =(HashMap<String, TouristPlaces>)objIn.readObject();
            System.out.println(hashMap.values().toString());
         objIn.close();
        fileIn.close();
          } catch (Exception e){
            // If file is n ot Found
            map= new HashMap<>();
        }
    }

    void show() throws Exception {
        readMap();
        while (true) {
          

            int choice = showMenuAndGetChoice();
            switch (choice) {
                case 1:
                    addNewPlace();
                    break;
                case 2:
                    findPlace();
                    break;
                case 3:
                    ratePlace();
                    break;
                case 4:
                    removePlace();
                    break;
               case 5:
                    findOpenOrNot();
                    break;
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
            writeMap();

            showPlaces();
            if (wantsToExit()) {
                break;
            }
        }
    }

    private void removePlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the place you want to remove ");
        String placeName = scanner.nextLine();
        if (map.containsKey(placeName)) {
            map.remove(placeName);
            System.out.println("Place removed!!");
        } else {
            System.out.println("Place not found");
        }

    }

    private void ratePlace() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the place you want to rate :");
        String placeName = scanner.next();
        if (map.containsKey(placeName)) {
            System.out.println("Rate the place between 1-5 :");
            int rate = scanner.nextInt();
            if (rate >= 1 && rate <= 5) {
                TouristPlaces place = map.get(placeName);
                place.totalRate(rate);

            } else {
                System.out.println("Invalid input");
            }
        } else {
            System.out.println("Place not found!!");
        }

    }

    private void findPlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the place you want to find :");
        String place = scanner.nextLine();
        if (map.containsKey(place)) {
            System.out.println("Place searched");
        }
        else System.out.println("Not Found!!");

    }

    private void addNewPlace()  {
        TouristPlaces place = TouristPlaces.newPlaceFromUser();
        map.put(place.name, place);

        System.out.println("Place added");
    }
    private  void findOpenOrNot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the place you want check : ");
        String placeName = scanner.nextLine();
        if (map.containsKey(placeName)) {
            TouristPlaces place = map.get(placeName);
            if (place.isOpen())
                System.out.println("Place is Open");
            else
                System.out.println("Closed");
        }
        else System.out.println("Not Found!!");
    }
    public boolean wantsToExit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue y/n?");
        String input = scanner.next();
        return input.equals("n");
    }

    private void showPlaces() {
        System.out.println(">>Places " + map.values().toString());

    }

}
