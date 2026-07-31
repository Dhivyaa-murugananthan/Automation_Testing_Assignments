package arrayPrograms;

import java.util.Scanner;

public class ReverseArrayWithoutUsingAnotherArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of array");
		int size = sc.nextInt();

		int arr[] = new int[size];

		System.out.println("Enter array elements");

		for(int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}

		int start = 0;
		int end = arr.length - 1;

		while(start < end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}

		System.out.println("Reversed Array:");

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}

		sc.close();

	}

}
