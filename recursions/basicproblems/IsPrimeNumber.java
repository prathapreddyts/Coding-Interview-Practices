package recursions.basicproblems;

public class IsPrimeNumber {
    public boolean checkPrime(int num) {
        if(num<=1){
            return false;
        }
        return isPrimeNumberHelper(num,2);
    }

    private boolean isPrimeNumberHelper(int num, int n) {
        if(n>Math.sqrt(num)){
            return true;
        }
        if(num%n==0){
            return false;
        }
        return isPrimeNumberHelper(num,n+1);
    }
}
