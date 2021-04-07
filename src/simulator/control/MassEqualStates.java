package simulator.control;

import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;

import simulator.model.Body;


public class MassEqualStates implements StateComparator {

    public boolean equal(JSONObject s1, JSONObject s2) {
        boolean equal = false;
        if ( s1.getJSONArray("bodies").length() == s2.getJSONArray("bodies").length()) {
        if (s1.getDouble("time")== s2.getDouble("time") ){
            equal = true;
            int i = 0;
          while((i< s1.getJSONArray("bodies").length()) && (equal)) {
            equal = checkBodies(s1.getJSONArray("bodies").getJSONObject(i), s2.getJSONArray("bodies").getJSONObject(i));
            i++;
          }
        }
    }
        return equal;
}

public boolean checkBodies(JSONObject s1, JSONObject s2)  {
      boolean equal = true;
    if(s1.getInt("id") != s2.getInt("id")) {
        equal = false;
    }
    else if (s1.getDouble("mass")!= s2.getDouble("mass")) {
    equal = false;
 } 
  return equal;
}
}
