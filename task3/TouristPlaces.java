package task3;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TouristPlaces implements Serializable {
    String name, category, city, famousFor;
    int ticketPrice, noOfRate;
    float starRating;
    String workingHour;

// Default Constructor
    public TouristPlaces() {
    }

    public TouristPlaces(String name, String category, String city, int ticketPrice, String workingHour, String famousFor) {
        this.name = name;
        this.category = category;
        this.city = city;
        this.ticketPrice = ticketPrice;
        this.starRating=0;
        this.noOfRate=0;
        this.famousFor =  famousFor;
        this.workingHour=workingHour;

    }
    public float totalRate(int Ratings){
        System.out.println("enter rating: \n");
;
            noOfRate++;
            //Calculate Star Rating (previous rating= 4.5, no of rating =5, new rating = 3, total = ((4*5)+4)/6 = 4  )
            starRating+= (float)((Ratings-starRating)/noOfRate);

        System.out.println("Rating : " + starRating +" stars");
        System.out.println("No.of rates : " + noOfRate);
        return starRating;
    }


    @Override
    public String toString() {
        return "TouristPlace{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", city='" + city + '\'' +
                ", famousFor=" + famousFor +
                ", ticketPrice=Rs. " + ticketPrice +
                ", workingHour='" + workingHour + '\'' +
                '}';
    }


        boolean isOpen(){
                //Split both the times
                String[] times = workingHour.split(" to ");

    //Parse times
    LocalTime startTime = LocalTime.parse(times[0], DateTimeFormatter.ofPattern("hh:mma"))
            , endTime = LocalTime.parse(times[1], DateTimeFormatter.ofPattern("hh:mma"))
            , currTime = LocalTime.now();

    //startTime.compare(currTime) : -1, 0
    //endTime.compareTo(currTime) : 1, 0
        return (startTime.compareTo(currTime) <=0  && endTime.compareTo(currTime) >=0);
    }

    public static TouristPlaces newPlaceFromUser() {
        Scanner scanner = new Scanner(System.in);
        TouristPlaces newPlace = new TouristPlaces();
        System.out.println("Enter Name : ");
        newPlace.name = scanner.nextLine();
        System.out.println("Enter category : ");
        newPlace.category= scanner.nextLine();
        System.out.println("Enter City : ");
        newPlace.city= scanner.nextLine();
       System.out.println("Enter Why it is Famous for ?: ");
       newPlace.famousFor= scanner.nextLine();
        System.out.println("Enter Working Hour (ex: 09:00AM to 10:30PM) : ");
        newPlace.workingHour = scanner.nextLine();
        System.out.println("Enter Ticket Price : ");
        newPlace.ticketPrice = scanner.nextInt();

        newPlace.toString();

        return newPlace;
    }
}