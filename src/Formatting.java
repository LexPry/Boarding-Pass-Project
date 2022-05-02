import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class Formatting {

    public static void format(User user) {
        String path = "/home/pryme/IdeaProjects/Boarding-Pass-Project/resource/user_data.csv";
        String formated = "/home/pryme/IdeaProjects/Boarding-Pass-Project/resource/FormattedTicket.txt";
        try{
            Scanner sc = new Scanner(path);
            while(sc.hasNext()){
                //user data file layout??
            }
            String name = user.getName();
            String gender = user.getGender();
            int age = user.getAge();
            String phoneNumber = user.getPhoneNumber();
            String email = user.getEmail();
            Date date = user.getDate();
            String destination = user.getDestination();
            Date departureTime = user.getDepartureTime();
            String origin = user.getOrigin();
            String eta = String.valueOf(user.getBoardingPassNumber().getETA());
            String basePrice = String.valueOf(user.getBoardingPassNumber().getBaseTicketPrice());
            String discount = String.valueOf(user.getBoardingPassNumber().getBaseTicketPrice()/user.getBoardingPassNumber().getFinalTicketPrice());
            String discountPrice = String.valueOf(user.getBoardingPassNumber().getFinalTicketPrice());

            FileWriter formattedWrite = new FileWriter(formated);

            formattedWrite.write(String.format("Name:  %-20s Age: %-29s Gender: %-10s %n" +
                            "Email: %-20s Phone Number: %-20s%n" +
                            "From:  %-20s To:  %-29s Date: %-5s%n" +
                            "Time: %-21s ETA: %-10s%n" +
                            "Base Price: %-15s Discount:  %-23s Discounted Price: %-5s",
                    name,age,gender,
                    email,phoneNumber,
                    origin,destination,date,
                    departureTime,eta,
                    basePrice,discount,discountPrice));
            formattedWrite.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}