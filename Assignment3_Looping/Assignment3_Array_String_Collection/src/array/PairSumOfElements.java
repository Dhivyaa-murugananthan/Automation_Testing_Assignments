package arrayPrograms;

import java.util.Scanner;

public class PairSumOfElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter size of array");
		int size = sc.nextInt();//size=5

		int arr[] = new int[size];

		System.out.println("Enter array elements");

		for(int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter target sum");
		int target = sc.nextInt();//3

		System.out.println("Pairs with sum " + target + " are:");

		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[i] + arr[j] == target)
				{
					System.out.println(arr[i] + " + " + arr[j] + " = " + target);
				}
			}
		}

		sc.close();

	}

}
