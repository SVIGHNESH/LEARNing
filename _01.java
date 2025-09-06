import java.util.*;
import java.io.*;

class _01 {
    public static void main(String[] args) throws Exception {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
       
        // System.out.println();
        // precompute
        int hash[] =new int[256];
        // Arrays.fill(hash, 0);
        for(int i = 0 ; i<s.length();i++){
            hash[s.charAt(i)]++;
        }


       
 
 
        int q = Integer.parseInt(sc.nextLine());

       

        while (q-- > 0) {

            // fetch
            char c = sc.next().charAt(0);
            // System.out.println(c);
            System.out.println(hash[c]);
        }
        sc.close(); 
    }
}