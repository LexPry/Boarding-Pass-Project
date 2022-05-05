import java.util.*;

public class Input {


    /*
    My thought process was get the user input and use that to create the user object
    Need to figure out a method to select the available flights
     */
    public static User getInformation() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String name = InputValidation.checkName(in);

        int age = getUserAge(in);

        System.out.println("Please enter your gender: ");
        // user input for gender
        User.Gender gender = InputValidation.checkGender(in);

        System.out.println("Please enter your email: ");
        String email = InputValidation.checkEmail(in);

        System.out.println("Please Enter your phone number: ");
        String phoneNumber = in.next();

        while (!InputValidation.checkNumber(phoneNumber)) {
            System.out.println("Please enter a valid phone number: ");
            phoneNumber = in.next();
        }

        System.out.println("Please enter your current location: ");
        String origin = InputValidation.checkDestination(in, "");

        // creating a Date object that stores the current time of creation
        Date date = new Date();

        System.out.println("Enter choose your destination: ");
        String destination = InputValidation.checkDestination(in, origin);

        // creating a new Date object that takes the String in the
        // format Month/Day/Year and then splits it and creates the date object
        System.out.println("Enter your Departure time: ");
        System.out.println("Expected Format: Mon/Date/Year(xxxx)");
        String line = InputValidation.dateValidation(in);

        String[] dateFormatter = line.split("/");
        Calendar calendar = new GregorianCalendar(Integer.parseInt(dateFormatter[2]), // 12/21/2019 -> Dec/ 21st/ 2019 19:00:
                Integer.parseInt(dateFormatter[1]),
                Integer.parseInt(dateFormatter[0]));
        Date departureTime = new Date(String.valueOf(calendar.getTime()));



        return new User(name, email, gender, phoneNumber, date, destination, departureTime, origin, age);
    }

    private static int getUserAge(Scanner in) {
        int age = -1;
        do {
            System.out.println("Please enter your age: ");
            try {
                age = in.nextInt();
            } catch (InputMismatchException ime){/*empty*/}

        } while (age < 0);
        return age;
    }

}