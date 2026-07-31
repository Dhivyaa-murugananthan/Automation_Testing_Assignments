package arrayPrograms;

import java.util.Scanner;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter size of array");
		int size = sc.nextInt();

		int arr[] = new int[size];

		System.out.println("Enter array elements");

		for(int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}

		int index = 0;

		// Move non-zero elements forward
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] != 0)
			{
				arr[index] = arr[i];
				index++;
			}
		}

		// Fill remaining positions with zeros
		while(index < arr.length)//0<5//1<5...
		{
			arr[index] = 0;
			index++;
		}

		System.out.println("Array after moving zeros to end:");

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}

		sc.close();

	}

}
