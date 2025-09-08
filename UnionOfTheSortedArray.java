import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class UnionOfTheSortedArray {

    public static ArrayList<Integer> union(int arr1[],int arr2[]){

        //Brute Force
        // Set<Integer> st = new TreeSet<>();
        // for(int i = 0 ; i<arr1.length;i++){
        //     st.add(arr1[i]);
        // }
        // for(int i = 0 ; i<arr2.length;i++){
        //     st.add(arr2[i]);
        // }
        // int un[] = new int[st.size()];
        // int idx = 0 ; 
        // for(int num : st){
        //     un[idx++] = num;
        // }

        //Optimal 

        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0 ;
         int j = 0 ; 
        ArrayList<Integer> unionArr = new ArrayList<>();
        while(i<n1 && j < n2){
            if(arr1[i] <= arr2[j]){
               if( unionArr.size()==0 || unionArr.getLast() != arr1[i]){
                unionArr.add(arr1[i]);
               } 
               i++;

            }
            else{
                if( unionArr.size()==0 || unionArr.getLast() != arr2[i]){
                unionArr.add(arr2[i]);
               } 
               j++;
            }
        }


        while(j<n2){
             if( unionArr.size()==0 || unionArr.getLast() != arr2[i]){
                unionArr.add(arr2[i]);
               } 
               j++;
        }
        while(i<n1){
            if( unionArr.size()==0 || unionArr.getLast() != arr1[i]){
                unionArr.add(arr1[i]);
               } 
               i++;
        }

        return unionArr;

    }
    
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        for(int i = 0 ; i< n1 ; i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        for(int i = 0 ; i< n2 ; i++){
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> unionArr= union(arr1,arr2);
        for(int i : unionArr){
            System.out.print(i + " ");
        }
    }
}
