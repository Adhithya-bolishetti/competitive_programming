import java.io.*;
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class MergeSortedLists {

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static Node readList(Scanner sc) {
        Node head = null, tail = null;
        while (true) {
            int val = sc.nextInt();
            if (val == -1) break;
            Node newNode = new Node(val);
            if (head == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Node merged = null;

        for (int i = 0; i < k; i++) {
            Node list = readList(sc);
            merged = mergeTwoLists(merged, list);
        }
         Node temp = merged;
         while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}