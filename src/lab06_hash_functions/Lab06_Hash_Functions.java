package lab06_hash_functions;

import static lab06_hash_functions.Basic_Hash.do_hash_block_string;
import static lab06_hash_functions.Hash_JCE_Service.do_hash_SHA_256;
/**
 *
 * @author David Madrigal Buendía
 */
public class Lab06_Hash_Functions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //menu_example_basic_hash();
        menu_example_hash_jce();
    }
    
    /**
     * Example, using Basic_Hash class
     */
    private static void menu_example_basic_hash()
    {
        try
        {
            String hash_block = do_hash_block_string("example.txt", 4);
            System.out.println(hash_block);
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    /**
     * Example, using Hash from JCE (SHA-256)
     */
    private static void menu_example_hash_jce()
    {
        try
        {
            do_hash_SHA_256("example.txt");
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error:" + e.getMessage());
        }
    }
}
