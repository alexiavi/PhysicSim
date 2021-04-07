package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws {

    private double G;

    public NewtonUniversalGravitation(double G) {
        this.G = G;

    }

    public void apply(List<Body> bs) {
        double force_scalar = 0.0;
        for (int i = 0; i < bs.size(); i++) {
            for(int j = 0; j < bs.size(); j++){
                if (i!= j) {
                    double aux = bs.get(i).getPosition().distanceTo(bs.get(j).getPosition());
                    aux *= aux;
                    if(aux > 0) {
                    force_scalar = G*(bs.get(i).getMass() * bs.get(j).getMass());
                    force_scalar /= aux;
                    }
                   
                    Vector2D direction = bs.get(j).getPosition().minus(bs.get(i).getPosition());
                    bs.get(j).force = direction.scale(force_scalar);


                } 
                
            }
        }
    }

    
}
