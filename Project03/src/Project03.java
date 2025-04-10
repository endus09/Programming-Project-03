
/*
 * @author Markus Gulla
 * @author Jasmine Bonitz
 */
public class Project03 {
    public static void main(String[] args) throws Exception {
        int bruteHighestIndex = 0;
        int [] bruteRatings = new int[4096];
        int [] bruteWeights = new int[4096];

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
        for (int i = 0; i < 4096; i++){
            for (int j = 0; j < 12; j++){
                n[j].include(b.getBool(i, j));
            }

            for (int k = 0; k < 12; k++){
              if  (c.add(n[k]) == 0){
                c.setRating(0);
                break;
              }
            }
            bruteRatings[i] = c.getRating();
            bruteWeights[i] = c.getWeight();

            c.clear();
        }

        // locating the highest rating from brute force
        for (int i = 1; i < 4096; i++){
            if (bruteRatings[bruteHighestIndex] < bruteRatings[i]){
                bruteHighestIndex = i;
            }
        }

        // Brute Results
        System.out.println("Best Experiments (deduced by brute force):");
        System.out.println();

        for (int j = 0; j < 12; j++){
            n[j].include(b.getBool(bruteHighestIndex, j));
            if (n[j].getInclusion() == true){
                System.out.println(n[j].toString());
            }
        }

        System.out.println();
        System.out.println("Total Rating: " + bruteRatings[bruteHighestIndex]);
        System.out.println("Total Weight: " + bruteWeights[bruteHighestIndex]);












        System.out.println("Before sorting:");
        for (Experiment e : n) {
        	System.out.println(e);
        }
         System.out.println();
        


        System.out.println("After sorting:");
        for (Experiment e : n) {
        	System.out.println(e);
        }
        
        /*
        System.out.println("After sorting by age: " + experiments);
        for (int i = 0; i < n.length; i++){
            System.out.print(c.add(n[i]));
        }
        */

        // debugging Binary Arrays
         System.out.println();
         System.out.println(b.arrayPrint(4095));
    }
}