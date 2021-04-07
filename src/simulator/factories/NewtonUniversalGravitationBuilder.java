package simulator.factories;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;
import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;


public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws> {
    public NewtonUniversalGravitationBuilder() {
        super("nlug", "G");
    }
    @Override
    public ForceLaws createTheInstance(JSONObject data) {
        if (!data.has("G")) {
            data.put("G", 6.67E-11);
        }
        return new NewtonUniversalGravitation(data.getDouble("G"));
    }
    
}

