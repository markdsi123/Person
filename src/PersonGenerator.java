import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) throws IOException {
        boolean done = false;
        Scanner in = new Scanner(System.in);
        ArrayList<Person> folks = new ArrayList<>();

        String ID, FirstName, LastName, Title;
        int YOB;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Please enter your ID [6 digits]");
            FirstName = SafeInput.getNonZeroLenString(in, "Please enter your first name");
            LastName = SafeInput.getNonZeroLenString(in, "Please enter your last name");
            Title = SafeInput.getNonZeroLenString(in, "Please enter your title");
            YOB = SafeInput.getRangedInt(in, "Please enter your year of birth ", 1000, 2023);

            folks.add(new Person(ID, FirstName, LastName, Title, YOB));

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }while(!done);

        //Output what user has entered
        for (Person personRec : folks)
        {
            System.out.println(personRec.toCSVDataRecord());
        }

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory + "\\src\\PersonDataText.txt");

        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            //Create a file from an array list
            for( Person p : folks)
            {
                writer.write(p.toCSVDataRecord());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data is written!");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}