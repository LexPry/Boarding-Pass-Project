import java.util.Arrays;
import java.util.Scanner;
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
        while (temp.matches("(@)(.+)$")) {
            System.out.println("Please enter a valid email: ");
            System.out.println("Format expected: gernericemail@xxxx.com");
            temp = in.next();
        }
        return temp;
    }

    public static String checkName(Scanner in) {
        String tempName = in.next();
        while (!tempName.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid name: ");
            tempName = in.next();
        }
        return tempName;
    }

    public static String checkDestination(Scanner in) {
        System.out.println("Please choose an option: ");
        Arrays.asList("1. ATL", "2. JFK", "3. LAX", "4. ORD").forEach(System.out::println);
        String destination = "";

        String assignDestination = in.next();

        while (!assignDestination.matches("[1234]")) {
            System.out.println("Please choose a valid option: ");
            Arrays.asList("1. ATL", "2. JFK", "3. LAX", "4. ORD").forEach(System.out::println);
            assignDestination = in.next();
        }

        switch (Integer.parseInt(assignDestination)) {
            case 1:
                destination = "ATL";
                break;
            case 2:
                destination = "JFK";
                break;
            case 3:
                destination = "LAX";
                break;
            case 4:
                destination = "ORD";
                break;
        }
        return destination;
    }

    public static String checkDestination(String originDestination, Scanner in) {
        System.out.println("Please choose an option: ");
        Stream.of("1. ATL", "2. JFK", "3. LAX", "4. ORD").filter(a -> !a.contains(originDestination)).forEach(System.out::println);
        String destination = "";

        String assignDestination = in.next();

        while (!assignDestination.matches("[1234]")) {
            System.out.println("Please choose a valid option: ");
            Arrays.asList("1. ATL", "2. JFK", "3. LAX", "4. ORD").forEach(System.out::println);
            assignDestination = in.next();
        }

        switch (Integer.parseInt(assignDestination)) {
            case 1:
                destination = "ATL";
                break;
            case 2:
                destination = "JFK";
                break;
            case 3:
                destination = "LAX";
                break;
            case 4:
                destination = "ORD";
                break;
        }
        return destination;
    }

    public static String dateValidation(Scanner in) {
        String tempDate = in.next();
        while (!tempDate.matches("^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](20)\\d\\d$"))
        {
            System.out.println("Please enter a valid date with the expected format: ");
            System.out.println("Example: Mon/day/year(xxx) -> 12/24/2019");
            tempDate = in.next();
        }
        return tempDate;
    }
}
