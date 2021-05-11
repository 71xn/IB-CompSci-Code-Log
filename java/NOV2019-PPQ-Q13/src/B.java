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
