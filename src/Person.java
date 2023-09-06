import java.util.Calendar;

public class Person {
    private String ID;
    private String firstName;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    private String lastName;
    private String title;
    private int yob;

    public Person(String ID, String firstName, String lastName, String title, int yob)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yob = yob;
    }


    public String fullName()
    {
        return firstName  + " " + lastName;
    }
    public String formalName()
    {
        return title + " " + fullName();
    }
    public int getAge()
    {
        return Calendar.getInstance().get(Calendar.YEAR) - yob;
    }
    public int getAge(int year)
    {
        return year - yob;
    }
    public String toCSVDataRecord()
    {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + yob;
    }

}
