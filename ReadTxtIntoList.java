/**
 * This class returns a list of integers from a text file.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class ReadTxtIntoList
{
    static List<Integer> list = new ArrayList<Integer>();
    
    public static List<Integer> Extracting() {
        BufferedReader in = null;
        FileReader fr = null;
        
        // Scanner for user input
        Scanner user = new Scanner(System.in); 
        String inputFileName;
        try {
            // prepare the input file
            System.out.print("Input File Location: ");
            inputFileName = user.nextLine().trim();
            File input = new File(inputFileName); 
            
            //if the file exists
            if (input.isFile()) {
                Scanner scan = new Scanner(input); 
                
                fr = new FileReader(input);
                in = new BufferedReader(fr);
                String str;
                while ((str = in.readLine()) != null) {
                    list.add(Integer.parseInt(str));
                }
                System.out.println("File has been scanned successfully!");
                
            } else {
                System.out.print("File does not exist!");
                System.out.print("\n");
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    
    //public static void main(String args[]) {
        //Extracting();
        //System.out.print(list);
    //}
}
