/*
 * @author Markus Gulla 
 */


 // This class creates 4096 boolean arrays of 12 with every single possible combination
 public class BinaryArrays
 {
 
     boolean[][] arrays;
 
     public BinaryArrays()
     {
 
         this.arrays = new boolean[4096][12];
 
         for (int i = 0; i < 4096; i++)
         {
             String bit = Integer.toBinaryString(i);
             int extra = 12 - bit.length();
             String addon = "";
             for (int j = 0; j < extra; j++)
             {
                 addon += "0";
             }
             String bitString = addon + bit;
             char[] charArray = bitString.toCharArray();
             for (int k = 0; k < 12; k++)
             {
                 if (charArray[k] == '1')
                 {
                     this.arrays[i][k] = true;
                 } else
                 {
                     this.arrays[i][k] = false;
                 }
             }
         }
     }
 
     // get boolean
     public boolean getBool(int index, int test)
     {
         return arrays[index][test];
     }
 
     // test tool
     public String arrayPrint(int n)
     {
         String print = "";
         for (int i = 0; i < 12; i++)
         {
             print += arrays[n][i] + " ";
         }
         return print;
     }
 
 }
 