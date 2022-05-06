//Reads from a user data file, formats the data into a more user-friendly, then writes to another file.
import java.io.File;
import java.io.FileWriter;
import java.text.NumberFormat;
import java.util.Locale;
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
                    String date = userData[6].substring(0, 10) + " " + userData[6].substring(24, 28);
                    String origin = userData[7];
                    String destination = userData[8];
                    String departureTime = converToStandardTime(userData[9].substring(11, 16));
                    String eta = userData[10].substring(0, 11) + converToStandardTime(userData[10].substring(11,16));
                    String totalPrice = NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(Float.parseFloat(userData[11])/100);
                    String bottomSpace = String.format("%98s", "").replace(' ', '=');

                    //formatted to look like a ticket,every 6 lines is a new ticket
                    formattedWrite.write(String.format("%s%n" +
                                    "|Name:  %-31s Age: %-24s Gender: %-19s|%n" +
                                    "|Email: %-31s Phone Number: %-15s Departure Time: %-11s|%n" +
                                    "|From:  %-31s To:  %-24s Date: %-21s|%n" +
                                    "|Boarding Pass #: %-21s ETA: %-24s Price: %-20s|%n" +
                                    "%s%n",
                            topSpace, name, age, gender,
                            email, phoneNumber, departureTime,
                            origin, destination, date,
                            passNumber, eta, totalPrice, bottomSpace));
                    //print to console
                    System.out.printf("%s%n" +
                                    "|Name:  %-31s Age: %-24s Gender: %-19s|%n" +
                                    "|Email: %-31s Phone Number: %-15s Departure Time: %-11s|%n" +
                                    "|From:  %-31s To:  %-24s Date: %-21s|%n" +
                                    "|Boarding Pass #: %-21s ETA: %-24s Price: %-20s|%n" +
                                    "%s%n",
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
    public static String converToStandardTime(String time){
        //since user data comes in military time if the first position is larger than 2 or equal to zero then it is guaranteed to be in the morning
        if(Integer.parseInt(time.substring(0,1))<=2 && Integer.parseInt(time.substring(0,1)) != 0){
            time = Integer.parseInt(time.substring(0,2))-12 + time.substring(2,5) + " PM";
        }else if (Integer.parseInt(time.substring(0,1)) == 0){
            time = time.substring(1,5) + " AM";
        }else{
            time+= " AM";
        }
        return time;
    }
}