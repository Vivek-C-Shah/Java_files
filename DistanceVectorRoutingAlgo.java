import java.util.Scanner;

class DistanceVectorRoutingAlgo {
    static class Node {
        int[] dist;
        int[] from;

        Node(int n) {
            dist = new int[n];
            from = new int[n];
        }
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x_1 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int y_1 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int x_2 = Math.min(topRight[i][0], topRight[j][0]);
                int y_2 = Math.min(topRight[i][1], topRight[j][1]);

                if (x_1 < x_2 && y_1 < y_2) {
                    int side = Math.min(x_2 - x_1, y_2 - y_1);
                    maxArea = Math.max(maxArea, (long) side * side);
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        int[][] dmat = new int[n][n];
        Node[] rt = new Node[n];
        for (int i = 0; i < n; i++) {
            rt[i] = new Node(n);
        }

        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dmat[i][j] = scanner.nextInt();
                dmat[i][i] = 0;
                rt[i].dist[j] = dmat[i][j];
                rt[i].from[j] = j;
            }
        }

        int count;
        do {
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (rt[i].dist[j] > dmat[i][k] + rt[k].dist[j]) {
                            rt[i].dist[j] = rt[i].dist[k] + rt[k].dist[j];
                            rt[i].from[j] = k;
                            count++;
                        }
                    }
                }
            }
        } while (count != 0);

        for (int i = 0; i < n; i++) {
            System.out.println("\nState value for router " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.println("\tNode " + (j + 1) + " via " + (rt[i].from[j] + 1) + " Distance " + rt[i].dist[j]);
            }
        }
    }
}