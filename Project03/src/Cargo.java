// by Markus Gulla

public class Cargo {
int weight;
int rating;
    public Cargo(){}

    public void add(Experiment n){
        if (weight + n.weight < 700)
    {
        weight += n.weight;
        rating += n.rating;
    }
    }
}
