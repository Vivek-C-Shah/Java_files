/**
 * DicePerm
 */

import java.util.*;
public class DicePerm {

    public static void main(String[] args) {
        // take input
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        String p = "";
        permDice(p, target);
        // System.out.println(dicePermCount(target));
        in.close();
    }

    public static int dicePermCount(int target){
        if(target == 0){
            return 1;
        }
        int count = 0;
        for(int i = 1; i <= 6 && target - i >= 0; i++){
            count += dicePermCount(target - i);

        }
        return count;

    }

    public static void permDice(String p, int tar){
        if(tar == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i<=tar; i++) {
            permDice(p+i, tar-i);
        }
    }
}