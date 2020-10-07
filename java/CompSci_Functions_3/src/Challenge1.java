// Finn Lestrange 07/10/2020
// Program that accepts a number (like 123) and returns an integer array filled with the numbers as many times.

import java.util.Arrays;

public class Challenge1 {

    public static long[] digitExtract(int n) {
        long count = 0;
        int numLength = (int) (Math.log10(n) + 1);
        long operand = 10;
        long divisor = 1;
        long[] numArray = new long[numLength];
        for (int i = (numLength - 1); i >= 0; i--) {
            numArray[i] = ((n % operand) - count) / divisor;
            count += numArray[i];
            operand = operand * 10;
            divisor = divisor * 10;
        } return numArray;
    }

    public static String[] numTimes(long[] numArray) {

        String[] out = new String[numArray.length];

        for (int i = 0; i < out.length; i++) {
            int temp = (int) numArray[i];
            switch (temp) {
                case 1 -> out[i] = "1";
                case 2 -> out[i] = "22";
                case 3 -> out[i] = "333";
                case 4 -> out[i] = "4444";
                case 5 -> out[i] = "55555";
                case 6 -> out[i] = "666666";
                case 7 -> out[i] = "7777777";
                case 8 -> out[i] = "88888888";
                case 9 -> out[i] = "999999999";
            }
        } return out;
    }

    public static void main(String[] args) {

        int num1 = 123765;
        long[] numA1 = digitExtract(num1);

        System.out.println(Arrays.toString(numTimes(numA1)));
    }
}
