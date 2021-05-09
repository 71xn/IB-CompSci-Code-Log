public class Draw {

    public void draw(int N, int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int c = 0;
            System.out.println();
            for (int j = 0; j <  A.length; j++) {
                if (A[i][j] == 1) {
                    System.out.print("⬛");
                } else {
                    System.out.print("⬜");
                }
            }
        }
    }

}
