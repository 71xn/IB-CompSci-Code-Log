// Finn Lestrange 07/10/2020
// Program that accepts two integer arrays (same size) and returns an array full of values that exist in both of them. If sizes do not match return ERROR.

import java.util.ArrayList;

public class Challenge4 {

    public static ArrayList<Integer> numCheck(int[] a1, int[] a2) {

        ArrayList<Integer> common = new ArrayList<>();

        for (int i : a1) {
            for (int x : a2) {
                if (i == x) {
                    common.add(i);
                    break;
                }
            }
        }
        if (common.size() < 1) {
            System.out.println("ERROR NO MATCHES");
            return common;
        } else {
            return common;
        }
    }

    public static void main(String[] args) {

        int[] a1 = new int[] {10,20,223,30,100,5,120};
        int[] a2 = new int[] {45,32,5,29,120,43,223};

        int[] a3 = new int[] {111,222,333};
        int[] a4 = new int[] {444,555,666};

        System.out.println(numCheck(a1, a2));
        System.out.println(numCheck(a3, a4));

    }

}
