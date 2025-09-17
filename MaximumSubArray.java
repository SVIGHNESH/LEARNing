    import java.util.Scanner;

public class MaximumSubArray {
    public static int[] toPrintTheMaximumSubArray(int arr[], int n ){
            int maxi = Integer.MIN_VALUE;
            int sum = 0;
            int ansStart = -1;
            int ansEnd = -1;
           
            for(int i = 0 ; i<n;i++){
                if(sum == 0){
                    ansStart = i;
                }
                sum+=arr[i];
                if(sum > maxi){
                    maxi = sum;
                    
                    ansEnd = i;
                }
                if(sum < 0 ){
                    sum = 0 ;
                }
                
            }
            return new int[]{ansStart,ansEnd};
    }
    public static int toFindTheMaximumSubArraySum(int arr[], int n ){
        int sum = 0 ; 
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i<n;i++){
            sum +=arr[i];
            if(sum>maxi){
                maxi = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.print("Printing the Maximum Sum of SubArray : ");
        System.out.println(toFindTheMaximumSubArraySum(arr, n));
        int ans[] = toPrintTheMaximumSubArray(arr, n);
        System.out.print("Now Printing the Maximum SubArray : ");
        for(int i = ans[0] ; i<=ans[1];i++){
            System.out.print(arr[i] + " ");
        }
    }
}
