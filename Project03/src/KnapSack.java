import java.util.Arrays;

/*
 * @author revised by: Julian Cumba
 */
public class KnapSack{

    public void knapDynamic (Experiment[] cargo){
        int n = cargo.length;
        int w = 700;
        int[] ratings = new int[cargo.length];
        int[] weights = new int[cargo.length];

        // Initialize rating and weight arrays with the values in cargo
        for (int i = 0; i < cargo.length; i++){
            ratings[i] = cargo[i].getRating();
            weights[i] = cargo[i].getWeight();
        }
        // Populate base cases
        int[][] mat = new int[n + 1][w + 1];
        for (int r = 0; r < w + 1; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            mat[c][0] = 0;
        }

        // Main logic
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxValWithoutCurr = mat[item - 1][capacity]; // This is guaranteed to exist
                int maxValWithCurr = 0; // We initialize this value to 0

                int weightOfCurr = weights[item - 1]; // We use item -1 to account for the extra row at the top
                if (capacity >= weightOfCurr) { // We check if the knapsack can fit the current item
                    maxValWithCurr = ratings[item - 1]; // If so, maxValWithCurr is at least the value of the current item

                    int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
                    maxValWithCurr += mat[item - 1][remainingCapacity]; // Add the maximum value obtainable with the remaining capacity
                }

                mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); // Pick the larger of the two
            }
        }
        System.out.println(mat[n][w]); // Final answer
        System.out.println(Arrays.deepToString(mat)); // Visualization of the table
    }
}