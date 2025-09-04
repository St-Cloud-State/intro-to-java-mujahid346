import java.util.LinkedList;
import java.io.*;

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

class PersonList {

    private LinkedList<Person> list;

    public PersonList() {
        this.list = new LinkedList<>();

    }

    // storing
    public void store(InputStreamReader input) {
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

    // displaying
    public void display(OutputStreamWriter output) {
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
    public int find(String sid) {
        for (int index = 0; index < list.size(); index++) {

            Person p = list.get(index);
            if (Integer.parseInt(sid) == p.getId()) {
                return index;
            }

        }

        return -1;
    }

}

// main program
public class MyMain {
    public static void main(String a[]) {

        PersonList Plist = new PersonList(); // am here
        // storing
        try {
            FileReader reader = new FileReader("input.txt");
            Plist.store(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // displaying
        try {
            FileWriter writer = new FileWriter("output.txt");
            Plist.display(writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // find

        System.out.println("index is : " + Plist.find("42"));
        System.out.println("index is : " + Plist.find("36"));
        System.out.println("index is : " + Plist.find("100"));

    }
}
