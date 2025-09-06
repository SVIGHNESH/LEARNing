
import java.util.*;

class Sorting_1{

    void selection_sort(int arr[],int n ){
        for(int i = 0;i<n-1;i++){
                int mini = i ;
                for(int j = i + 1;j<n;j++){
                    if(arr[j] < arr[mini]){
                        mini = j;
                    }
                }

                int temp = arr[mini];
                arr[mini] = arr[i];
                arr[i] = temp;

            } 
    }


    void bubble_sort(int arr[],int n ){
        for(int i = n-1 ;i>=1;i--){
            for(int j = 0;j<=i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    void insertion_sort(int arr[],int n){
        for(int i = 0;i<=n-1;i++){
            int j = i;
            while(j>0 && arr[j-1] > arr[j]){
            int temp = arr[j-1];
            arr[j-1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

     public static void main(String []args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            Sorting_1 obj = new Sorting_1();

            obj.insertion_sort(arr,n);  
            
            for(int i = 0;i< n ; i++){
                System.out.print(arr[i]+" ");

            }
    }
}
