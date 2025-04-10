
/*
 * @author Markus Gulla
 * @author Jasmine Bonitz
 * @author Caleb Park
 * @author Julian Cumba
 */
public class Project03
{

    public static void main(String[] args) throws Exception
    {
        int bruteHighestIndex = 0;
        int[] bruteRatings = new int[4096];
        int[] bruteWeights = new int[4096];

        Experiment[] n = new Experiment[12];
        Cargo c = new Cargo();
        BinaryArrays b = new BinaryArrays();

        n[0] = new Experiment("Cloud Patterns", 36, 5);
        n[1] = new Experiment("Solar Flares", 264, 9);
        n[2] = new Experiment("Solar Power", 188, 6);
        n[3] = new Experiment("Binary Stars", 203, 8);
        n[4] = new Experiment("Relativity", 104, 8);
        n[5] = new Experiment("Seed Viability", 7, 4);
        n[6] = new Experiment("Sun Spots", 90, 2);
        n[7] = new Experiment("Mice Tumors", 65, 8);
        n[8] = new Experiment("Microgravity Plant Growth", 75, 5);
        n[9] = new Experiment("Micrometeorites", 170, 9);
        n[10] = new Experiment("Cosmic Rays", 80, 7);
        n[11] = new Experiment("Yeast Fermentation", 27, 4);

        // brute force implementation
        for (int i = 0; i < 4096; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                n[j].include(b.getBool(i, j));
            }

            for (int k = 0; k < 12; k++)
            {
                if (c.add(n[k]) == 0)
                {
                    c.setRating(0);
                    break;
                }
            }
            bruteRatings[i] = c.getRating();
            bruteWeights[i] = c.getWeight();

            c.clear();
        }

        // locating the highest rating from brute force
        for (int i = 1; i < 4096; i++)
        {
            if (bruteRatings[bruteHighestIndex] < bruteRatings[i])
            {
                bruteHighestIndex = i;
            }
        }

        // Brute Results
        System.out.print("\nBest Experiments (deduced by brute force):\n");
        System.out.printf("==============================================\n");
        System.out.printf("Experiment: %-16s Weight: %-1s Rating:\n", "", "");
        System.out.printf("----------- %-16s ------- %-1s -------\n", "", "");

        for (int j = 0; j < 12; j++)
        {
            n[j].include(b.getBool(bruteHighestIndex, j));
            if (n[j].getInclusion() == true)
            {
                System.out.println(n[j].toString());
            }
        }

        System.out.println();
        System.out.println("Total Rating: " + bruteRatings[bruteHighestIndex]);
        System.out.println("Total Weight: " + bruteWeights[bruteHighestIndex]);
        System.out.printf("\n==============================================\n");

        for (int i = 0; i < 12; i++)
        {
            n[i].include(true);
        }

    // questions 1 to 3
        SelectionSort.sort(n, Experiment.BY_WEIGHT);
        System.out.println("Subset Based on Weight:");
        printResults(n);

        SelectionSort.sort(n, Experiment.BY_RATING);
        System.out.println("Subset Based on Rating:");
        printResults(n);

        SelectionSort.sort(n, Experiment.BY_RATIO);
        System.out.println("Based on Rating/Weight Ratio:");
        printResults(n);

    }

    // Prints the subset of experiments and total rating 
    private static void printResults(Experiment[] experiments)
    {
        // Reset weight and rating to 0
        int weight = 0;
        int rating = 0;
        System.out.printf("==============================================\n");
        System.out.printf("Experiment: %-16s Weight: %-1s Rating:\n", "", "");
        System.out.printf("----------- %-16s ------- %-1s -------\n", "", "");
        for (Experiment e : experiments)
        {
            if (weight + e.getWeight() <= 700)
            {
                weight += e.getWeight();
                rating += e.getRating();
                System.out.println(e);
            }
        }
        System.out.printf("\nTotal Rating: " + rating);
        System.out.printf("\nTotal Weight: " + weight);
        System.out.printf("\n\n==============================================\n");
    }

}
