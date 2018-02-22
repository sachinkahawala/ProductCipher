/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sachin
 */
public class NumberBuilder {

    static long convertTo8digits(String s){
        int len = s.length();
        char temp;
        long t1=0;
        for(int i=0;i<len;i++)
        {
            temp = s.charAt(i);
            t1 += ((int)temp)*(long)Math.pow(2,i);


        }
        return t1%100000000;

    }
    static int numbersToShift(String s,int p){
        long t1=0;
        for(int i=0;i<s.length();i++)
        {
            t1+=(long)Math.pow(p,i)*Integer.parseInt(Character.toString(s.charAt(i)));
        }
        return (int)t1%95;
    }
}
