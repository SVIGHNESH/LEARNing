import java.util.Stack;

class Solution {

  private Character pop;

  public boolean isValid(String str) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
        st.push(str.charAt(i));

      } else {
        st.pop();
      }

    }
    if (st.isEmpty()) {
      return true;
    } else {

      return false;
    }

  }

  public static void main(String[] args) {
    Solution ob = new Solution();
    System.out.println(ob.isValid("{}[](()))"));
  }
}
