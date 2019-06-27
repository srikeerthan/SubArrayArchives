package Problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubArraysWithDistinctElements
{
   public static void main(String[] args) {
        System.out.println("Enter number of elements in the Array:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] intArray = new int[n];
        for(int i = 0; i < n; i++)
        {
            intArray[i] = sc.nextInt();
        }
        sc.close();
        int ans = 0, j = 0;
        Set<Integer> intSet = new HashSet<>();
        for(int i = 0; i < n; i++)
        {
            while(j < n && !intSet.contains(intArray[j]))
            {
                intSet.add(intArray[j]);
                j++;
            }
            ans += ((j-i)*(j-i+1))/2;
            intSet.remove(intArray[i]);
        }
        System.out.println("answer is:" +ans);
    }
}