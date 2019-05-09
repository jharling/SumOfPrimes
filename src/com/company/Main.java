package com.company;

public class Main {

    public static void main(String[] args) {
        //10
        /*
			The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

			Find the sum of all the primes below two million.
		*/

//			Horrible efficiency
//			System.out.println("answer: " + (sumOfPrimes(2000000L) + 2));

        System.out.println("answer: " + sieveOfEratosthenes(2000000));

//        test();
    }

    private static void test() {
        double i = 100;
        double j = 1;
        while (j < 100) {
            System.out.println((int) i + "/" + (int) j + " = " + i / j);
            j++;
        }
    }

    private static int sieveOfEratosthenes(int limit) {
        //Skipping the number 2
        int answer = 2;
        boolean flag = true;

        for (int i = 3; i < limit; i++) {
            double d = Math.sqrt((double) i);
            /*
				sqrt of i narrows down j for loop.
				Any number above sqrt of i either:
				1) If it does evenly divide i, it's not a prime number
				2) Doesn't evenly divide i
				*Proved by test() method*
			*/
            for (int j = 2; j <= d; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer = answer + i;
            }
            flag = true;
        }
        return answer;
    }

    private static Long sumPrimes(Long n) {
        Long primeNumber = 3L;
        Long answer = 0L;
        while (primeNumber < n) {
            if (checkIfPrime(primeNumber)) {
                answer = answer + primeNumber;
            }
            primeNumber = primeNumber + 2;
        }
        return answer;
    }

    private static boolean checkIfPrime(Long n) {
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
