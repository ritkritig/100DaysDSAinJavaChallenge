public class Day93 {

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key at its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 4, 6, 1, 3};

        insertionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}