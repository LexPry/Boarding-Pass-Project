//Reads from a user data file, formats the data into a more user-friendly, then writes to another file.
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Formatting {

    public static void format() {
        //relative path
        String path = "resource\\user_data.csv";
        String formated = "resource\\FormattedTicket.txt";
        File file = new File(path);

        try {
            Scanner sc = new Scanner(file);
            FileWriter formattedWrite = new FileWriter(formated);
            while (sc.hasNext()) {
                //split userdata into 11 elements
                String topSpace = String.format("%96s","").replace(' ','=');
                String[] userData = sc.nextLine().split(",");
                String passNumber = userData[0];
                String name = userData[1];
                String email = userData[2];
                String phoneNumber = userData[3];
                String gender = userData[4];
                int age = Integer.parseInt(userData[5]);
                String date = userData[6].substring(0,10);
                String origin = userData[7];
                String destination = userData[8];
                String departureTime = userData[9].substring(10,18);
                String eta = userData[10];
                String totalPrice = userData[11];
                String bottomSpace = String.format("%96s","").replace(' ','=');

                //formatted to look like a ticket,every 6 lines is a new ticket
                formattedWrite.write(String.format("%s%n" +
                                "|Name:  %-29s Age: %-33s Gender: %-10s|%n" +
                                "|Email: %-29s Phone Number: %-24s Time: %-12s|%n" +
                                "|From:  %-29s To:  %-33s Date: %-12s|%n" +
                                "|Bording Pass #: %-11s ETA: %-33s Price: %-11s|%n" +
                                "%s%n",
                        topSpace,name, age, gender,
                        email, phoneNumber,departureTime,
                        origin, destination, date,
                        passNumber,eta,totalPrice,bottomSpace));
            }
            formattedWrite.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}