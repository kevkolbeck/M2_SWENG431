/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kevin
 */

import java.util.Random;

public class Lab2 {
    //coefficents = my user id = 9073270.81
    static int a = 9;
    static int b = 0;
    static int c = 7;
    static int d = 3;
    static int e = 2;
    static int f = 7;
    static int g = 0;
        
    static double terminationDifference = .00001;   
       
    //function for the given polynomial   
    public static double polynomial(double x){
        return a*Math.pow(x, 6)
               - b*Math.pow(x,5)
               + c*Math.pow(x,4)
               - d*Math.pow(x,3)
               + e*Math.pow(x,2)
               - f*x
               +g;
    }
    
    //derivative of the given function 
    public static double derivativePolynomial(double x){
        return 6*a*Math.pow(x, 5)
               - 5*b*Math.pow(x,4)
               + 4*c*Math.pow(x,3)
               - 3*d*Math.pow(x,2)
               + 2*e*x
               - f;
    }
     
    //Newton-Raphson method
    public static void newtonRaph(double x0){
        /// need to set these both for the first execution of the newton-raphson formula
        double xCurrent = x0;
        double xNew = x0;
            
        for (int i=1; i<= 2000; i++){
            double derivative = derivativePolynomial(xCurrent);
                
            // don't dividing by zero
            if (Math.abs(derivative) < 0.0000000001) {
                System.out.printf(
                    "x0 = %10.6f | don't divide by 0%n",
                    x0
                );
            return;    
            }
   
            //Newton Raphson formula (with derivate computued above)
            xNew = xCurrent - polynomial(xCurrent)/derivative;
            
            //terminate if good result found
            if(Math.abs(xNew - xCurrent)< terminationDifference){
            System.out.printf(
                    "x0 = %10.6f | Root = %10.6f | "
                    + "Iterations = %4d | f(root) = %.10f%n",
                    x0, xNew, i, polynomial(xNew));   
            return;
            }
            //if havent found root, new becomes current guess for next iteration
            xCurrent = xNew;
        }
            
        //no solution found
        System.out.printf(
                "x0 = %10.6f | Not Found%n",
                x0
        );
    }
     
    public static void main(String[] args){
         Random random = new Random();
        
        //test 50 different starting guesses
        for (int i = 0; i < 50; i++) {
            // Random number from -100 to +100
            double x0 = -100 + 200 * random.nextDouble();

            newtonRaph(x0); 
        }
    }
}
