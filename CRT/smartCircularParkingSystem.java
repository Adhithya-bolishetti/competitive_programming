import java.util.*;

class Car {
    int id;
    int timestamp;

    Car(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}

public class smartCircularParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int maxTime = sc.nextInt();
        List<Car> queue = new ArrayList<>();

        while (true) {
            int op = sc.nextInt();
            if (op == 0) break;

            switch (op) {
                case 1: { 
                    int carID = sc.nextInt();
                    int time = sc.nextInt();

                    if (queue.size() == capacity) {
                        queue.remove(0);
                    }

                    queue.add(new Car(carID, time));
                    break;
                }

                case 2: {
                    if (!queue.isEmpty()) {
                        queue.remove(0);
                    }
                    break;
                }

                case 3: { 
                    int carID = sc.nextInt();
                    for (int i = 0; i < queue.size(); i++) {
                        if (queue.get(i).id == carID) {
                            queue.remove(i);
                            break;
                        }
                    }
                    break;
                }

                case 4: { 
                    int currentTime = sc.nextInt();
                    Iterator<Car> it = queue.iterator();
                    while (it.hasNext()) {
                        Car car = it.next();
                        if (currentTime - car.timestamp > maxTime) {
                            it.remove();
                        }
                    }

                    if (!queue.isEmpty()) {
                        for (int i = 0; i < queue.size(); i++) {
                            System.out.print(queue.get(i).id);
                            if (i < queue.size() - 1) System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }
        }
    }
}







//Question
// A smart circular parking system can hold up to N cars. Cars enter from the rear and exit from the front (FIFO). Each car has a unique ID and entry timestamp (in minutes). If a car stays longer than T minutes, it must be removed (either automatically or via a force remove).

// Force Remove: When you remove a car by its carID, the queue should indeed shift all subsequent cars forward to fill the empty spot, just like a typical array operation. The front and rear pointers must be updated accordingly, and the size of the queue should decrease.While Enqueue,if queue is full then Dequeue.

// Implement 4 operations: 1 carID timestamp → Enqueue (park a car). 2 → Dequeue (remove car from front). 3 carID → Force remove (remove specific car). 4 currentTimestamp → Get parking status (removes overstayed cars, print remaining car IDs). 0 → Exit

// SAMPLE INPUT AND OUTPUT

// INPUT

// 4 300

// 1 101 50

// 1 102 100

// 1 103 150

// 1 104 200

// 2

// 1 105 250

// 4 350

// 1 106 400

// 4 450

// 3 102

// 4 500

// 0

// OUTPUT

// 102 103 104 105

// 103 104 105 106

// 104 105 106

// Input Format

// Input Format • First line: two integers N and T (max capacity and max time allowed) • Next lines: operations as described above • 0 indicates end of input

// Constraints

// n>0 and T>0

// Output Format

// Output Format • For every operation type 4, output a space-separated list of carIDs currently parked in order.