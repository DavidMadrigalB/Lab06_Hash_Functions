package lab06_hash_functions;

import static lab06_hash_functions.File_Operations.*;
/**
 * Basic hash implementation with xor
 * @author David Madrigal Buendía
 * @version 1.1
 */
public class Basic_Hash {
    /**
     * Method to do hash block with xor, the block size depends from m
     * @param file_name The file name where the bytes will read
     * @param m exponential of 2^m bits
     * @return Byte array with the resulting hash block
     * @exception Exception m can't be less than 3
     */
    public static byte[] do_hash_block(String file_name, int m) throws Exception
    {
        int i, j;
        long n;
        if(m < 3)
        {
            throw new Exception("m debe ser mayor que 3");
        }
        n = 1 << m; // n = 2^m
        // We get the number of bytes for xor
        m = (int) n/8;
        
        byte[] bytes = read_file(file_name);
        // For each byte, we have 8 bits
        byte[] hash_byte = new byte[m];
        
        for(i = 0; i < bytes.length; i += 2 * m)
        {
            for(j = 0; j < m; j++)
            {
                try
                {
                    hash_byte[j] = logical_xor(bytes[i + j], bytes[i + j + m]);
                }catch(Exception e) 
                // We need to add padding or just complete with "0"s for lack of data to the logical xor
                {
                    hash_byte[j] = logical_xor(bytes[i + j], (byte) 0);
                }
            }
        }
        
        save_file_encode_base64("hash.txt", hash_byte);
        return hash_byte;
    }
    
    /**
     * Method to do hash block with xor, the block size depends from m. But returns a string in bit's representation
     * @param file_name The file name where the bytes will read
     * @param m exponential of 2^m bits
     * @return Bits representation in a string
     * @see do_hash_block
     */
    public static String do_hash_block_string(String file_name, int m) throws Exception
    {
        byte[] hash_bytes = do_hash_block(file_name, m);
        return converts_string_binary_format(hash_bytes);
    }
    
    /**
     * Method to do logical_xor with two bytes
     * @param a first data byte
     * @param b second data byte
     * @return the output of logical xor in data byte
     */
    public static byte logical_xor(byte a, byte b)
    {
        return (byte) (a ^ b);
    }
    
    /**
     * Method to converts to String some byte data
     * @param data A byte array value
     * @return Bits value from data byte in string
     */
    private static String converts_string_binary_format(byte[] data)
    {
        String binario = "";
        int i;
        for(i = data.length - 1; i >= 0; i--)
        {
            binario += converts_string_binary_format(data[i]);
        }
        return binario;
    }
    
    /**
     * Method to converts to String some byte data
     * @param data A byte value
     * @return Bits value from data byte in string
     */
    private static String converts_string_binary_format(byte data)
    {
        String bits;
        // To left pad, resulting string with zeros
        bits = String.format("%8s", 
            Integer.toBinaryString(data & 0xFF))
            .replace(' ', '0');
        return bits;
    }
    
    /*
    public static String logical_xor(String a, String b)
    {
        int i;
        int tam = a.length();
        String bits = "";
        for(i = 0; i < tam; i++)
        {
            if((a.charAt(i) == '0' && b.charAt(i) == '0') ||
                    (a.charAt(i) == '1' && b.charAt(i) == '1'))
            {
                bits+= "0";
            }else if((a.charAt(i) == '0' && b.charAt(i) == '1') ||
                    (a.charAt(i) == '1' && b.charAt(i) == '0'))
            {
                bits+= "1";
            }
        }
        return bits;
    }
    */
}