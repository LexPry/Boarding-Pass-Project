//Reads from a user data file, formats the data into a more user-friendly, then writes to another file.
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Formatting {

    public static void format() {
        //relative path
        String path = "resource\\user_data.csv";
        String formatted = "resource\\FormattedTicket.txt";
        File file = new File(path);

        try {
            Scanner sc = new Scanner(file);
            FileWriter formattedWrite = new FileWriter(formatted);
            while (sc.hasNext()) {
                //split userdata into 11 elements
                String[] userData = sc.nextLine().split(",");
                if (!sc.hasNext()) {
                    String topSpace = String.format("%98s", "").replace(' ', '=');
                    String passNumber = userData[0];
                    String name = userData[1];
                    String email = userData[2];
                    String phoneNumber = userData[3];
                    String gender = userData[4];
                    int age = Integer.parseInt(userData[5]);
                    String date = userData[6].substring(0, 10);
                    String origin = userData[7];
                    String destination = userData[8];
                    String departureTime = userData[9].substring(10, 16);
                    String eta = userData[10].substring(0, 16);
                    String totalPrice = userData[11];
                    String bottomSpace = String.format("%98s", "").replace(' ', '=');

                    //formatted to look like a ticket,every 6 lines is a new ticket
                    formattedWrite.write(String.format("%s%n" +
                                    "|Name:  %-31s Age: %-33s Gender: %-10s|%n" +
                                    "|Email: %-31s Phone Number: %-24s Time: %-12s|%n" +
                                    "|From:  %-31s To:  %-33s Date: %-12s|%n" +
                                    "|Boarding Pass #: %-21s ETA: %-33s Price: $%-10s|%n" +
                                    "%s%n",
                            topSpace, name, age, gender,
                            email, phoneNumber, departureTime,
                            origin, destination, date,
                            passNumber, eta, totalPrice, bottomSpace));
                    //print to console
                    System.out.printf("%s%n" +
                                    "|Name:  %-31s Age: %-33s Gender: %-10s|%n" +
                                    "|Email: %-31s Phone Number: %-24s Time: %-12s|%n" +
                                    "|From:  %-31s To:  %-33s Date: %-12s|%n" +
                                    "|Boarding Pass #: %-21s ETA: %-33s Price: $%-10s|%n" +
                                    "%s%n%n",
                            topSpace, name, age, gender,
                            email, phoneNumber, departureTime,
                            origin, destination, date,
                            passNumber, eta, totalPrice, bottomSpace);
                }
            }
            formattedWrite.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}