// Selection sort in Java
// From Programiz 
import java.util.Comparator;

public class SelectionSort {
    public static void sort(Experiment[] array, Comparator<Experiment> comparator) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int minIndex = step;

            for (int i = step + 1; i < size; i++) {
                if (comparator.compare(array[i], array[minIndex]) < 0) {
                    minIndex = i;
                }
            }

            // Swap array[step] and array[minIndex]
            Experiment temp = array[step];
            array[step] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}