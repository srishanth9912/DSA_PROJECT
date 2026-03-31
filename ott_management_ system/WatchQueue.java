package TEAM_14;

class WatchQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int CAPACITY = 25;

    WatchQueue() {
        queue = new String[CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(String title) {
        if (size == CAPACITY) {
            System.out.println("Watch queue is full");
            return;
        }

        rear = (rear + 1) % CAPACITY;
        queue[rear] = title;
        size++;
        System.out.println(title + " added to watch queue");
    }

    void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Now watching: " + queue[front]);
        front = (front + 1) % CAPACITY;
        size--;
    }

    void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("\nWatch Queue (Next to Watch):");
        int idx = front;
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + queue[idx]);
            idx = (idx + 1) % CAPACITY;
        }
    }
}