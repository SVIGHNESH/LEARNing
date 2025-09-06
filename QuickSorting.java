import java.util.Scanner;


public class QuickSorting {

    static void swap(int arr[],int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
    static int partition(int arr[],int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i<j){
            while(arr[i] <= pivot && i <= high - 1){
                i++;
            }
            while(arr[j] > pivot && j >= low +1  ){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
            
        }
        swap(arr, low, j);
         return j ;
    }
    static void qs(int arr[],int low,int high){
        if(low < high){
            int pIndex = partition(arr,low,high);
            qs(arr, low, pIndex-1);
            qs(arr, pIndex+1, high);
        }
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = sc.nextInt();
    }

    sc.close();

    qs(arr,0,n-1);

    for(int i = 0 ;i < n ; i++){
        System.out.print(arr[i]+ " ");
    }
}
}
