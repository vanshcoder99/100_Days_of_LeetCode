// Merge Intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return intervals;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<n;i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            if(end>=x) end = Math.max(end,y);
            else{
                ans.add(new int[]{start,end});
                start = x;
                end = y;
            }
        }
        ans.add(new int[]{start,end});
        int size = ans.size();
        int[][] res = new int[size][2];
        for(int i=0;i<size;i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}

// Missing And Repeating  --> GFG PRACTICE PROBLEM
import java.util.*;

class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        
        // Size of the array
        long n = nums.length;

        // Sum of first n natural numbers
        long SN = (n * (n + 1)) / 2;

        // Sum of squares of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        /* Calculate actual sum (S) and sum 
           of squares (S2) of array elements */
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        // Compute the difference values
        long val1 = S - SN;

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y using X + Y = (X^2 - Y^2) / (X - Y)
        val2 = val2 / val1;

        /* Calculate X and Y from X + Y and X - Y
           X = ((X + Y) + (X - Y)) / 2
           Y = X - (X - Y) */
        long x = (val1 + val2) / 2;
        long y = x - val1;

        // Return the results as [repeating, missing]
        return new int[]{(int) x, (int) y};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);

        // Print the repeating and missing numbers found
        System.out.printf("The repeating and missing numbers are: {%d, %d}\n", result[0], result[1]);
    }
}
