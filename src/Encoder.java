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
import java.nio.file.Files;
import java.nio.file.Paths;

class Encoder {
    public void Encoder()throws IOException
    {

        String ip = null;
        try
        {
            ip = new String ( Files.readAllBytes( Paths.get("C:\\Users\\Sachin\\IdeaProjects\\ProductCipher\\src\\ToBeEncoded.txt") ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Key");
        String k1 = obj.readLine();
        String op = "";
        op = substitution(ip,k1);
        op = tansposition(op,(int)NumberBuilder.convertTo8digits(k1)%10);
        System.out.println(op);
        try {
            BufferedWriter encodedOutPut = new BufferedWriter(new FileWriter("C:\\Users\\Sachin\\IdeaProjects\\ProductCipher\\src\\EncodedText.txt"));
            encodedOutPut.write(op);
            encodedOutPut.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception ");

        }
    }
    public static String substitution(String ip, String k){
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
            t1= ((int)temp+shiftingNumber-32)%95+32;
            s.append((char)t1);


        }
        String op = s.toString();
        return op;
    }
    String tansposition(String ip,int m_row)
    {
        char op[][]=new char[100][100];
        int len = ip.length();
        String op2="";
        int i1,i2,i;
        int m_col = (int)Math.ceil((float)len/m_row);

        for(i=0,i1=0,i2=0;i<len;i++)
        {
            op[i2][i1]=ip.charAt(i);
            i2++;
            if(i2==m_row)
            {
                i2=0;
                i1++;
            }
        }

        for(i1=0;i1<m_row;i1++)
        {
            for(i2=0;i2<m_col;i2++)
            {
                if(op[i2][i1]!='\u0020') {
                    op2 = op2 + op[i1][i2];
                }
            }
        }
        return (op2);
    }
}
