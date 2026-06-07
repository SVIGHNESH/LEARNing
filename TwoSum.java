
import java.util.Arrays;
import java.util.Scanner;
public class TwoSum {

    public static String twoSum(int n, int arr[],int target){
            Arrays.sort(arr);
            int left = 0;
            int right = n-1;
            while(left < right){
                if(arr[left] + arr[right] < target){
                    left++;
                }
                else if(arr[left] + arr[right] > target){
                    right--;
                }
                else{
                    return "YES";
                }
            }
            return "NO";
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
            
        }
        
        int target = sc.nextInt();
        sc.close();

        System.out.println(twoSum(n,arr,target));
      


        
    }
}
