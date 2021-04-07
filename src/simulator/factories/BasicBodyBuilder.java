package simulator.factories;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {
	public BasicBodyBuilder() {
		super("basic", " creates default body");
	}

	@Override
	public Body createTheInstance(JSONObject data) {
		return new Body(data.getString("id"),
		 new Vector2D (data.getJSONArray("pos")), 
		 new Vector2D(data.getJSONArray("vel")) , data.getDouble("mass"));
	}
}
