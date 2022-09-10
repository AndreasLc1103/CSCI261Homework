
import java.lang.Math;
import java.util.Scanner;

public class Primes {

    /**
     * isPrime() is a function that is responsible for
     * checking to see if with a given number we are able check if the number is
     * prime
     * if it is divisible by itself and not by other factors.

     * @param int target integer end value
     * @return boolean indicating if the value is prime or not
     */
    public static boolean isPrime(int number) {
        if (number == 1){
            return false;
        }else if (number == 2 || number == 3){
            return true;
        }else if (number % 2 == 0){
            return false;
        }
        for(int i = 3; i <= Math.sqrt(number); i++ ){
            if (number % i == 0)
                return false;
        }
        return true;
    }  
     /**
     * primeChecker() is a function that is responsible from start to finish and
     * check all values to ensure that they are prime.
     * @param int target integer end value
     */
    public static void primeChecker(int target){
        for( int i = 0; i <= target; i++ ){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        primeChecker(input);
        scan.close();

    }
}