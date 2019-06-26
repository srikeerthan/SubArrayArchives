package Problems;
import java.util.Scanner;

class SplitAnArrayIntoTwoEqualSumSubArrays {
	public static void main (String[] args) {
        System.out.println("Enter number of values in the array:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] intArray = new int[n];
        int rightSum = 0;
        for(int i=0; i<n; i++)
        {
            int value =sc.nextInt();
            intArray[i] = value;
            rightSum += value;
        }
        sc.close();
        int i = getIndexToSplitArray(intArray, rightSum);
        if(i == -1)
        {
            System.out.println("Not Possible");
        }
        else
        {
            for(int j=0; j<n; j++)
            {
                if(j == i) System.out.println();
                System.out.print(intArray[j] + ", ");
            }
        }
    }
    
    private static int getIndexToSplitArray(int[] intArray, int rightSum)
    {
        int leftSum = 0;
        for(int i=0; i<intArray.length; i++)
        {
            leftSum += intArray[i];
            rightSum -= intArray[i];
            if(leftSum == rightSum)
            {
                return i;
            }
        }
        return -1;
    }
}