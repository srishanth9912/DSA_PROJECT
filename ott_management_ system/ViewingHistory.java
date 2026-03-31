package  TEAM_14;

class ViewingHistory {
    private String[] history;
    private int top;
    private static final int CAPACITY = 30;

    ViewingHistory() {
        history = new String[CAPACITY];
        top = -1;
    }

    void push(String title) {
        if (top == CAPACITY - 1) {
            System.out.println("History is full");
            return;
        }
        history[++top] = title;
        System.out.println("Added to history");
    }

    void pop() {
        if (top == -1) {
            System.out.println("History is empty");
            return;
        }
        System.out.println("Removed: " + history[top]);
        top--;
    }

    void peekLast() {
        if (top == -1) {
            System.out.println("History is empty");
            return;
        }
        System.out.println("Last watched: " + history[top]);
    }

    void showAll() {
        if (top == -1) {
            System.out.println("No viewing history");
            return;
        }

        System.out.println("\nViewing History (Recent First):");
        for (int i = top; i >= 0; i--) {
            System.out.println((top - i) + 1 + ". " + history[i]);
        }
    }
}