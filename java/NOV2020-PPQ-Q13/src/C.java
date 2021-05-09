// Finn Lestrange - 09/05/2021
// IB Past Paper Q - November 2020 - Question 13 C

public class C extends Draw{

    public int[][] testData = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0}
    };


    public int[][] rotate(int N, int[][] A) {
        int[][] B = new int[N][N];
        for (int i = 0; i < (N - 1); i++) {
            for (int j = 0; j < (N - 1); j++) {
                B[i][j] = A[N - j - 1][i];
            }
        }
        return B;
    }

    public C() {
        System.out.println("Original Data");
        draw(10, testData);

        System.out.println();
        System.out.println("Rotated 90");
        int[][] b1 = rotate(10, testData);
        draw(10, b1);
    }

    public static void main(String[] args) {
        new C();
    }


}
