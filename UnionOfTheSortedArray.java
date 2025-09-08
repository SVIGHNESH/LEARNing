import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class UnionOfTheSortedArray {

    public static int[] union(int arr1[],int arr2[]){
        Set<Integer> st = new TreeSet<>();
        for(int i = 0 ; i<arr1.length;i++){
            st.add(arr1[i]);
        }
        for(int i = 0 ; i<arr2.length;i++){
            st.add(arr2[i]);
        }
        int un[] = new int[st.size()];
        int idx = 0 ; 
        for(int num : st){
            un[idx++] = num;
        }

        return un;

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
        int unionSet[] = union(arr1,arr2);
        for(int i = 0 ; i< unionSet.length;i++){
            System.out.print(unionSet[i] + " ");
        }
    }
}
