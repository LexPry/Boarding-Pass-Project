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
        String name = in.nextLine();

        System.out.println("Please enter your age: ");
        int age = in.nextInt();


        System.out.println("Please enter your gender: ");
        // user input for gender
        User.Gender gender = null;
        String inGender = in.next();

        if (inGender.equalsIgnoreCase("m")) {
            gender = User.Gender.M;
        } else if (inGender.equalsIgnoreCase("f")) {
            gender = User.Gender.F;
        }

        System.out.println("Please enter your email: ");
        String email = in.next();

        System.out.println("Please Enter your phone number: ");
        String phoneNumber = in.nextLine();

        while (!checkNumber(phoneNumber)) {
            System.out.println("Please enter a valid phone number: ");
            phoneNumber = in.next();
        }

        // creating a Date object that stores the current time of creation
        Date date = new Date();

        System.out.println("Enter choose your destination: ");
        String destination = in.next();

        // creating a new Date object that takes the String in the
        // format Month/Day/Year and then splits it and creates the date object
        System.out.println("Enter your Departure time: ");
        System.out.println("Expected Format: Mon/Day/Year");
        String line = in.next();
        String[] dateFormatter = line.split("/");
        Date departureTime = new Date(Integer.parseInt(dateFormatter[0]), // 12/21/2019 -> Dec/ 21st/ 2019 19:00:
                Integer.parseInt(dateFormatter[1]),
                Integer.parseInt(dateFormatter[2]));

        System.out.println("Please enter your current location: ");
        String origin = "LAX";

        return new User(name, email, gender, phoneNumber, date, destination, departureTime, origin, age);
    }

    public static boolean checkNumber(String phoneNumber) {
        if (phoneNumber.length() >= 9) {
            // validate phone numbers of format "1234567890"
            if (phoneNumber.matches("\\d{10}"))
                return true;
                // validating phone number with -, . or spaces
            else if (phoneNumber.matches("\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}"))
                return true;
                // validating phone number with extension length from 3 to 5
            else if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
                return true;
                // validating phone number where area code is in braces ()
            else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
                return true;
                // Validation for India numbers
            else if (phoneNumber.matches("\\d{4}[-.\\s]\\d{3}[-.\\s]\\d{3}"))
                return true;
            else if (phoneNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
                return true;

            else if (phoneNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
                return true;
                // return false if nothing matches the input
            else
                return false;
        }
        return false;
    }

}