package com.company.packageMain;

public class RecursionMain {
    static int l = 0;
    static int multiplier = 10;

    static int fact(int n) {
        if (n == 1)
            return 1;
        else
            return n * fact(n - 1);
    }

    static int numRev(int n) {
        if (n < 10) {
            return n;
        } else {
            int d = numRev(n / 10);
            int r = n % 10;
            l = r * multiplier + d;
            multiplier *= 10;
            return l;
        }
    }

    public static void main(String[] args) {
        System.out.println(numRev(104011));
    }
}
