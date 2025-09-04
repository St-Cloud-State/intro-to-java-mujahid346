import java.nio.channels.Pipe.SinkChannel;
import java.util.LinkedList;
import java.util.Scanner;
// import java.io.FileReader;

import javax.sound.sampled.SourceDataLine;

import java.io.*;
import java.util.Scanner;

class Person {

    private String firstName;
    private String lastName;
    private int id;

    public Person(int id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // return "Person firstName=" + firstName + ", lastName=" + lastName + ", id=" +
        // id + "";

        return id + "," + firstName + "," + lastName;
    }

}

public class MyMain {
    // store method
    public static void store(InputStreamReader input, LinkedList<Person> list) {
        try {
            BufferedReader reader = new BufferedReader(input);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String firstName = parts[1].trim();
                String lastName = parts[2].trim();
                Person person = new Person(id, firstName, lastName);
                list.add(person);

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // display method
    public static void display(OutputStreamWriter output, LinkedList<Person> list) {
        try {
            BufferedWriter writer = new BufferedWriter(output);
            for (Person p : list) {
                writer.write(p.toString() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // find
    public static int find(String sid, LinkedList<Person> list) {
        for (int index = 0; index < list.size(); index++) {

            Person p = list.get(index);
            if (Integer.parseInt(sid) == p.getId()) {
                return index;
            }

        }

        return -1;
    }

    public static void main(String a[]) {

        LinkedList<Person> People = new LinkedList<>();
        try {
            FileReader reader = new FileReader("input.txt");
            store(reader, People);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("output.txt");

            display(writer, People);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("index is: " + find("40", People));
        System.out.println("index is: " + find("30", People));
        System.out.println("index is: " + find("500", People));

    }
}
