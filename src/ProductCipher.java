
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

/**
 *
 * @author Sachin
 */



import java.io.*;

    public class ProductCipher {
        public static void main(String[] args)throws IOException
        {
            System.out.println("Enter choice");
            System.out.append("1.Encryption\n2.Decryption\n");
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
            int ch = Integer.parseInt(obj.readLine());
            if(ch==1)
            {
                Encoder e = new Encoder();
                e.Encoder();
            }
            else if(ch==2)
            {
                Decoder d = new Decoder();
                d.Decoder();
            }
            else
            {
                System.out.println("Invalid Choice");
            }
        }
    }







