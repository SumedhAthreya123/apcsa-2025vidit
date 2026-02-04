package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        if (input == null || input.length <= 1) {
            return;
        }
        for (int idx = 1; idx < input.length; idx++) {
            int element = input[idx];
            int prev = idx - 1;

            while (prev >= 0 && input[prev] > element) {
                input[prev + 1] = input[prev];
                prev--;
            }
            input[prev + 1] = element;
        }
    }
}
