package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class BuilderBasedFactory<T> implements Factory<T> {
    List<Builder <T>> _builders;
   
    public  BuilderBasedFactory(List<Builder<T>> builders){
        this._builders = builders;
    }

    @Override
    public T createInstance(JSONObject info) { // hace uno pero los demas no 
        T aux = null;
        boolean done = false;
        for (Builder<T> b: _builders) { 
           aux =  b.createInstance(info);
           if (aux != null) 
            done = true;
           return aux;
        }
        
        //if (!done) 
          //  throw new IllegalArgumentException();
        return null;
    }

    @Override
    public List<JSONObject> getInfo() {
        List<JSONObject> list = new ArrayList<JSONObject>();
        for(int i = 0; i < _builders.size(); i++) {
            list.add(_builders.get(i).getBuilderInfo());
        }
        return list;
    }
    
    
}
