/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
/**
 *
 * @author Sachin
 */
class Decoder {
    public void Decoder()throws IOException
    {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter IP:");
        String ip = obj.readLine();
        System.out.println("Enter Key");
        String k1 = obj.readLine();
        String op = "";
        op = transposition(ip,(int)NumberBuilder.convertTo8digits(k1)%10);
        op = substitution(op,k1);
        System.out.println(op);
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

    String transposition(String ip,int m_row)
    {
        char op[][]=new char[100][100];
        int len = ip.length();
        String op2="";
        int i1,i2,i;
        int m_col = (int)Math.ceil((float)len/m_row);

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
                if(op[i2][i1]!='\u0020'){
                op2 = op2+op[i2][i1];}
            }
        }
        return (op2);
    }
}
