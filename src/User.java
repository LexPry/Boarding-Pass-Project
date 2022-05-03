import java.io.IOException;
import java.util.Date;

public class User {
    private String name;
    private String email;
    private String Gender;
    private String phoneNumber;
    private Date date;
    private String destination;
    private Date departureTime;
    private String origin;
    private int age;
    private BoardingPass boardingPass;

    public User( String name, String email, String gender, String phoneNumber, Date date, String destination, Date departureTime, String origin, int age){

        this.name = name;
        this.email = email;
        Gender = gender;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.destination = destination;
        this.departureTime = departureTime;
        this.origin = origin;
        this.age = age;
        this.boardingPass = getNewBoardingPass();

    }


    public BoardingPass getNewBoardingPass() {
        return new BoardingPass(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Gender='" + Gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                "\n, date=" + date +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", origin='" + origin + '\'' +
                ", age=" + age +
                '}';
    }

    public BoardingPass getBoardingPassNumber() {
        return boardingPass.getUser().getBoardingPassNumber();
    }

    public void setBoardingPassNumber(int boardingPassNumber) {
        this.boardingPass = boardingPass;
    }
}
