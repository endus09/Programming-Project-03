/*
 * @author Markus Gulla
 * @author Jasmine Bonitz
 */
public class Experiment implements Comparable<Experiment> {
	private String name;
	private int weight;
	private int rating;
	private int ratio;
	private boolean inclusion;
	
	public Experiment(String name, int weight, int rating) {
		this.name = name;
		this.weight = weight;
		this.rating = rating;
		this.ratio = weight / rating;
		this.inclusion = true;
	}
	
	// include or exclude experiment
	public void include(boolean b){
		this.inclusion = b;
	}

	// return inclusion
	public boolean getInclusion(){
		return inclusion;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @return the ratio
	 */
	public int getRatio() {
		return ratio;
	}

	@Override
	public String toString() {
		return "Experiment: " + name + ", Weight: " + weight + ", Rating: " + rating + "]";
	}

	@Override
	public int compareTo(Experiment o) {
		return Integer.compare(this.weight, o.weight);
	}
}