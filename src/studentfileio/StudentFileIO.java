/**
Write a java console application that can be able to store and randomly retrieve student records of the format:-

Student{

  StudentID

  Name

  Fee

}

Your application should provide menus for a user to choose to either create a new record, read an existing record based on StudentID or to quit.

(PDF your code and submit a pdf file)
 */
package studentfileio;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author 21s01acs016
 */
public class StudentFileIO {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // prompt user for operation;
        String optionsString = "1. Create new record\n2. Read existing record\n3. Quit";
        int[] optionsRange = {1, 2, 3};
        int choice = getIntInput(optionsString, optionsRange);
        // if the choice == 1, create new record
        // if the choice == 2, prompt for student id and read record
        // if the choice == 3, quit
        switch (choice) {
            case 1:
                System.out.println("Creating new record...");
                // prompt for student id, name, fee
                String studentId = getStringInput("Enter student ID: ");
                String studentName = getStringInput("Enter student name: ");
                double studentFee = getDoubleInput("Enter student fee: ");
                // create new record as a text file named after the student id
                // the text files will be stored in a folder named "records" in the current directory
                // check if the folder exists, if not, create it
                if (!new File("records").exists()) {
                    new File("records").mkdir();
                }

                // create the text file
                String filePath = createFile("records", studentId + ".txt");
                if (filePath != null) {
                    System.out.println("Record created at " + filePath);
                }
                // write content to the file
                // construct the file content string
                String fileContent = "Student ID: " + studentId + "\n" +
                                     "Student Name: " + studentName + "\n" +
                                     "Student Fee: " + studentFee + "\n";
                // write the file content string to the file
                System.out.println("Writing to file...");
                writeToFile(filePath, fileContent);

                System.out.println("Done.");
                break;
            case 2:
                System.out.println("Reading existing record...");
                // prompt for student id
                String studentIdToRead = getStringInput("Enter student ID: ");
                // check if the file exists
                File fileToRead = new File("records/" + studentIdToRead + ".txt");
                if (fileToRead.exists()) {
                    // read the file
                    System.out.println("Reading file...");
                    Scanner fileReader = null;
                    try {
                        fileReader = new Scanner(fileToRead);
                        while (fileReader.hasNextLine()) {
                            System.out.println(fileReader.nextLine());
                        }
                    } catch (Exception e) {
                        System.out.println("Error reading file.");
                    } finally {
                        try {
                            fileReader.close();
                        } catch (Exception e) {
                            System.out.println("Error closing file.");
                        }
                    }
                } else {
                    System.out.println("Record does not exist.");
                }
                System.out.println("Done.");
                break;
            case 3:
                System.out.println("Quitting...");
                break;
        }
    }

    // method for creating a file in a given path
    public static String createFile(String path, String fileName) {
        File file = new File(path + "/" + fileName);
        if (file.exists()) {
            System.out.println("Record already exists.");
            return null;
        } else {
            try {
                file.createNewFile();
                return file.getAbsolutePath();
            } catch (Exception e) {
                System.out.println("Error creating file.");
                return null;
            }
        }
    }

    // method for writing to a file
    public static void writeToFile(String filePath, String content) {
        File file = new File(filePath);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(content);
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                System.out.println("Error closing file.");
            }
        }
    }
    
    // method for prompting
    public static int getIntInput(String prompt, int[] optionsRange) {
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);
            if (console.hasNextInt()) {
                int choice = console.nextInt();

                if (existsInArray(choice, optionsRange)) {
                    return choice;
                } else {
                    System.out.println("Invalid input. Please try again.");
                    console.nextLine();
                }
            }
        }
    }

    public static String getStringInput(String prompt) {
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);
            if (console.hasNextLine()) {
                return console.nextLine();
            }
        }
    }

    public static double getDoubleInput(String prompt) {
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);
            if (console.hasNextDouble()) {
                return console.nextDouble();
            }
        }
    }

    // method for checking if an integer exists in an array
    public static boolean existsInArray(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return true;
            }
        }
        return false;
    }
}
