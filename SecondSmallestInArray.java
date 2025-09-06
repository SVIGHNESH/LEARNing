import java.util.*;
public class SecondSmallestInArray {

    static int secondSmallest(int arr[] , int n  ){
        int smallest = Integer.MAX_VALUE;
        int ssmallest = -1;
        for(int i = 0 ; i < n ; i++ ){
            if(arr[i] < smallest){
                ssmallest  = smallest;
                smallest = arr[i];

            }
            else if(arr[i] > smallest && arr[i] < ssmallest ){
                ssmallest = arr[i];
            }
        }
        return ssmallest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i< n ;i++){
            arr[i] = sc.nextInt();
        }
       
        System.out.println( secondSmallest(arr,n));
    }
}
