package service;

import java.io.*;
import people.Person;
import java.util.*;

public class CSVManagement {

    public ArrayList<Person> readCSV(String filename) throws IOException {
        // Use BufferedReader
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Person> persons = new ArrayList<Person>();
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);

            String[] lineData = line.split(", ");
            Person p = new Person(lineData[0], lineData[1], Integer.parseInt(lineData[2]));
            persons.add(p);
        }

        br.close();
        fr.close();

        return persons;
    }

    public void writeCSV(String fullDirPathFilename, ArrayList<Person> persons) throws IOException {
        FileWriter fw = new FileWriter(fullDirPathFilename);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (Person p: persons) {
            bw.append(p.getName());
            bw.append(", ");
            bw.append(p.getRegion());
            bw.append(", ");
            bw.append(String.valueOf(p.getYearOfBirth()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();

    }
}
