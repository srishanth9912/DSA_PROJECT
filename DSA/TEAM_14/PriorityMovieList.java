package TEAM_14;

class PriorityMovieList {
    private String[] titles;
    private int[] priorities;
    private int count;
    private static final int CAPACITY = 30;

    PriorityMovieList() {
        titles = new String[CAPACITY];
        priorities = new int[CAPACITY];
        count = 0;
    }

    void addWithPriority(String title, int priority) {
        if (count == CAPACITY) {
            System.out.println("Priority list is full");
            return;
        }

        if (priority < 1 || priority > 3) {
            System.out.println("Invalid priority");
            return;
        }

        titles[count] = title;
        priorities[count] = priority;
        count++;
        System.out.println(title + " added with priority " + priority);
    }

    void display() {
        if (count == 0) {
            System.out.println("Priority list is empty");
            return;
        }

        sort();

        for (int i = 0; i < count; i++) {
            System.out.println(titles[i] + " -> " + priorities[i]);
        }
    }

    void remove(String title) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Movie not found");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            titles[i] = titles[i + 1];
            priorities[i] = priorities[i + 1];
        }

        count--;
    }

    private void sort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (priorities[j] > priorities[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int i, int j) {
        String t = titles[i];
        titles[i] = titles[j];
        titles[j] = t;

        int p = priorities[i];
        priorities[i] = priorities[j];
        priorities[j] = p;
    }
}