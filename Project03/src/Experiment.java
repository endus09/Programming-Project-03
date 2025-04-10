/*
 * @author Markus Gulla
 * @author Jasmine Bonitz
 * @author revisions by Caleb Park
 */
import java.util.Comparator;

public class Experiment implements Comparable<Experiment>
{

    private String name;
    private int weight;
    private int rating;
    private double ratio;
    private boolean inclusion;

    public static final Comparator<Experiment> BY_WEIGHT = Comparator.comparingInt(Experiment::getWeight);
    public static final Comparator<Experiment> BY_RATING = Comparator.comparingInt(Experiment::getRating).reversed();
    public static final Comparator<Experiment> BY_RATIO = Comparator.comparingDouble(Experiment::getRatio).reversed();

    public Experiment(String name, int weight, int rating)
    {
        this.name = name;
        this.weight = weight;
        this.rating = rating;
        this.ratio = rating / (double) weight;
        this.inclusion = true;
    }

    // include or exclude experiment
    public void include(boolean b)
    {
        this.inclusion = b;
    }

    // return inclusion
    public boolean getInclusion()
    {
        return inclusion;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the weight
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * @return the rating
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * @return the ratio
     */
    public double getRatio()
    {
        return ratio;
    }

    @Override
    public String toString()
    {
        //return "Experiment: " + name + ", Weight: " + weight + ", Rating: " + rating + "]";
        return String.format("%-25s %7s %8s", name, weight, rating);
    }

    @Override
    public int compareTo(Experiment o)
    {
        return Integer.compare(this.weight, o.weight);
    }
}
