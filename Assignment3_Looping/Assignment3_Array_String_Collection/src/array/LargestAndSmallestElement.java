package arrayPrograms;

import java.util.Scanner;

public class LargestAndSmallestElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of array");
		int size = sc.nextInt();//5

		int arr[] = new int[size];

		System.out.println("Enter array elements");

		for(int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}

		int largest = arr[0];
		int smallest = arr[0];

		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > largest)
			{
				largest = arr[i];
			}

			if(arr[i] < smallest)
			{
				smallest = arr[i];
			}
		}

		System.out.println("Largest element in the given Array is : " + largest);
		System.out.println("Smallest element in the given Array is : " + smallest);
		sc.close();
	}

	

}
