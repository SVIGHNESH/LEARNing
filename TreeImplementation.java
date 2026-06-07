class Node{
  int data;
  Node left,right;

  Node(int _data){
    data = _data;
    left = right = null;
  }
}
class TreeImplementation{
  public  static void printTree(Node root){
    if(root == null ){
      return;
    }
    System.out.println(root.data);
    printTree(root.left);
    printTree(root.right);
  }
  public static void main(String[] args){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    Node temp = root;
    printTree(temp);
   // while(temp != null){
    //    System.out.println(temp);
     //   System.out.println(temp.data);
      //  temp = temp.left;
    }
    //System.out.println(root);

  
}
