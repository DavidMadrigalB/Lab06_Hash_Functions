package lab06_hash_functions;

import java.security.MessageDigest;
import static lab06_hash_functions.File_Operations.read_file;
import static lab06_hash_functions.File_Operations.save_file_encode_base64;

/**
 *
 * @author David Madrigal Buendía
 */
public class Hash_JCE_Service {
    /**
     * Method to do hash with SHA-256
     * @param file_name The file name where the bytes will read
     * @see do_hash_SHA_256
     */
    public static void do_hash_SHA_256(String file_name) throws Exception
    {
        do_hash_SHA_256(file_name, "hash_JCE.txt");
    }
    
    /**
     * Method to do hash with SHA-256
     * @param file_name The file name where the bytes will read
     * @param output_file The output file with the hash value
     */
    public static void do_hash_SHA_256(String file_name, String output_file) throws Exception
    {
        MessageDigest sha3 = MessageDigest.getInstance("SHA-256");
        byte[] bytes = read_file(file_name);
        sha3.update(bytes);
        byte[] hash_value = sha3.digest();
        //Save the hash in a file
        save_file_encode_base64(output_file + ".txt", hash_value);
    }
}