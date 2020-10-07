// Finn Lestrange 07/10/2020
// Program hat accepts an ATM pin number (6 digits) and validates it for conditions. If it fails any of these the PIN is rejected. Return TRUE/FALSE.

public class Challenge2 {

    public static int[] digitExtract(int n) {
        int count = 0;
        int numLength = (int) (Math.log10(n) + 1);
        int operand = 10;
        int divisor = 1;
        int[] numArray = new int[numLength];
        for (int i = (numLength - 1); i >= 0; i--) {
            numArray[i] = ((n % operand) - count) / divisor;
            count += numArray[i];
            operand = operand * 10;
            divisor = divisor * 10;
        } return numArray;
    }

    public static int sumDigits(int[] n) {
        int sum = 0;
        for (int i : n) {
            sum = sum + i;
        }
        return sum;
    }

    public static boolean isPrime(int n) {
        boolean notPrime = false;
        for(int i = 2; i <= n/2; ++i) {
            if(n % i == 0) {
                notPrime = true;
                break;
            }
        } return notPrime;
    }

    public static boolean pinValidator(int[] pin) {
        return ((pin[5] % 2 == 0) && (pin[0] % 2 == 0)) && (pin[2] < pin[4]) && (pin[1] > pin[4]) && (!isPrime(sumDigits(pin)));
    }

    public static void main(String[] args) {
        System.out.println(pinValidator(digitExtract(999721)));
    }
}
