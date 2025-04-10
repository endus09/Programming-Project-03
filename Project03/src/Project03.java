import java.util.Arrays;

/*
 * @author Markus Gulla
 * @author Jasmine Bonitz
 */
public class Project03 {
    public static void main(String[] args) throws Exception {
        Experiment[] n = new Experiment[12];
        Cargo c = new Cargo();

        Experiment experiments[] = {
		        new Experiment("Cloud Patterns", 36, 5),
		        new Experiment("Solar Flares", 264, 9),
		        new Experiment("Solar Power", 188, 6),
		        new Experiment("Binary Stars", 203, 8),
		        new Experiment("Relativity", 104, 8),
		        new Experiment("Seed Viability", 7, 4),
		        new Experiment("Sun Spots", 90, 2),
		        new Experiment("Mice Tumors", 65, 8),
		        new Experiment("Microgravity Plant Growth", 75, 5),
		        new Experiment("Micrometeorites", 170, 9),
		        new Experiment("Cosmic Rays", 80, 7),
		        new Experiment("Yeast Fermentation", 27, 4)
        };

        System.out.println("Before sorting:");
        for (Experiment e : experiments) {
        	System.out.println(e);
        }
        System.out.println();
        
        Arrays.sort(experiments);

        System.out.println("After sorting:");
        for (Experiment e : experiments) {
        	System.out.println(e);
        }
        
        /*
        System.out.println("After sorting by age: " + experiments);
        for (int i = 0; i < n.length; i++){
            System.out.print(c.add(n[i]));
        }
        */
    }
}