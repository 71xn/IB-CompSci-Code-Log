// Finn Lestrange - 09/05/2021
// IB Past Paper Q - November 2020 - Question 13 D


public class D extends Draw {

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
        int c;
        // Transpose, flip rows and columns
        for (int i = 0; i < (N - 1); i++) {
            for (int j = 0; j < (N - 1); j++) {
                c = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = c;
            }
        }

        // Reverse Rows // https://stackoverflow.com/questions/21920939/reverse-the-rows-of-a-2d-A
        for(int j = 0; j < A.length; j++){
            for(int i = 0; i < A[j].length / 2; i++) {
                int temp = A[j][i];
                A[j][i] = A[j][A[j].length - i - 1];
                A[j][A[j].length - i - 1] = temp;
            }
        }

        return A;
    }


    public D() {
        System.out.println("Original Data");
        draw(11, testData);

        System.out.println();
        System.out.println("Rotated 90");
        int[][] b1 = rotate(10, testData);
        draw(10, b1);

    }

    public static void main(String[] args) {
        new D();
    }


}
