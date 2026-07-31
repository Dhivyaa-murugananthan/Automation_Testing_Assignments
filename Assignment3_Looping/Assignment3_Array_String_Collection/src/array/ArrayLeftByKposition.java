package arrayPrograms;

import java.util.Scanner;

public class ArrayLeftByKposition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int []arr=new int[size];
		System.out.println("Enter the array elements");
		for(int i=0; i<size; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter K value");
		int k = sc.nextInt();//k=2

		for(int i = 1; i <= k; i++)
		{
			int first = arr[0];//12

			for(int j = 0; j < arr.length - 1; j++)
			{
				arr[j] = arr[j + 1];
			}

			arr[arr.length - 1] = first;
		}

		System.out.println("Array after left rotation:");

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}

		sc.close();

	}

}
