import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node() {
        this.data = 0;
        this.next = null;
}

    Node(int d) {
        this.data = d;
        this.next = null;
    }// constructor to create a new node

}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); 
        int t = Integer.parseInt(scanner.nextLine());
        while (t--> 0) {
            String line=scanner.nextLine(); 
            String[] numStrings = line.split(" "); 
            int[] arr = new int[numStrings.length]; 
            for (int i = 0; i < numStrings.length; i++) {
                arr[i] = Integer.parseInt(numStrings[i]);
            }
            Solution ob=new Solution();
            Node ans=ob.constructLL(arr);
            while (ans != null) {
                System.out.print(ans.data + " ");
                ans=ans.next;
            }
            System.out.println();
            System.out.println("~");
        }
    }
    scanner.close();
}
class Solution {
    static Node constructLL(int arr[]) {
        // code here
        Node head=new Node(arr[0]);
        Node current=head;
        for(int i=1;i<arr.length;i++)
        {
            Node newnode=new Node(arr[i]);
            current.next=newnode;
            current=newnode;
        }
        return head;
    }
}