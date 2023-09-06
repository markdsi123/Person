import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        File selectedFile;
        String firstName, lastName, ID, title;
        int yob;

        String rec = "";
        ArrayList<Person> personList = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        try
        {

            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);
                }
                reader.close();

                System.out.printf("\n%-8s%-25s%-25s%-6s%6s", "ID", "First Name", "Last Name", "Title", "YOB");
                System.out.println();
                for(int i =0; i<71; i++)
                {
                    System.out.printf("-");
                }
                System.out.println();

                String[] fields;
                for(String line : lines)
                {
                    fields = line.split(",");
                    if(fields.length == 5)
                    {
                        ID = fields[0].trim();
                        firstName = fields[1].trim();
                        lastName = fields[2].trim();
                        title = fields[3].trim();
                        yob = Integer.parseInt(fields[4].trim());

                        Person person = new Person(ID, firstName, lastName, title, yob);
                        personList.add(person);
                    }else {
                        System.out.println("\nThere may be a corrupt: " + line);
                    }
                }
            }else {
                System.out.println("Failed to read a file");
                System.exit(0);
            }
            for(Person p : personList)
            {
                System.out.println(p.toCSVDataRecord());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}