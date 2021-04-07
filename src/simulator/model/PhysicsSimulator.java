package simulator.model;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhysicsSimulator {
    private double timePerStep;
    private ForceLaws Laws;
    private List<Body> bs;
    static double cur_time;
    public PhysicsSimulator(double timePerStep, ForceLaws Laws) {
        if (timePerStep > 0) {
            this.timePerStep = timePerStep;
        } else {
            throw new IllegalArgumentException("[EXCEPTION]: TIME IS A NON-POSITIVE VALUE");
        }

        if (Laws != null) {
            this.Laws = Laws;
        } else{
            throw new IllegalArgumentException("[EXCEPTION]: FORCE LAWS ARE NULL");
        }
        
        cur_time = 0;

        bs = new ArrayList<Body>();
    }

    public void advance(){
        for(int i = 0; i<bs.size(); i++) {
            bs.get(i).resetForce();
        }
            Laws.apply(bs);
    
        for(int i= 0; i<bs.size(); i++) {
            bs.get(i).move(timePerStep);
        }
        cur_time += timePerStep;       
    }

    public void addBody(Body b){  
        boolean equals = false;
        for (Body body : bs) {
            if(body.getId().equals(b.getId())){
                equals = true;
                throw new IllegalArgumentException("[EXCEPTION]: THERE IS A BODY WITH THE SAME ID");
            }
        }
        if(!equals){
        bs.add(b);
        }
    }


    public String toString() {
        return getState().toString();
    }

    public JSONObject getState() {
        JSONObject state = new JSONObject();
        state.put("time", cur_time);
        JSONArray jbs = new JSONArray();
        for(Body b: bs) {
            jbs.put(b.getState());
        }
       state.put("bodies", jbs);
       
        return state;
    }
    
}
