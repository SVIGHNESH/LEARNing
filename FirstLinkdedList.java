class Node {

    int data;
    Node next;

    Node(int data, Node ptr) {
        this.data = data;
        this.next = ptr;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static Node convertArrtoLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void printLL(Node head){
        Node temp = head;
        while(temp.next != null){
            System.out.println(temp.data);
            
            if(temp.next.next == null  ){
                System.out.println(temp.next.data);
                
            }
            temp = temp.next;
        }
    }

}

public class FirstLinkdedList {
    public static void main(String[] args) {
        int arr[] = { 2, 24, 21, 54, 25 };
        // Node n1 = new Node(arr[0],null);
        // Node n2 = new Node(arr[1],null);
        // Node n3 = new Node(arr[2],null);
        // Node n4 = new Node(arr[3],null);
        // Node n5 = new Node(arr[4],null);


        Node head = Node.convertArrtoLL(arr);
        
        
        Node.printLL((head));

    }

}
