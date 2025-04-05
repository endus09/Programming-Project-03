/*
 * @author Markus Gulla
 * 
 * 
 */

public class Experiment {
String name;
int weight;
int rating;
int ratio;

// initializing
    public Experiment(String n, int w, int r){
        name = n;
        weight = w;
        rating = r;
        ratio = w/r;
    }
}
