package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws {
    public MovingTowardsFixedPoint(Vector2D point, double g) {
        this.point = point;
        this.g = g;
    }

    private Vector2D point;
    private double g;

    public void apply(List<Body> bs) {
        for (int i = 0; i < bs.size(); i++) {
            double aux = bs.get(i).mass / g;
            Vector2D vect = point.minus(bs.get(i).position);
            bs.get(i).force = vect.scale(aux);
        }
    }
}
