import java.util.Scanner;

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
}
