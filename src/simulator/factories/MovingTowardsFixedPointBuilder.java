package simulator.factories;

import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;


public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws> {

    public MovingTowardsFixedPointBuilder() {
        super("FixedPoint", "Force that moves towards a fixed point");
    }
    @Override
    public ForceLaws createTheInstance(JSONObject data) {
        if(!data.has("point")) {
            Vector2D point = new Vector2D();
            data.put("point", point);
        }
        if (!data.has("G")) { // if error check G or g 
           data.put("G", 9.81) ;
        }
    
        return new  MovingTowardsFixedPoint(new Vector2D(data.getJSONArray("point")), data.getDouble("G"));
    }

}
