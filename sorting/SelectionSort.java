package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        if (input == null || input.length <= 1) {
            return;
        }

        for (int pos = 0; pos < input.length - 1; pos++) {
            int minPos = pos;
            for (int scan = pos + 1; scan < input.length; scan++) {
                if (input[scan] < input[minPos]) {
                    minPos = scan;
                }
            }
            if (minPos != pos) {
                int swap = input[pos];
                input[pos] = input[minPos];
                input[minPos] = swap;
            }
        }
    }
}
