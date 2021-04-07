package simulator.factories;

import org.json.JSONObject;

import simulator.control.EpsilonEqualStates;
import simulator.control.StateComparator;

public class EpsilonEqualStatesBuilder extends Builder<StateComparator> {
  public EpsilonEqualStatesBuilder() {
	  super("epseq", "Compares eplison states");
  }
    @Override
    public  StateComparator createTheInstance(JSONObject data) {
       if(!data.has("eps")) {
           data.put("eps", 0.0);
       }
       return new EpsilonEqualStates(data.getDouble("eps"));
    }
    
}
