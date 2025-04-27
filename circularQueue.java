import java.util.*;
class circularQueue
{
	public static void main(String[] args) {
		circularQueue cq = new circularQueue();
		cq.push(1);
		cq.push(2);
		cq.push(3);
		cq.display();
		cq.getMin();
		cq.getTop();
		cq.printFR();
	}
}
class circularQueue {
    int s = 5;
	int[] arr = new int[s];
    int f = 0, r = -1, y = 0;
    int min = Integer.MAX_VALUE;
    public  void push(int x){
        if(y == s ) {
            System.out.println("SOF");
            return;
        }
        r = ++r%s;
        y++;
        arr[r] = x;
        min = Math.min(min,x);
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
    public void getMin() {
        System.out.println("Min Element :"+min);
    }
    public void getTop() {
        System.out.println("Top element :"+arr[r]);
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