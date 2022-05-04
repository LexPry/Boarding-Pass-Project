import java.io.IOException;
import java.util.Date;

public class User {
    public enum Gender {M, F}

    private String name;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private Date date;
    private String destination;
    private Date departureTime;
    private String origin;
    private int age;
    private BoardingPass boardingPass;

    public User(String name, String email, Gender gender, String phoneNumber, Date date, String destination, Date departureTime, String origin, int age) {

        this.name = name;
        this.email = email;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {

        if (gender.equalsIgnoreCase("m")) {
            this.gender = Gender.M;
        } else if (gender.equalsIgnoreCase("f")) {
            this.gender = Gender.F;
        }

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
                ", Gender='" + this.getGender().toString() + '\'' +
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
