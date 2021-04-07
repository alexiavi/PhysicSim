package simulator.factories;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.MassLoosingBody;

public class MassLoosingBodyBuilder extends Builder<Body> {
    public MassLoosingBodyBuilder() {
        super("mlb"," mass losing body" );
    }

    @Override
    public Body createTheInstance(JSONObject data) {
        return new MassLoosingBody(data.getString("id"), 
        new Vector2D( data.getJSONArray("vel")), new Vector2D(data.getJSONArray("pos")),
         data.getDouble("mass"),  data.getDouble("lossFactor"),  data.getDouble("lossFrequency"));
    }
    
    
}