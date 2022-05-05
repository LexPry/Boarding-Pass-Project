import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidation {
    public static boolean checkNumber(String phoneNumber) {
        if (phoneNumber.length() >= 9) {
            // validate phone numbers of format "1234567890"
            if (phoneNumber.matches("\\d{10}")) {
                return true;
            }
            // validating phone number with -, . or spaces
            else if (phoneNumber.matches("\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}")) {
                return true;
            }
            // validating phone number with extension length from 3 to 5
            else if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
                return true;
            }
            // validating phone number where area code is in braces ()
            else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
                return true;
            }
            // Validation for India numbers
            else if (phoneNumber.matches("\\d{4}[-.\\s]\\d{3}[-.\\s]\\d{3}")) {
                return true;
            } else // return false if nothing matches the input
                if (phoneNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}")) {
                    return true;
                } else return phoneNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}");
        }
        return false;
    }

    public static User.Gender checkGender(Scanner in) {
        System.out.println("Please choose a gender:  \n 1. Male \n2. Female \n3. Prefer not to say");
        String temp = in.next();
        User.Gender gender;
        // only take in one number, no whitespace, no chars
        while (!temp.matches("(?<!\\S)[123](?!\\S)")) {
            temp = in.next();
        }

        switch (Integer.parseInt(temp)) {
            case 1:
                gender = User.Gender.M;
                break;
            case 2:
                gender = User.Gender.F;
                break;
            default:
                gender = User.Gender.X;
        }
        return gender;
    }

    public static String checkEmail(Scanner in) {
        String temp = in.next();
        // checks to make sure email at lest has an '@' and a '.'
        while (temp.matches("(@)(.+)$")) {
            System.out.println("Please enter a valid email: ");
            System.out.println("Format expected: gernericemail@xxxx.com");
            temp = in.next();
        }
        return temp;
    }

    public static String checkName(Scanner in) {
        String tempName = in.nextLine();
        // only takes in characters and spaces
        while (!tempName.matches("[a-zA-Z\\s]+")) {
            System.out.println("Please enter a valid name (only characters and spaces): ");
            tempName = in.nextLine();
        }
        return tempName;
    }

    public static String checkDestination(Scanner in, String originDestination) {

        var airports = Airport.getAirports().keySet().stream().filter(a -> !a.equals(originDestination)).collect(Collectors.toCollection(ArrayList::new));

        String assignDestination;
        boolean firstTry = true;
        var end = String.valueOf(airports.size());
        do {
            System.out.println("Please choose a" + (firstTry ? "n" : " valid") + " option: ");
            firstTry = false;
            int count = 0;
            for (var a : airports) {
                System.out.println(++count + ". " + a);
            }
            assignDestination = in.next();

        }while (!assignDestination.matches("[1-" + end + "]"));

        var index = Integer.parseInt(assignDestination)-1;
        return airports.get(index);
    }


    public static String dateValidation(Scanner in) {
        String tempDate = in.next();
        // makes sure date follows format (xx/xx/xxxx)
        // and ensures months will never be out of range 1-12
        // and dates will never be higher than 31
        // also only takes years 20xx
        while (!tempDate.matches("^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](20)\\d\\d$"))
        {
            System.out.println("Please enter a valid date with the expected format: ");
            System.out.println("Example: Mon/day/year(xxx) -> 12/24/2019");
            tempDate = in.next();
        }
        return tempDate;
    }

    public static String timeValidate(Scanner in) {
        String tempTime;

        do {
            System.out.println("Please enter a time with the expected format: ");
            System.out.println("Example: HH:MM AM/PM ->  12:34 PM");
            tempTime = in.next();
        }
        while (!tempTime.matches("^(11|12|0[1-9]):([0-5][/d]) ([aApP])(mM)$"));
        var temp = tempTime.split("(: )");
        int hour = Integer.parseInt(temp[0]);
        if (Character.toUpperCase(temp[2].charAt(0)) == 'P'){
             hour += hour;
        }
        return hour + ":" + temp[1];
    }
}
