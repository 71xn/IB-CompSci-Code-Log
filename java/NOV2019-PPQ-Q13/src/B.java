// Finn Lestrange - 12/05/2021
// IB Past Paper 1 - HL - November 2019 - Question 13

public class B {

    public int[][] MAT = {
            {7,7,0,0,0,0},
            {1,2,1,0,0,0},
            {0,9,-3,5,0,0},
            {0,0,-5,6,4,0},
            {0,0,0,7,7,2},
            {0,0,0,0,5,1}
    };

    public boolean isValidMatrix(int n, int[][] A) {
        boolean invalid = false;
        int r = 0;

        /*
        The code searches row by row, checking that neighboring pairs are both non zero values
        using Math.abs(r-c)<2, e.g checking main diagonal and the sub diagonal
        If value is 0 && we are at the end of the rwo, it breaks and we increment row (r) by one
        then we move onto the next row checking each column for non-zero value and if the space between values being
        checked is not more than 2 as if it is more than two then the sub-diagonal and main diagonal contain zero
        values
        */

        while ((r < n) && !invalid) {
            int c = 0;
            while (c < n && !invalid) {
                if ((c < n) && (A[r][c]!=0 || Math.abs(r-c)<2) && A[r][c] == 0) {
                    invalid = true;
                }
                c++;
            }
            r++;
        }

        return !invalid;
    }

    public int mystery(int[][] A, int r) {
        if (r > 0) {
            return A[r][r-1] + mystery(A, r-1);
        } else {
            return 0;
        }
    }

    public B() {
        System.out.println("Answer b) " + isValidMatrix(5, MAT));
        System.out.println("Answer c) " + mystery(MAT, 5));

    }

    public static void main(String[] args) {
        new B();
    }

}
