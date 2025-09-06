import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateTheArrayToLeftByK {

    static void reverse(int arr[] , int start , int end ){
        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp ;
             start++;
             end--;
        }
    }
    static void leftRotate(int arr[] , int n , int d){

        //brute force

         d= d%n;
        // List<Integer> temp = new ArrayList<>();
        // for(int i = 0 ; i<d ; i++){
        //     temp.add(arr[i]);
        // }
        // for(int i = d ; i<n ; i++){
        //     arr[i-d] = arr[i];
        // }
        // for(int i = n-d ; i<d ; i++){
        //     arr[i] = temp.get(i-(n-d));
        // }
        reverse(arr,0,d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);


        //optimal



    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i< n ; i++){
            arr[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        sc.close();
        leftRotate(arr,n,d);
        for(int i = 0 ;i< n ; i++){
            System.out.print(arr[i] + " ");

        }
        
    }

}
