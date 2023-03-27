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

/**
 *
 * @author 21s01acs016
 */
public class StudentFileIO {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    
    // method for prompting
    public static int getIntInput(String prompt, int[] optionsRange) {
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);
            if (console.hasNextInt()) {
                int choice = console.nextI
            }
        }
    }
}
