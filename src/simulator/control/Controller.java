package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Body;
import simulator.model.PhysicsSimulator;

public class Controller {
	
    private PhysicsSimulator sim;
    private Factory<Body> factory;
    public Controller(PhysicsSimulator ps,Factory<Body> factory ) {
            sim = ps;
            this.factory = factory;
    }
    public void loadBodies(InputStream in) {
        JSONObject jsonInput = new JSONObject(new JSONTokener(in));
        JSONArray body = jsonInput.getJSONArray("bodies"); //getting the array of bodies
        for(int i=0; i<body.length(); i++) {
            sim.addBody(factory.createInstance(body.getJSONObject(i)));
        }
    }

    public void run(int n, OutputStream out, InputStream expOut, StateComparator cmp) throws NotEqualException{
        JSONArray states = null;
        PrintStream p = new PrintStream(out);
       
        // run the sumulation n steps , etc.
        p.println("]");
        p.println("}");
    
            if(expOut != null){
                JSONObject jsonInput = new JSONObject(new JSONTokener(expOut));
                states = jsonInput.getJSONArray("states");
            }
            p.println("{");
            p.println("\"states\": [");
    
            for(int i = 0; i <n; i++) {
                sim.advance();
                JSONObject cur_st = sim.getState();
                if(expOut != null && !cmp.equal(states.getJSONObject(i), cur_st)) {
                    throw new NotEqualException(states.getJSONObject(i),cur_st, i);
                }
               
                       }
            p.println("]");
            p.println("}");

    }

       
    


    
}
