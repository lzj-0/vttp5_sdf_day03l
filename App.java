
import java.io.Console;
import java.io.File;
import java.io.*;
import service.CSVManagement;
import java.util.*;

import people.Person;

public class App {
    public static void main(String[] args) throws IOException {

        // args[0] = data
        // args[1] = myfile.txt
        // cmd: java App "data" "myfile.txt"
        String dirPath = args[0];
        String fileName = args[1];

        // data\myfile.txt
        String dirPathFileName = dirPath + File.separator + fileName;

        // check if a directory exists, if not create it
        File directory = new File(dirPath);

        if (directory.exists()) {
            System.out.println("Directory " + directory.toString() + " already created");
            System.out.println("Directory " + directory + " already created");
        } else {
            directory.mkdir();
        }

        // check if file exists
        File file = new File(dirPathFileName);

        if (file.exists()) {
            System.out.println("File " + file.toString() + " already created");
        } else {
            file.createNewFile();
        }

        // Use FileWriter
        // 1. Use console to read in a string of text (sentence)
        // 2. Use FileWriter to write the content to the file
        //Console cons = System.console();
        //String input = cons.readLine("Enter/Input a sentence: ");
        // FileWriter fw = new FileWriter(file, true);

        // fw.write(input);
        // fw.flush();
        // fw.close();

        // // Use FileReader to read the file
        // FileReader fr = new FileReader(file);
        // // one character is read in byte for each loop 
        // int dataRead = fr.read();
        // while (dataRead != -1) {
        //     System.out.println((char) dataRead);
        //     dataRead = fr.read();
        // }
        // fr.close();

        // // Use BufferedWriter to write to file
        // FileWriter fw = new FileWriter(file, true);
        // BufferedWriter bw = new BufferedWriter(fw);
        // bw.append(input);
        // bw.flush();
        // bw.close();
        // fw.close();

        // // Use BufferedReader to read the file
        // // this way it will automatically close fr and br
        // try (FileReader fr = new FileReader(file)) {
        //     try (BufferedReader br = new BufferedReader(fr)) {
        //         String line = "";
        //         while ((line = br.readLine()) != null) {
        //             System.out.println(line);
        //         }
        //     }
        // }

        // try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        //     String line = "";
        //     while ((line = br.readLine()) != null) {
        //         System.out.println(line);
        //     }
        // }

        // //br.close();
        // //fr.close();

        // // Use FileOutputStream to write to file
        // FileOutputStream fos = new FileOutputStream(file, true);
        // byte[] byteContent = input.getBytes();
        // fos.write(byteContent);
        // fos.flush();
        // fos.close();

        // // Use FileInputStream to read a file
        // FileInputStream fis = new FileInputStream(file);
        // int contentRead = 0;
        // while ((contentRead = fis.read()) != -1) {
        //     System.out.println((char) contentRead);
        // }
        // fis.close();

        // Decorator pattern
        // Use FileOutputStream and DataOutputStream to write to file
        // FileOutputStream fos = new FileOutputStream(file);
        // DataOutputStream dos = new DataOutputStream(fos);
        // dos.writeBytes(input);
        // dos.flush();
        // dos.close();
        // fos.close();


        // // Use FileInputStream and DataInputStream to read the content
        // FileInputStream fis = new FileInputStream(file);
        // DataInputStream dis = new DataInputStream(fis);
        // int disContent = 0;
        // while ((disContent = dis.read()) != -1) {
        //     System.out.println((char) disContent);
        // }
        // dis.close();
        // fis.close();

        ArrayList<Person> persons = new ArrayList<>();

        CSVManagement man = new CSVManagement();
        persons = man.readCSV(dirPathFileName);

        Console consoleSelection = System.console();
        Integer selection = 0;
        while (selection != 3) {
            System.out.println("1. Enter new Person details");
            System.out.println("2. Save to new csv file");
            System.out.println("3. Quit program");
            selection = Integer.parseInt(consoleSelection.readLine(">>> "));

            switch (selection) {
                case 1:
                    Console con1 = System.console();
                    String personName = con1.readLine("Enter Person name: ");
                    String personRegion = con1.readLine("Enter Region/Area: ");
                    String personYOB = con1.readLine("Enter Year of Birth: ");

                    Person p = new Person(personName, personRegion, Integer.parseInt(personYOB));
                    persons.add(p);
                    break;
                case 2:
                    Console con2 = System.console();
                    String newFileName = con2.readLine("Enter a csv file to save (filename only): ");
                    man.writeCSV(newFileName, persons);
                    break;
                default:
                    break;
            }
        }

    }
}
