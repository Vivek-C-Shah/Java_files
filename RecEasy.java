public class RecEasy {
    public static void main(String[] args) {
        int n = 1342;
//        System.out.println(sum(n));
//        System.out.println((n*(n+1))/2);
//        System.out.println(sumOfDigits(n));
//        System.out.println(prodOfDigits(n));
//        System.out.println(numRev(n));
//        int num = Integer.parseInt(numRev(n));
        System.out.println(countZeroes(30502));

    }
    public static int numberOfSteps(int n) {
        return (numOfStepsHelper(n, 0));
    }
    public static int numOfStepsHelper(int n, int steps){
        if(n==0) return steps;
        if(n%2 == 0) return numOfStepsHelper(n/2, ++steps);
        else return numOfStepsHelper(n-1, ++steps);
    }
    public static int countZeroes(int n){
        return countZeroesHelper(n,0);
    }
    public static int countZeroesHelper(int n, int count){
        if(n==0) return count;
        if(n%10 == 0) count++;
        return countZeroesHelper(n/10, count);
    }
    public static String numRev(int n){
        if(n == 0) return "";
        return(String.valueOf(n % 10) + numRev(n/10));
    }
    public static int sumOfDigits(int n){
        if(n<=0) return 0;
//        int a = (int) Math.pow(10, (int) Math.log10(n));
//        return((n/a) + sumOfDigits(n-(a*(n/a))));
        return((int) n%10 + sumOfDigits(n/10));
    }
    public static int prodOfDigits(int n){
        if(n==0) return 1;
        return (n%10 * prodOfDigits(n/10));
    }
    public static void fun(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        fun(n-1);
        System.out.println(n);
    }
    public static int fact(int n){
        if (n==1){
            return 1;
        }
        return(n*fact(n-1));
    }
    public static int sum(int n){
        if (n==1){
            return 1;
        }
        return(n+sum(n-1));
    }
}
