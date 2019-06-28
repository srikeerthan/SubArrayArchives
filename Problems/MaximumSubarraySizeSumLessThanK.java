package Problems;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarraySizeSumLessThanK
{
    public static void main(String[] args) {
        System.out.println("enter number of elements in the Array:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("enter elements in the array");
        int[] intArray = new int[n];
        for(int i = 0; i < n; i++)
        {
            intArray[i] = sc.nextInt();
        }
        System.out.println("Enter the sum value: ");
        int k = sc.nextInt();
        sc.close();
        int[] preSum = new int[n+1];
        Arrays.fill(preSum, 0);
        for(int i = 0; i < n; i++)
        {
            preSum[i+1] = preSum[i] + intArray[i];
        }
        int max = getMaximunSize(preSum, n, k);
        System.out.println("Maximum SubArray size is: " + max);
    }

    private static int getMaximunSize(int[] preSum, int n, int k)
    {
        int ans = -1;
        int l = 1, r = n;
        while(l <= r)
        {
            int mid = (l+r)/2;
            int i;
            for(i = mid; i <= n; i++)
            {
                if(preSum[i]- preSum[i-mid] > k) break;
            }
            if(i == n+1)
            {
               l = mid + 1;
               ans = mid; 
            }
            else
            {
                r = mid - 1; 
            }
        }
        return ans;
    }
}
