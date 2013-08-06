/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mate
 */
public class WeightingRandom {

    public static class Weighting {

        int value;
        int weighting;

        public Weighting(int v, int w) {
            this.value = v;
            this.weighting = w;
        }
    }

    public static int weightedRandom(List<Weighting> weightingOptions) {

        //determine sum of all weightings
        int total = 0;
        for (Weighting w : weightingOptions) {
            total += w.weighting;
        }

        //select a random value between 0 and our total
        int random = new Random().nextInt(total);

        //loop thru our weightings until we arrive at the correct one
        int current = 0;
        for (Weighting w : weightingOptions) {
            current += w.weighting;
            if (random < current) {
                return w.value;
            }
        }
        //shouldn't happen.
        return -1;
    }
    
    public int getWeightingRandom(int numberOfList, int... weights){
        List<Weighting> weightings = new ArrayList<>();
        for(int i=1; i<numberOfList+1;i++){
            weightings.add(new Weighting(i, weights[i-1]));
        }
        return weightedRandom(weightings);
    }
    
}
