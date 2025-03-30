import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values : ");
        String input = sc.nextLine();
        String[] strarr = input.split("\\s+");
        int[] arr = new int[strarr.length];
        for (int i = 0; i < strarr.length; i++) {
            arr[i] = Integer.parseInt(strarr[i]);
        }
        Solution sol = new Solution();
        Node head = sol.constructLL(arr); // Build initial list using Solution's method

        boolean running = true;
        while (running) {
            System.out.println("\nEnter your choice:");
            System.out.println("1 : Insert a Value");
            System.out.println("2 : Delete a Value");
            System.out.println("3 : Search for a Value");
            System.out.println("4 : Exit");
            System.out.print("Choice: ");
            int choice1 = sc.nextInt();

            switch (choice1) {
                case 1: // Insert
                    handleInsert(sc, sol, head);
                    break;
                case 2: // Delete
                    handleDelete(sc, sol, head);
                    break;
                case 3: // Search
                    handleSearch(sc, sol, head);
                    break;
                case 4: // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            if (choice1 == 1 || choice1 == 2) {
                printLinkedList(head); // Print list after insert/delete
            }
        }
        sc.close();
    }

    private static void handleInsert(Scanner sc, Solution sol, Node head) {
        System.out.println("Insert options:");
        System.out.println("1 : Insert at Start");
        System.out.println("2 : Insert at End");
        System.out.println("3 : Insert at Kth Position");
        System.out.println("4 : Insert before a value");
        System.out.println("5 : Insert after a value");
        System.out.print("Choice: ");
        int choice2 = sc.nextInt();

        int val, targetval, k;
        switch (choice2) {
            case 1:
                System.out.print("Enter value: ");
                val = sc.nextInt();
                head = sol.insertAtStart(head, val);
                break;
            case 2:
                System.out.print("Enter value: ");
                val = sc.nextInt();
                head = sol.insertAtEnd(head, val);
                break;
            case 3:
                System.out.print("Enter value: ");
                val = sc.nextInt();
                System.out.print("Enter k: ");
                k = sc.nextInt();
                head = sol.insertAtPosition(head, val, k);
                break;
            case 4:
                System.out.print("Enter value: ");
                val = sc.nextInt();
                System.out.print("Enter target value: ");
                targetval = sc.nextInt();
                head = sol.insertBeforeValue(head, val, targetval);
                break;
            case 5:
                System.out.print("Enter value: ");
                val = sc.nextInt();
                System.out.print("Enter target value: ");
                targetval = sc.nextInt();
                head = sol.insertAfterValue(head, val, targetval);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void handleDelete(Scanner sc, Solution sol, Node head) {
        System.out.println("Delete options:");
        System.out.println("1 : Delete at Start");
        System.out.println("2 : Delete at End");
        System.out.println("3 : Delete at Kth Position");
        System.out.println("4 : Delete by value");
        System.out.print("Choice: ");
        int choice2 = sc.nextInt();

        int k, targetval;
        switch (choice2) {
            case 1:
                head = sol.deleteAtStart(head);
                break;
            case 2:
                head = sol.deleteAtEnd(head);
                break;
            case 3:
                System.out.print("Enter k: ");
                k = sc.nextInt();
                head = sol.deleteAtKthPosition(head, k);
                break;
            case 4:
                System.out.print("Enter target value: ");
                targetval = sc.nextInt();
                head = sol.deleteValue(head, targetval);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void handleSearch(Scanner sc, Solution sol, Node head) {
        System.out.print("Enter value to search: ");
        int val = sc.nextInt();
        boolean found = sol.searchValue(head, val);
        System.out.println(found ? "Element found!" : "Element not found!");
    }

    private static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class Node {
    int data;
    Node next;
    Node(int d) { data = d; }
}

class Solution {
    // Construct linked list from array
    Node constructLL(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Insert methods
    Node insertAtStart(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        return newNode;
    }

    Node insertAtEnd(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) return newNode;
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
        return head;
    }

    Node insertAtPosition(Node head, int val, int k) {
        if (k < 1) return head;
        Node newNode = new Node(val);
        if (k == 1) {
            newNode.next = head;
            return newNode;
        }
        Node curr = head;
        for (int i = 1; i < k - 1 && curr != null; i++) curr = curr.next;
        if (curr == null) return head; // Invalid position
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    Node insertBeforeValue(Node head, int val, int target) {
        if (head == null) return null;
        if (head.data == target) {
            Node newNode = new Node(val);
            newNode.next = head;
            return newNode;
        }
        Node curr = head;
        while (curr.next != null && curr.next.data != target) curr = curr.next;
        if (curr.next != null) {
            Node newNode = new Node(val);
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return head;
    }

    Node insertAfterValue(Node head, int val, int target) {
        Node curr = head;
        while (curr != null && curr.data != target) curr = curr.next;
        if (curr != null) {
            Node newNode = new Node(val);
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return head;
    }

    // Delete methods
    Node deleteAtStart(Node head) {
        return (head == null) ? null : head.next;
    }

    Node deleteAtEnd(Node head) {
        if (head == null || head.next == null) return null;
        Node curr = head;
        while (curr.next.next != null) curr = curr.next;
        curr.next = null;
        return head;
    }

    Node deleteAtKthPosition(Node head, int k) {
        if (k < 1 || head == null) return head;
        if (k == 1) return head.next;
        Node curr = head;
        for (int i = 1; i < k - 1 && curr.next != null; i++) curr = curr.next;
        if (curr.next != null) curr.next = curr.next.next;
        return head;
    }

    Node deleteValue(Node head, int val) {
        while (head != null && head.data == val) head = head.next;
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data == val) curr.next = curr.next.next;
            else curr = curr.next;
        }
        return head;
    }

    // Search method
    boolean searchValue(Node head, int val) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == val) return true;
            curr = curr.next;
        }
        return false;
    }
}