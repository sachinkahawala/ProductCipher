/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Sachin
 */
class Decoder {
    public void Decoder()throws IOException
    {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String ip = "";
        String line=null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader("EncodedText.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                ip+=line;
            }


            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file ");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file ");

        }
        System.out.println("Enter Key");
        String k1 = obj.readLine();
        String op = "";
        System.out.println("raw cipher text");
        System.out.println(ip);
        op = transposition(ip,(int)NumberBuilder.convertTo8digits(k1)%10+1);
        System.out.println("Cipher text after detransposition");
        System.out.println(op);
        op = substitution(op.trim(),k1);
        System.out.println("Raw Text");
        System.out.println(op);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("DecodedText.txt"));
            out.write(op);
            out.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception ");

        }

    }

    String substitution(String ip, String k){
        long key = NumberBuilder.convertTo8digits(k);
        String keyAsString = Long.toString(key);
        StringBuilder s = new StringBuilder();
        int len = ip.length();
        char temp;
        int t1;
        int shiftingNumber;
        for(int i=0;i<len;i++)
        {
            temp = ip.charAt(i);
            shiftingNumber=NumberBuilder.numbersToShift(keyAsString, i);
            t1= ((int)temp-shiftingNumber);
            if(t1<32){
                t1=t1+95;
            }
            s.append((char)t1);


        }
        String op = s.toString();
        return op;
    }
    public static String transposition(String ip,int m_row)
    {

        char op[][]=new char[100][100];
        int len = ip.length();
        String op2="";
        int m_col = (int)Math.ceil((float)len/m_row);
        int i1,i2,i;
        for(i=0,i1=0,i2=0;i<len;i++)
        {
            op[i1][i2]=ip.charAt(i);
            i2++;
            if(i2==m_col)
            {
                i2=0;
                i1++;
            }
        }
        for(i1=0;i1<m_col;i1++)
        {
            for(i2=0;i2<m_row;i2++)
            {
                op2 = op2+op[i2][i1];
            }
        }
        return (op2);
    }
}
