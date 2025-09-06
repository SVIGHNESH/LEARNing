import java.util.HashMap;

import java.util.Scanner;

public class _02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0;i<n ;i++){
            arr[i] = sc.nextInt();
        }

       //precompute
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0 ; i< n; i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0 )+ 1);

        }

        mpp.forEach((key,value)->{
            System.out.println("key: "+ key +", Value: " + value);
        });
                                                       

        int q = sc.nextInt();
        while(q-- > 0){
            int number = sc.nextInt();
            //fetch 
           System.out.println(mpp.getOrDefault(number,0));


        }

        

    }
}
