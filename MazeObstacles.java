import java.util.*;

public class MazeObstacles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = 3, c = 3;
        boolean[][] river = new boolean[r][c];
        for (int i = 0; i < river.length; i++) {
            for (int j = 0; j < river[0].length; j++) {
                river[i][j] = in.nextInt() == 1;
            }
        }

        System.out.println(count(river, r, c));
    }

    static int count(boolean[][] bool, int r, int c) {
        if (r == 1 && c == 1) {
            return 1;
        }
        if (r <= 0 || c <= 0 || !bool[r - 1][c - 1]) {
            return 0;
        }
        return count(bool, r - 1, c) + count(bool, r, c - 1);
    }
}
