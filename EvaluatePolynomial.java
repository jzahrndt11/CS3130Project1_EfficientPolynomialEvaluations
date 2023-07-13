import java.math.BigInteger;
import java.util.Random;

public class EvaluatePolynomial {
    //Brute Force Method
    static BigInteger bruteForce(BigInteger[] coefArr, BigInteger n, BigInteger x) {
        //Initialize Result
        BigInteger exp = n;
        BigInteger result = coefArr[0].multiply(x.pow(n.intValue()));

        //Evaluate using the Brute Force Method
        for (int i=1; i<n.intValue()+1; i++) {
            exp = exp.subtract(BigInteger.ONE);
            result = result.add(coefArr[i].multiply(x.pow(exp.intValue())));
        }
        return result;
    }


    //Horner's Rule Method
    static BigInteger hornersRule(BigInteger[] coefArr, BigInteger n, BigInteger x) {
        //Initialize Result
        BigInteger result = coefArr[0];

        //Evaluate using Horner's Rule
        for (int i=1; i<n.intValue()+1; i++) {
            result = result.multiply(x).add(coefArr[i]);
        }
        return result;
    }

    // Main Method
    public static void main (String[] args) {
        // n = degree of polynomial
        String degreePoly = "10";
        BigInteger n = new BigInteger(degreePoly);

        // d = the number of digits for the coefficients of the polynomial and the variable x
        Random rnd = new Random();
        int d = 6;

        BigInteger x = new BigInteger(d, rnd);

        //Coefficient Array
        //BigInteger coef = new BigInteger(d, rnd);
        //BigInteger num = coef;
        BigInteger[] coefArr = new BigInteger[n.intValue() + 1];
        // fill the array
        for(int i=0; i<n.intValue()+1; i++) {
            coefArr[i] = new BigInteger(d, rnd);
            //num = num.subtract(BigInteger.ONE);
        }

        // Find response times for both methods
            //Brute force response time
            long BFstartTime = System.currentTimeMillis();
                BigInteger bruteForceValue = bruteForce(coefArr, n, x);
            long BFendTime = System.currentTimeMillis();

            //Horner's Rule response time
            long HRstartTime = System.currentTimeMillis();
                BigInteger hornersValue = hornersRule(coefArr, n, x);
            long HRendTime = System.currentTimeMillis();

        //Display detail on polynomial
        System.out.println("->Details of Polynomial:");
        System.out.println("n = " + n + " (Degree of Polynomial)");
        System.out.println("x = " + x);
        System.out.print("Coefficients Array: { ");
        for(int i=0; i<n.intValue()+1; i++){
            System.out.print(coefArr[i]);
            System.out.print(" ");
        }
        System.out.print("}\n");
        System.out.println("------------------------------------------------------------------------");

        //Return same result from Brute force method and Horner's Rule (Must be same answer to be correct)
        System.out.println("\n->Results of Polynomials using Brute Force and Horner's Rule:");

            //Brute Force result
            System.out.println("Value of Polynomial using Brute Force Method = "  + bruteForceValue);

            //Horner's Rule Result
            System.out.println("Value of Polynomial using Horner's Rule Method = " + hornersValue);
        System.out.println("------------------------------------------------------------------------");
        System.out.println();

        //Clock the Response time for each method - milliseconds (ms)
        System.out.println("->Response time of Polynomials using Brute Force and Horner's Rule:");

            //Brute force Response time
            System.out.println("Response Time using Brute Force Method = " + (BFendTime - BFstartTime) + " milliseconds");

            //Horner's Rule Response time (Should be must faster)
            System.out.println("Response Time using Horner's Rule Method = " + (HRendTime - HRstartTime) + " milliseconds");
        System.out.println("------------------------------------------------------------------------");
    }
}
