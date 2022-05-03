import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Input {


    /*
    My thought process was get the user input and use that to create the user object
    Need to figure out a method to select the available flights
     */
    public static User getInformation() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String name = "Al";
//        String name = in.nextLine();

        System.out.println("Please enter your age: ");
//        int age = in.nextInt();
        int age = 20;

        System.out.println("Please enter your Gender: ");
        String gender = "M";

        System.out.println("Please enter your email: ");
        String email = "lll@gmail";

        System.out.println("Please Enter your phone number: ");
        String phoneNumber = "333-333-333";

        // creating a Date object that stores the current time of creation
        Date date = Date.from(Instant.EPOCH);

        System.out.println("Enter choose your destination: ");
        String destination = "ATL";

        // creating a new Date object that takes the String in the
        // format Month/Day/Year and then splits it and creates the date object
        System.out.println("Enter your Departure time: ");
        System.out.println("Expected Format: Mon/Day/Year");
//        String line = in.nextLine();
//        String[] dateFormatter = line.split("/");
        Date departureTime = Date.from(Instant.EPOCH);
//        Date departureTime = new Date(Integer.parseInt(dateFormatter[0]),
//                Integer.parseInt(dateFormatter[1]),
//                Integer.parseInt(dateFormatter[2]));

        System.out.println("Please enter your current location: ");
        String origin = "LAX";

        return new User(name, email, gender, phoneNumber, date, destination, departureTime, origin, age);
    }

}