import java.io.*;
import java.util.*;

class Puzzle {
    public static int N = 3;
    public static class Node
    {

        // stores the parent node of the current node
        // helps in tracing path when the answer is found
        Node parent;
        int mat[][] = new int[N][N];// stores matrix
        int x, y;// stores blank tile coordinates
        int cost;// stores the number of misplaced tiles
        int level;// stores the number of moves so far
    }

    // Function to print N x N matrix
    public static void printMatrix(int mat[][]){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("");
        }
    }

    // Function to allocate a new node
    public static Node newNode(int mat[][], int x, int y,
                               int newX, int newY, int level,
                               Node parent){
        Node node = new Node();
        node.parent = parent;// set pointer for path to root

        // copy data from parent node to current node
        node.mat = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                node.mat[i][j] = mat[i][j];
            }
        }

        // move tile by 1 position
        int temp = node.mat[x][y];
        node.mat[x][y] = node.mat[newX][newY];
        node.mat[newX][newY]=temp;

        node.cost = Integer.MAX_VALUE;// set number of misplaced tiles
        node.level = level;// set number of moves so far

        // update new blank tile coordinates
        node.x = newX;
        node.y = newY;

        return node;
    }

    // bottom, left, top, right
    public static int row[] = { 1, 0, -1, 0 };
    public static int col[] = { 0, -1, 0, 1 };

    // Function to calculate the number of misplaced tiles
    // ie. number of non-blank tiles not in their goal position
    public static int calculateCost(int initialMat[][], int finalMat[][])
    {
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (initialMat[i][j]!=0 && initialMat[i][j] != finalMat[i][j])
                    count++;
        return count;
    }

    // Function to check if (x, y) is a valid matrix coordinate
    public static int isSafe(int x, int y)
    {
        return (x >= 0 && x < N && y >= 0 && y < N)?1:0;
    }

    // print path from root node to destination node
    public static void printPath(Node root){
        if(root == null){
            return;
        }
        printPath(root.parent);
        printMatrix(root.mat);
        System.out.println("");
    }

    // Comparison object to be used to order the heap
    public static class comp implements Comparator<Node>{
        @Override
        public int compare(Node lhs, Node rhs){
            return (lhs.cost + lhs.level) > (rhs.cost+rhs.level)?1:-1;
        }
    }

    // Function to solve N*N - 1 puzzle algorithm using
    // Branch and Bound. x and y are blank tile coordinates
    // in initial state
    public static void solve(int initialMat[][], int x,
                             int y, int finalMat[][])
    {

        // Create a priority queue to store live nodes of search tree
        PriorityQueue<Node> pq = new PriorityQueue<>(new comp());

        // create a root node and calculate its cost
        Node root = newNode(initialMat, x, y, x, y, 0, null);
        root.cost = calculateCost(initialMat,finalMat);

        // Add root to list of live nodes;
        pq.add(root);

        // Finds a live node with least cost,
        // add its childrens to list of live nodes and
        // finally deletes it from the list.
        while(!pq.isEmpty())
        {
            Node min = pq.peek();// Find a live node with least estimated cost
            pq.poll();// The found node is deleted from the list of live nodes

            // if min is an answer node
            if(min.cost == 0){
                printPath(min);// print the path from root to destination;
                return;
            }
            // do for each child of min
            // max 4 children for a node
            for (int i = 0; i < 4; i++)
            {
                if (isSafe(min.x + row[i], min.y + col[i])>0)
                {
                    // create a child node and calculate
                    // its cost
                    Node child = newNode(min.mat, min.x, min.y, min.x + row[i],min.y + col[i], min.level + 1, min);
                    child.cost = calculateCost(child.mat, finalMat);

                    // Add child to list of live nodes
                    pq.add(child);
                }
            }
        }
    }

    //Driver Code
    public static void main (String[] args)
    {

        // Initial configuration
        // Value 0 is used for empty space
        int initialMat[][] =
                {
                        {1, 2, 3},
                        {5, 6, 0},
                        {7, 8, 4}
                };

        // Solvable Final configuration
        // Value 0 is used for empty space
        int finalMat[][] =
                {
                        {1, 2, 3},
                        {5, 8, 6},
                        {0, 7, 4}
                };

        // Blank tile coordinates in initial
        // configuration
        int x = 1, y = 2;

        solve(initialMat, x, y, finalMat);
    }
}