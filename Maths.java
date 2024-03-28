import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Maths {
    public static void main(String[] args) {
        System.out.println("Enter two numbers:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
//        sieve(a, new boolean[a+1]);
//        System.out.println(findRoot(a));
//        System.out.println(Arrays.toString(factors(a)));
        System.out.println(hcf(a, b));
        System.out.println(lcm(a,b));
    }

    static int hcf(int a, int b){
        if(b%a == 0){
            return a;
        }
        return hcf(b%a, a);
    }

    static int lcm(int a, int b){
        return a*b/hcf(a,b);
    }

    static float findRootRaphson(int n){
        int left = 0;
        int right = n;

        if (n < 0) return -1; // Square root of negative number is not possible

        while ((right - left) > 1) {
            int mid = left + (right - left) / 2;
            int midSqr = mid * mid;

            if (midSqr == n) {
                return mid;
            } else if (midSqr < n) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (float) (left + n / left) / 2;
    }

    static int[] factors(int a){
        ArrayList <Integer> lst = new ArrayList<>();
        int i = 1;
        while(i*i<a){
            if(a%i==0){
                lst.add(i);
                lst.add(a/i);
            }
            i++;
        }
        Collections.sort(lst);
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }

    static float findRoot(int n){
        float left = 0;
        float right = n;
        float precision = 0.01f;

        if (n < 0) return -1; // Square root of negative number is not possible

        while ((right - left) > precision) {
            float mid = left + (right - left) / 2;
            float midSqr = mid * mid;

            if (midSqr == n) {
                return mid;
            } else if (midSqr < n) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (left + right) / 2; // Return the average of left and right as the approximate square root
    }
    public static boolean isPrime(int a){
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a%i == 0) return false;
        }
        return true;
    }
    public static int[] allPrimes(int a){
        ArrayList <Integer> lst= new ArrayList<>();
        lst.add(1);
        for (int i = 2 ; i <= a; i++) {
            if (isPrime(i)) lst.add(i);
        }
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
    static void sieve(int n, boolean primes[]){
        for (int i = 2; i*i <= n; i++) {
            if(!primes[i]){
                for (int j = i*2; j <= n; j+=i) {
                    primes[j] =true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!primes[i]){
                System.out.print(i+" ");
            }
        }
    }
}
