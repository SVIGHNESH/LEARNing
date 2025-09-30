import java.util.*;

class JosephusProblem {
    static void solve(ArrayList<Integer> person, int k, int index, int ans[]) {
        if (person.size() == 1) { // base case
            ans[0] = person.get(0);
            return;
        }
        index = (index + k) % person.size(); 
        person.remove(index); 
        solve(person, k, index, ans); 

        return;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // NOw it should be clear just like what i am seeing in my computer
        int n = 7, k = 2;
        ArrayList<Integer> person = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            person.add(sc.nextInt());
        }
        sc.close();
        int ans[] = new int[1];
        ans[0] = -1;
        solve(person, k - 1, 0, ans);
        System.out.println("The safe position is: " + ans[0]);
    }
}
