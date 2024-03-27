package com.sumit.datastructures.g_primenumber;

// Sieve Of Eratosthenes : to get all prime numbers till N
public class PrimeNumber_3_SOE {

    public static void main(String[] args) {
        int n=36;
        System.out.println("All prime numbers till " + n + " are : ");
        allPrimeNumbersWithSieve(n);
    }

    // This SOE Better approach because time complexity is = n * log(log n)     << better
    // Whereas traditional approach has complexity as      = n * sqrt(n)
    private static void allPrimeNumbersWithSieve(int n){
        // boolean array default initializes with false. Hence, we named it notPrimeNumbers.
        // it means initially we are considering all the numbers are prime. and we will keep on updating numbers which are not prime (multiple of current number)
        // in this array which are true will be considered as not prime numbers
        boolean[] notPrimeNumbersArr = new boolean[n+1];

        for(int i = 2; i*i <= n; i++) {
            // if notPrimeNumbersArr[i] value is false, it means it can be a prime number.
            // but its multiple are definitely not a prime number.
            // hence straight away mark its multiple as not prime
            if(!notPrimeNumbersArr[i]) {             // skip this index if it is already marked as not prime
                for (int j = i*2; j <= n; j=j+i) {   // for i=2 keep on adding 2 => 2,4,6,8,10,..., for i=3 keep on adding 3
                    notPrimeNumbersArr[j] = true;
                }
            }
        }

        // print all the indexes where notPrimeNumbersArr[] value is false
        for(int i = 2; i <= n; i++) {
            if(!notPrimeNumbersArr[i])
                System.out.print(i + " ");
        }
    }

}