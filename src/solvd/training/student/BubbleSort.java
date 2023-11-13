public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {2, 1, 6, 7, 4, 8, 9, 3, 23, 6, 30, 90};
        bubbleSort(array);
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
