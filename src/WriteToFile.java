import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class WriteToFile {
    public static void saveRecord(BoardingPass boardingPass , String name, String email, String gender, String phoneNumber, Date date, String destination, Date departureTime, String origin, int age) throws IOException {
        String filepath = "resource/user_data.csv";
        FileWriter fw = new FileWriter(filepath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println(boardingPass.getUser().getBoardingPassNumber()+","+ name+","+email+","+phoneNumber+","+gender+","+age+","+date+","+origin+","+destination+","+departureTime);
        pw.flush();
        pw.close();
    }
}

