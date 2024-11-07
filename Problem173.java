//TC: O(n)
//SC: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;  // The first ugly number is 1
        
        int p2 = 0, p3 = 0, p5 = 0;  // Pointers for multiples of 2, 3, and 5
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        
        for (int i = 1; i < n; i++) {
            // Choose the next ugly number to be the smallest of the multiples
            int nextUgly = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            ugly[i] = nextUgly;
            
            // Increment the pointer for which multiple was used
            if (nextUgly == nextMultipleOf2) {
                p2++;
                nextMultipleOf2 = ugly[p2] * 2;
            }
            if (nextUgly == nextMultipleOf3) {
                p3++;
                nextMultipleOf3 = ugly[p3] * 3;
            }
            if (nextUgly == nextMultipleOf5) {
                p5++;
                nextMultipleOf5 = ugly[p5] * 5;
            }
        }
        
        return ugly[n - 1];  // Return the nth ugly number
    }
}
