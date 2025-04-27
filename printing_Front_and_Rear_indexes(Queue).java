import java.util.*;
class printing_Front_and_Rear_indexes {
    // This code is used to print the front and rear indexes of a circular queue.
    // It uses a circular queue implementation to manage the elements.
    // The code also handles the case when the queue is full or empty.
    // The main method takes input from the user and performs push and pop operations on the queue.
    // Finally, it prints the front and rear indexes of the queue.
{
	public static  void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		circularQueue cq = new circularQueue();
		System.out.println("Enter n :");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter array elements :");
		for(int i=0;i<n;i++) {
		    arr[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
		    if(arr[i] == 1) {
		        cq.push('1');
		    }
		    else {
		        cq.pop();
		    }
		}
		cq.printFR();
	}
}
class circularQueue {
    int s = 5;
	char[] arr = new char[s];
    int f = 0, r = -1, y = 0;
    public  void push(char x){
        if(y == s ) {
            System.out.println("SOF");
            return;
        }
        r = ++r%s;
        y++;
        arr[r] = x;
    }
    public  void pop()  {
        if(y == 0) {
            System.out.println("SUF");
            return;
        }
        if(f == r) {
            f = 0;
            r = -1;
            return;
        }
        f = ++f%s;
        y--;
    }
    public int noOfElements() {
        if(f == 0 && r == -1) {
            return 0;
        }
        if(r >= f) {
            return r-f+1;
        }
        if(r < f) {
            return s-(f-r)+1;
        }
        return -1;
    }
    public  void display() {
        for(int i=f;;i=++i%s) {
            System.out.print(arr[i]+" ");
            if(i == r) break;
        }
        System.out.println();
        return;
    }
    public void printFR() {
        if(y == s || r == -1) {
            System.out.println("No elements in Queue "+"-1");
        }
        else {
            System.out.println("f : "+f+" "+"r : "+r);
        }
    }
}