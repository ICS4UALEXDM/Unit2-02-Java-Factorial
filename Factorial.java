import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
* This program calculates amount of mean median and mode.
*
* @author  Alex De Meo
* @version 1.0
* @since   2023/02/08
*/

public final class Factorial {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private Factorial() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    * @throws Exception if something goes wrong
    */

    public static void main(String[] args) throws Exception {
        // Initializing variables
        String line;
        final String err = "Error";
        try {
            // new file object
            final File input = new File("input.txt");

            // Creating the writer
            final FileWriter writer = new FileWriter("output.txt");

            try {
                // Creating the scanner.
                final Scanner scanner = new Scanner(input);

                // ArrayList to hold the lines
                final ArrayList<String> lines = new ArrayList<>();
                // Getting the input from the first file
                while (scanner.hasNextLine()) {
                    // getting next line and putting it in the interim list
                    line = scanner.nextLine();
                    lines.add(line);
                }
                // set a counter
                int counter = 0;
                // creating a new array to hold this data
                final int[] numbers = new int[lines.size()];
                // taking the data from the interim list and inputting it into
                // newly made array
                for (String line2 : lines) {
                    try {
                        final int line3 = Integer.parseInt(line2);
                        final int factorial = recFactorial(line3);
                        writer.write(line3 + "! = " + factorial + "\n");
                        counter++;
                    } catch (NumberFormatException error) {
                        writer.write("Error: " + line2 + " is not valid for"
                            + " this program.\n");
                    }
                }
            } catch (IOException error) {
                System.out.println(err + error.getMessage());
            }
            // closes the writer
            writer.close();
        } catch (IOException error) {
            System.out.println(err + error.getMessage());
        }
    }
    /**
    * This is the method reverseRecs the string.
    *
    * @param num This is the number used in the factorial
    * @return the factorial
    */

    public static int recFactorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return recFactorial(num - 1) * num;
        }
    }
}
