import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class WriteToFile {
    public static void saveRecord(BoardingPass boardingPass ,User user) throws IOException {
        String filepath = "resource/user_data.csv";
        FileWriter fw = new FileWriter(filepath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println(boardingPass.getBoardingNumber()+","+ user.getName()+","+user.getEmail()+","+
                user.getPhoneNumber()+","+user.getGender()+","+user.getAge()+","+user.getDate()+","+
                user.getOrigin()+","+user.getDestination()+","+user.getDepartureTime()+","+boardingPass.getETA()+","+boardingPass.getFinalTicketPrice());
        pw.flush();
        pw.close();
    }
}

