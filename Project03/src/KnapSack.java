/*
 * @author revised by: Julian Cumba
 * @author Fabian Terh - Medium.com
 */
public class KnapSack{

    public static void knapDynamic (Experiment[] cargo){
        int n = cargo.length;
        int w = 700;
        int[] ratings = new int[cargo.length];
        int[] weights = new int[cargo.length];
        int weightOfCurr;

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
                int maxRatingWithoutCurr = mat[item - 1][capacity]; // This is guaranteed to exist
                int maxRatingWithCurr = 0; // We initialize this value to 0

                weightOfCurr = weights[item - 1]; // We use item -1 to account for the extra row at the top
                if (capacity >= weightOfCurr) { // We check if the knapsack can fit the current item
                    maxRatingWithCurr = ratings[item - 1]; // If so, maxRatingWithCurr is at least the value of the current item

                    int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
                    maxRatingWithCurr += mat[item - 1][remainingCapacity]; // Add the maximum value obtainable with the remaining capacity
                }

                mat[item][capacity] = Math.max(maxRatingWithoutCurr, maxRatingWithCurr); // Pick the larger of the two
            }
        }


        printKnapSack(cargo, n, ratings, weights, mat);
    }

    /*
     * This method goes back through the matrix and checks what items were added
     * If they were added, it prints them.
     */
    private static void printKnapSack(Experiment[] cargo, int n, int[] ratings, int[] weights, int[][] mat) {
      //  System.out.println(Arrays.deepToString(mat)); // Visualization of the table  ---> UN-COMMENT THIS TO SEE MATRIX VISUAL REPRESENTATION

        // -----------------------------Print out the Results-------------------------------\\
        int capacity = 700;
        int totalWeight = 0;
        int totalRating = 0;

        System.out.print("Subset Based on 0/1 KnapSack Solution:\n");
        System.out.print("==============================================\n");
        System.out.printf("%-30s %-9s %-7s%n", "Experiment:", "Weight:", "Rating:");
        System.out.printf("%-30s %-9s %-7s%n", "-----------", "-------", "-------");

        for (int i = n; i > 0 && capacity > 0; i--) {
            int itemWeight = weights[i - 1];
            int itemRating = ratings[i - 1];

            // Checks item to see if it was one of the items included to be optimal
            // i.e. if the item fit, and the rating is different from the previous
            if (capacity >= itemWeight && mat[i][capacity] == mat[i - 1][capacity - itemWeight] + itemRating) {
                
                System.out.printf("%-30s %-9d %-7d%n", cargo[i - 1].getName(), itemWeight, itemRating);
                
                totalWeight += itemWeight;
                totalRating += itemRating;
                capacity -= itemWeight;
            }
        }
        System.out.print("\nTotal Rating: " + totalRating);
        System.out.print("\nTotal Weight: " + totalWeight);
        System.out.print("\n");
        System.out.print("==============================================\n");
    }
}