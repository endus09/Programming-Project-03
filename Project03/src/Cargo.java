/*
 * @author Markus Gulla
 */

 public class Cargo
 {
     
     //variables
     private int weight;
     private int rating;
 
     public Cargo()
     {
     }
 
     // add cargo
     public int add(Experiment n)
     {
         if (n.getInclusion() == true)
         {
             if (weight + n.getWeight() < 700)
             {
                 weight += n.getWeight();
                 rating += n.getRating();
                 return 2;
             } else
             {
                 return 0;
             }
         } else
         {
             return 1;
         }
     }

     // clear cargo
     public void clear()
     {
        weight = 0;
        rating = 0;
     }

     // set rating
     public void setRating(int i){
        this.rating = i;
     }

     // get weight
     public int getWeight(){
        return weight;
     }

     // get rating
     public int getRating(){
        return rating;
     }
 }
 
