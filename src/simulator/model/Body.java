package simulator.model;

import simulator.misc.Vector2D;
//import java.lang.Math;

import org.json.JSONObject;
//import org.json.JSONArray;

public class Body {
	
	protected String id;
	protected Vector2D velocity, force, position;
	protected double mass;
	
	public Body(String id, Vector2D velocity, Vector2D position, double mass) {
		this.id = id;
		this.velocity = velocity;
		this.position = position;
		this.mass = mass;
		
	}
	public String getId() {
		return id;
	}
	
	public Vector2D getVelocity() {
		return velocity;
		
	}
	
	public Vector2D getPosition() {
		
		return position;
		
	}
	
	public Vector2D getForce() {
	return force;	
	}
	

	public double getMass() {
		
		return mass;
	}
	
	void addForce(Vector2D f) {
		//Add this.force with f
		force = force.plus(f);
		
	}
	
	void resetForce() {
		force = new Vector2D(); //Sets force vector to (0,0)
	}
	
	void move(double t) {
		Vector2D acc;
		
		if (mass <= 0) {
			acc = new Vector2D(); //Creates a vector set to (0,0).
		}
		else {
			//Calculates the acceleration
			acc = force.scale(1.0 / mass);
			
			//Changes the position 
			position = position.plus((velocity.scale(t).plus(acc.scale(0.5 * t * t)))) ;
			
			//Changes velocity
			velocity = velocity.plus(acc.scale(t));
			
		}
	}

	JSONObject getState() {
		JSONObject ret = new JSONObject();
		ret.put("id", this.id);
		ret.put("m",this.mass);
		ret.put("p", this.position);
		ret.put("v", this.velocity);
		ret.put("f", this.force);

		return ret;
	}

	public String toString() {
		return getState().toString();
	}
}

