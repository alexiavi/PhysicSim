package simulator.factories;

import java.util.List;

import org.json.JSONObject;

public abstract class Builder<T> {
    protected String name, desc;
 
    public Builder(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public Builder () {

    }
	public T createInstance(JSONObject info) {
        T auxiliar = null;
        if((this.name != null) && (name.equals(info.getString("type")) )) { // aqui esta el problema 
                auxiliar = createTheInstance(info.getJSONObject("data"));
        }

        return auxiliar;
    }

	public JSONObject getBuilderInfo() {
        JSONObject auxiliar = new JSONObject();
        auxiliar.put("type", this.name);
        auxiliar.put("desc", desc);
        auxiliar.put("data", new JSONObject());
      
        return auxiliar;
    }

    public abstract T createTheInstance(JSONObject data);
}