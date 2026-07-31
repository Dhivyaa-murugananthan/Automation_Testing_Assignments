package arrayPrograms;

import java.util.Scanner;

public class SecondLargestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of array");
		int size = sc.nextInt(); //5

		int arr[] = new int[size];

		System.out.println("Enter array elements");

		for(int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();

		}

		int largest = arr[0];
		int secondLargest = arr[0];

		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > largest)
			{
				secondLargest = largest;
				largest = arr[i];
			}
			else if(arr[i] > secondLargest && arr[i] != largest)
			{
				secondLargest = arr[i];
			}
		}

		System.out.println("Second Largest element: " + secondLargest);

		sc.close();

	}

}
