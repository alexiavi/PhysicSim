package simulator.model;

import simulator.misc.Vector2D;

public class MassLoosingBody extends Body {

	protected double lossFactor;
	protected double lossFrequency;
	private static double counter = 0.0;

	public MassLoosingBody(String id, Vector2D velocity, Vector2D position, double mass, double lossFactor,
			double lossFrequency) {
		super(id, velocity, position, mass);
		this.lossFactor = lossFactor;
		this.lossFrequency = lossFrequency;
	}

	void move(double t) {
		Vector2D acc;
		if (mass <= 0) {
			acc = new Vector2D(); // Creates a vector set to (0,0).
		} else {
			// Calculates the acceleration
			acc = force.scale(1.0 / mass);

			// Changes the position
			position = position.plus((velocity.scale(t).plus(acc.scale(0.5 * t * t))));

			// Changes velocity
			velocity = velocity.plus(acc.scale(t));

			counter += t;

			if (counter >= lossFrequency) {
				this.mass = mass * (1 - lossFactor);
				counter = 0.0;
			}

		}

	}

}
