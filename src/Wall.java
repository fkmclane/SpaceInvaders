public class Wall extends Invader {
	private int strength;

	public Wall(int strength) {
		this.strength = strength;
	}

	public void shoot() {
		reduceStrength();
	}

	public void reduceStrength() {
		strength--;
		if (strength <= 0)
			removeSelfFromGrid();
	}

	public String getImageSuffix() {
		return Integer.toString(strength);
	}
}
