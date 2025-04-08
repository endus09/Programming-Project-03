/*
 * @author Markus Gulla
 * 
 * @author Revised by Jasmine Bonitz
 */

import java.util.ArrayList;
import java.util.List;

public class Project03 {
    public static void main(String[] args) throws Exception {
        Experiment[] n = new Experiment[12];

        List<Experiment> experiments = new ArrayList<>();
        experiments.add(new Experiment("Cloud Patterns", 36, 5));
        experiments.add(new Experiment("Solar Flares", 264, 9));
        experiments.add(new Experiment("Solar Power", 188, 6));
        experiments.add(new Experiment("Binary Stars", 203, 8));
        experiments.add(new Experiment("Relativity", 104, 8));
        experiments.add(new Experiment("Seed Viability", 7, 4));
        experiments.add(new Experiment("Sun Spots", 90, 2));
        experiments.add(new Experiment("Mice Tumors", 65, 8));
        experiments.add(new Experiment("Microgravity Plant Growth", 75, 5));
        experiments.add(new Experiment("Micrometeorites", 170, 9));
        experiments.add(new Experiment("Cosmic Rays", 80, 7));
        experiments.add(new Experiment("Yeast Fermentation", 27, 4));


        System.out.println("Before sorting: " + experiments);

        //Collections.sort(experiments, new RatingComparator());

        System.out.println("After sorting by age: " + experiments);
    }
}
