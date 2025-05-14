import java.util.*;
class Array {
	int n;
	int arr[];
	int sum;

	void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in array");
		n=sc.nextInt();
		arr=new int[n];
		System.out.println("Enter Array elements");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	void sum() {
		sum=0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
		}
		System.out.println("Sum: "+sum);
	}
	
	
	void sort() {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if(arr[i] > arr[j]) {
 					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("Biggest elements: "+arr[n-1]);
	}
	
	void display() {
		System.out.println("Array elements");	
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	} 
	
	public static void main(String args[]) {
		Array obj = new Array();
		obj.accept();
		obj.display();
		obj.sort();
		obj.display();
		obj.sum();
	}
}