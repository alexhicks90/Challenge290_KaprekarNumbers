/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaprekarnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author ahick
 */
public class KaprekarNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        int count = 0; 
        
        while(!exit) {                   
            
            System.out.println("Please enter the first integer in the range: ");        
            int start = in.nextInt();

            System.out.println("Please enter the last integer in the range: ");        
            int end = in.nextInt();
            
            // exit loop 
            if (end < start) {
                System.out.println("ending number must be greater than starting number");
                exit = true;
            }
            
            System.out.println("Kaprekar Numbers: ");
            
            for (int i = start; i <= end; i++) {
                         
                int result = checkNum(i);
                
                if (result != -1) {
                    System.out.println(result);
                    count++;
                }
            }
            
            if (count == 0) {
                System.out.println("None Found.");
            }
            
            System.out.println("\nHit e to exit, any other key to re-run program.");
            char exitChar = in.next().charAt(0);
            
            if (exitChar == 'e') {
                exit = true;
            }
        } 
        
        System.exit(0);
    }  
    
    // Returns num if it is Kaprekar, otherwise returns -1
    private static int checkNum(int num) {       
        
        int result = (int)Math.pow(num, 2);     
        String stringResult = String.valueOf(result);  
                
        if (stringResult.length() == 1) {
            return -1;
            
        } else {
        
            for (int i = 1; i < stringResult.length(); i++) {

                String s1 = stringResult.substring(0, i);
                String s2 = stringResult.substring(i, stringResult.length());
                int num1 = Integer.parseInt(s1);
                int num2 = Integer.parseInt(s2);
                int sum = num1 + num2;

                if (sum == num) {      
                    
                    if (num1 == 0 || num2 == 0) {
                        return -1;     
                        
                    } else {                       
                        return sum;                      
                    }
                }
            }
        }
        
        return -1;
    }
}
