package lab06_hash_functions;

import java.util.Scanner;
import static lab06_hash_functions.Basic_Hash.do_hash_block_string;
import static lab06_hash_functions.Hash_JCE_Service.do_hash_SHA_256;
/**
 * Main
 * @author David Madrigal Buendía
 * @version 1.1
 */
public class Lab06_Hash_Functions {

    private static Scanner input;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        input = new Scanner(System.in);
        String opc;
        String file_name;
        
        do
        {
            System.out.println("Insert an option: ");
            System.out.println("\ta - Basic Hash Example");
            System.out.println("\tb - Hash example using JCE library with SHA-256");
            System.out.println("\tz - Exit");
            opc = input.nextLine();

            if(opc.equalsIgnoreCase("a"))
            {
                menu_example_basic_hash();
            }else if(opc.equalsIgnoreCase("b"))
            {
                menu_example_hash_jce();
            }
        }while(!opc.equalsIgnoreCase("z"));
    }
    
    /**
     * Example, using Basic_Hash class
     */
    private static void menu_example_basic_hash()
    {
        System.out.println("Please, insert file name:");
        String file_name = input.nextLine();
        System.out.println("Please, insert number 'm': ");
        int m = input.nextInt();
        System.out.println("Press enter to continue...");
        input.nextLine(); // Clear buffer
        try
        {
            String hash_block = do_hash_block_string(file_name, m);
            System.out.println(hash_block);
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error:" + e.getMessage());
        }
        System.out.println("Hash generate in the file hash.txt");
    }
    
    /**
     * Example, using Hash from JCE (SHA-256)
     */
    private static void menu_example_hash_jce()
    {
        System.out.println("Please, insert file name:");
        String file_name = input.nextLine();
        
        try
        {
            do_hash_SHA_256(file_name);
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error:" + e.getMessage());
        }
        System.out.println("Hash generate in the file hash_JCE.txt");
    }
}
