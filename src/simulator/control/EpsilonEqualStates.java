package simulator.control;

import org.json.JSONObject;

import simulator.misc.Vector2D;

// meter c math si hay problemas luego
public class EpsilonEqualStates implements StateComparator {
    private double eps;
    public EpsilonEqualStates(double epsilon) {
        eps = epsilon;
    }
    public boolean equal(JSONObject s1, JSONObject s2) {
        boolean equal = false;
        if (s1.getDouble("time")== s2.getDouble("time") ){
            equal = true;
          
            if(s1.getInt("id") != s2.getInt("id")) {
                equal = false;
            }
           double doubles1 = s1.getDouble("mass");
           double doubles2 = s2.getDouble("mass");
           double total = doubles1 - doubles2;
         if (Math.abs(total) > eps) {
                equal = false;
             }
            Vector2D vectors1, vectors2; 
            vectors1 = new Vector2D (s1.getJSONArray("position")); // noo se puede ? hacer escalar??''
            vectors2 = new Vector2D(s2.getJSONArray("position"));
            if (vectors1.distanceTo(vectors2) > eps) {
                    equal = false;
            }
            vectors1 =new Vector2D(s1.getJSONArray("velocity"));
            vectors2 =new Vector2D(s2.getJSONArray("velocity"));
            if (vectors1.distanceTo(vectors2) > eps) {
                    equal = false;
            }
            vectors1 = new Vector2D(s1.getJSONArray("force"));
            vectors2 = new Vector2D(s2.getJSONArray("force"));
            if (vectors1.distanceTo(vectors2) > eps) {
                    equal = false;
            }

        }
        return equal;
    }

}
