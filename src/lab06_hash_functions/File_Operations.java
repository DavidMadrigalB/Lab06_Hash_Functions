package lab06_hash_functions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 *
 * @author David Madrigal Buendía
 */
public class File_Operations {
    /**
     * Method to read some file
     * @param file_name The name of a file to read
     * @return byte array with the content of the file
     */
    protected static byte[] read_file(String file_name) throws IOException
    {
        // Read file's bytes
        File file = new File(file_name);
        return Files.readAllBytes(file.toPath());
    }
    
    /**
     * Method to read some file, decoding from base64
     * @param file_name The name of a file to read
     * @return byte array with the content of the file
     * @see read_file
     */
    protected static byte[] read_file_decode_base64(String file_name) throws IOException
    {
        // Decode bytes in base64 encoded
        return Base64.getDecoder().decode(read_file(file_name));
    }
    
    /**
     * Method to write a file, encoding with base64
     * @param file_name The name of the output file
     * @param bytes The content of the file
     */
    protected static void save_file_encode_base64(String file_name, byte[] bytes) throws IOException
    {
        // Creates an instance of a file
        File file = new File(file_name);
        FileOutputStream fos = new FileOutputStream(file);
        // Save bytes using base64 encoded
        fos.write(Base64.getEncoder().encode(bytes));
        fos.close();
    }
}