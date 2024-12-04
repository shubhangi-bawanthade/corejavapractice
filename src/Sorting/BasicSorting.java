package Sorting;

public class BasicSorting {
	public static void main(String[] args) {
		int arr[]= {5,4,1,2,3};
		printarray(arr);
		insertionSort(arr);
		printarray(arr);
	}
	
	
	public static void bubbleSor(int arr[])
	{
		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
				int tmp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=tmp;
				}
			}
		}
		
	}
	
	public static void selectionSort(int arr[])
	{
		int minpos=0;
		for(int i=0;i<arr.length;i++)
		{
			minpos=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[minpos]>arr[j])
				{
					minpos=j;
				}
			}
			if(minpos!=i)
			{
			int tmp=arr[minpos];
			arr[minpos]=arr[i];
			arr[i]=tmp;
			}
		}
		
	}
	
	public static void insertionSort(int arr[])
	{
		int j=0;
		for(int i=1;i<arr.length;i++)
		{
			j=i-1;
			int k=arr[i];
			
			while(j>=0 && arr[j]>k)
			{
				arr[j+1]=arr[j];
				j--;
				
			}
			arr[j+1]=k;
		}
		
	}
	
	public static void printarray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
